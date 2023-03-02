package com.example.applock

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class RecyclerAdapter(title: Array<String>, text: Array<String>, images: Array<Int>): RecyclerView.Adapter<RecyclerAdapter.ViewHolder>() {


    var title1 =title
    var text1= text
    var images1 = images

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v= LayoutInflater.from(parent.context).inflate(R.layout.item,parent,false)
        return ViewHolder(v)
    }

    override fun getItemCount(): Int {
       return  title1.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
       holder.itemTitle.text= title1[position]
        holder.itemText.text= text1[position]
        holder.itemImage.setImageResource(images1[position])
    }


    inner class ViewHolder (itemView: View): RecyclerView.ViewHolder(itemView){

        var itemImage: ImageView
        var itemTitle: TextView
        var itemText: TextView

        init{
            itemImage= itemView.findViewById(R.id.iv_image)
            itemTitle=itemView.findViewById(R.id.tv_name)
            itemText= itemView.findViewById(R.id.tv_text)
        }
    }

}