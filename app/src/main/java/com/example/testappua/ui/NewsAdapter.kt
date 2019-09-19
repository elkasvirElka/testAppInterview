package com.example.testappua.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.testappua.R
import com.example.testappua.data.models.ArticleModel
import com.squareup.picasso.Picasso

class NewsAdapter :
    RecyclerView.Adapter<NewsAdapter.ViewHolder>() {

    private var mNews = ArrayList<ArticleModel>()
    private var listener: OnClickAdapterListener? = null

    interface OnClickAdapterListener {
        fun onClickItemNews(data: ArticleModel)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        val view = LayoutInflater.from(parent.context).inflate(
            R.layout.item_news,
            parent,
            false
        )
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return mNews.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        var data = mNews[position]
        holder.bind(data)
        holder.itemView.setOnClickListener { listener?.onClickItemNews(data) }
    }

    fun addList(list: List<ArticleModel>) {
        mNews.addAll(list)
        notifyDataSetChanged()
    }

    fun setOnActionListener(listener: OnClickAdapterListener) {
        this.listener = listener
    }

    fun setList(list: List<ArticleModel>) {
        mNews.clear()
        mNews.addAll(list)
        notifyDataSetChanged()
    }

    inner class ViewHolder(
        itemView: View
    ) : RecyclerView.ViewHolder(itemView) {

        private val picture: ImageView = itemView.findViewById(R.id.picture)
        private val title: TextView = itemView.findViewById(R.id.title)
        val content: TextView = itemView.findViewById(R.id.content)

        fun bind(data: ArticleModel) {

            Picasso.get().load(data.urlToImage).into(picture)

            title.text = data.title
            content.text = (data.content ?: "")
        }
    }


}