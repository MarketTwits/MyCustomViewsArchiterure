package com.example.mycustomviewsarchiterure.content.content

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.mycustomviewsarchiterure.R

class NewsAdapter : RecyclerView.Adapter<NewsViewHolder>(), ShowNews {
    private val list = mutableListOf<NewsUi>()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsViewHolder =
         NewsViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.news_layout, parent, false)
        )


    override fun getItemCount(): Int = list.size

    override fun onBindViewHolder(holder: NewsViewHolder, position: Int) {
        holder.bind(list[position])
    }

    override fun show(newsUi: List<NewsUi>) {
        list.clear()
        list.addAll(newsUi)
        notifyDataSetChanged() //todo difutils
    }

}

class NewsViewHolder(view: View) : ViewHolder(view){
    private val textView : TextView = itemView.findViewById(R.id.textView)
    private val imageView : ImageView = itemView.findViewById(R.id.imageView)
    fun bind(newsUi: NewsUi){
        newsUi.show(textView, imageView)
    }
}
