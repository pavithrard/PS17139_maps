package com.example.ps17139_maps

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView


    class adapter(
        private val context: Context,
        private val map: List<Map>,
        val onClickListener: OnClickListener) : RecyclerView.Adapter<adapter.ViewHolder>() {
        interface OnClickListener {
            fun onItemClick(position: Int)
        }

        class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
            val textCard: TextView = itemView.findViewById(R.id.textCard)
        }

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
            val view = LayoutInflater.from(context).inflate(R.layout.card_view, parent, false)
            return ViewHolder(view)
        }

        override fun getItemCount(): Int {
            return map.size
        }

        override fun onBindViewHolder(holder: ViewHolder, position: Int) {
            val uni = map[position]
            holder.textCard.text = uni.title
            holder.itemView.setOnClickListener {
                //Log.i(Tag,"$position")
                onClickListener.onItemClick(position)
            }

            //val textViewTitle:TextView=holder.itemView.findViewById(R.id.textCard)
            //textViewTitle.text=uni.title.toString()
        }
    }

