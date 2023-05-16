package com.example.mycustomviewsarchiterure.content.presentation

import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy


interface NewsUi {
    fun show(textView: TextView, imageView: ImageView)
    class Error(private val message: String) : NewsUi {
        override fun show(textView: TextView, imageView: ImageView) {
            textView.text = message
            imageView.setImageResource(android.R.drawable.ic_dialog_alert)
        }
    }
    data class Base(
        private val loadImmediately: Boolean,
        private val text: String,
        private val imageUrl: String
    ) : NewsUi {
        override fun show(textView: TextView, imageView: ImageView) {
            textView.text = text
            if (loadImmediately) {
                Glide.with(imageView).load(imageUrl).into(imageView)
            } else {
                imageView.setImageResource(android.R.drawable.ic_menu_camera)
                imageView.setOnClickListener {
                    Glide.with(imageView).load(imageUrl).into(imageView)
                }
            }
        }
    }
}