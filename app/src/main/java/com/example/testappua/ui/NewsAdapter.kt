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

    private var mDialogs = ArrayList<ArticleModel>()
    private lateinit var listener: OnClickAdapterListener

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.item_news,
                parent,
                false
            ), listener
        )
    }

    override fun getItemCount(): Int {
        return mDialogs.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        var data = mDialogs[position]
        holder.bind(data)
        //holder.itemView.setOnClickListener { data }
    }

    fun addList(list: List<ArticleModel>) {
        mDialogs.addAll(list)
        notifyDataSetChanged()
    }
 fun  setOnActionListener(listener: OnClickAdapterListener){
     this.listener = listener
 }
    fun setList(list: List<ArticleModel>) {
        mDialogs.clear()
        mDialogs.addAll(list)
        notifyDataSetChanged()
    }

    fun getData(position: Int) = mDialogs[position]

    fun clear() {
        mDialogs.clear()
        notifyDataSetChanged()
    }

    inner class ViewHolder(
        itemView: View,
        private val listener: OnClickAdapterListener
    ) : RecyclerView.ViewHolder(itemView), View.OnClickListener {

        private val picture: ImageView = itemView.findViewById(R.id.picture)
        private val title: TextView = itemView.findViewById(R.id.title)
        private val content: TextView = itemView.findViewById(R.id.content)

        fun bind(data: ArticleModel) {

            Picasso.get().load(data.urlToImage).into(picture)

            title.text = data.title
            content.text = (data.content ?: "")

            itemView.setOnClickListener { data }
        }

        override fun onClick(v: View?) {
            listener.onClickItemNews(getData(adapterPosition))
        }
    }

    interface OnClickAdapterListener {
        fun onClickItemNews(data: ArticleModel)
    }

}