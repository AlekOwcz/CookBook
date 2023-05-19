package com.example.cookbookapp

import android.graphics.drawable.Drawable
import android.media.Image
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView

class CaptionedImagesAdapter(private val captions: Array<String>, private val imageIds: IntArray): RecyclerView.Adapter<CaptionedImagesAdapter.ViewHolder>() {
     class ViewHolder(cardView: CardView): RecyclerView.ViewHolder(cardView)
     private var listener: Listener? = null
     interface Listener {
          fun onClick(position: Int)
     }
     public fun setListener(listener: Listener){
          this.listener = listener
     }
     override fun getItemCount(): Int {
          return captions.size
     }

     override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
          val itemView = LayoutInflater.from(parent.context)
               .inflate(R.layout.card_captioned_image, parent, false) as CardView
          return ViewHolder(itemView)
     }

     override fun onBindViewHolder(holder: ViewHolder, position: Int) {
          val cardView: CardView = holder.itemView as CardView
          val imageView: ImageView = cardView.findViewById(R.id.info_image)
          val drawable: Drawable? = ContextCompat.getDrawable(cardView.context, imageIds[position])
          imageView.setImageDrawable(drawable)
          imageView.contentDescription = captions[position]
          val textView: TextView = cardView.findViewById(R.id.info_text)
          textView.text = captions[position]

          cardView.setOnClickListener {
               listener?.onClick(position)
          }
     }
}