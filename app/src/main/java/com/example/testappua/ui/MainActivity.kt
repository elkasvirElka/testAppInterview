package com.example.testappua.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ProgressBar
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.testappua.ui.fragment.webView.FragmentWebView
import com.example.testappua.MyApplication
import com.example.testappua.R
import com.example.testappua.data.models.ArticleModel
import javax.inject.Inject

class MainActivity : AppCompatActivity(), NewsAdapter.OnClickAdapterListener {

    private lateinit var newsRecycler : RecyclerView
    private lateinit var mLayoutManager: LinearLayoutManager
    private lateinit var adapter: NewsAdapter
    private lateinit var progressBar: ProgressBar
    @Inject
    lateinit var mViewModel: NewsViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        MyApplication.getApp(this).getAppComponent().createMainComponent().injectDayForecastActivity(this)
        newsRecycler = findViewById(R.id.news_recycler)
        progressBar = findViewById(R.id.progress_bar)
        mLayoutManager = LinearLayoutManager(this)
        newsRecycler.layoutManager = mLayoutManager
        adapter = NewsAdapter()
        adapter.setOnActionListener(this)
        newsRecycler.adapter = adapter

        mViewModel.action(NewsAction.FetchNews)

        mViewModel.view.observe(this, Observer { state ->
            state?.let { render(it) }
        })
    }

    private fun addFragmentToActivity(
        fragmentManager: androidx.fragment.app.FragmentManager,
        fragment: androidx.fragment.app.Fragment, frameId: Int
    ) {
        val transaction = fragmentManager.beginTransaction()
        transaction.add(frameId, fragment)
        transaction.addToBackStack(null)
        transaction.commit()
    }


    override fun onClickItemNews(data: ArticleModel) {
        addFragmentToActivity(supportFragmentManager, FragmentWebView.newInstance(data.url), R.id.main_container)
    }

    fun showProgressBar() {
        progressBar.visibility = View.VISIBLE
    }

    fun hideProgressBar() {
        progressBar.visibility = View.GONE
    }

    private fun render(state: NewsViewState) {
        when (state) {
            is NewsViewState.Loading -> showProgressBar()
            is NewsViewState.Success -> {
                adapter.setList(state.article)
                hideProgressBar()

            }
            is NewsViewState.Failure -> {
                hideProgressBar()
                Toast.makeText(this, state.message, Toast.LENGTH_SHORT).show()
            }
        }
    }

}
