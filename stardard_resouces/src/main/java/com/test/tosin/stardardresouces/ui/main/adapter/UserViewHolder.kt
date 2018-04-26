package com.test.tosin.stardardresouces.ui.main.adapter

import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import kotlinx.android.synthetic.main.item_user.view.*

class UserViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    val photo: ImageView    = itemView.imageView_itemUser_picture
    val userName: TextView  = itemView.textView_itemUser_name
    val userEmail: TextView = itemView.textView_itemUser_email
}