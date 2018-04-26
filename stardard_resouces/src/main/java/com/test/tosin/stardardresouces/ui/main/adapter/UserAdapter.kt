package com.test.tosin.stardardresouces.ui.main.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Button
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.request.RequestOptions
import com.test.tosin.stardardresouces.R
import com.test.tosin.stardardresouces.models.Person


typealias ClickHandler = (Person ) -> Unit

class UserAdapter(var list: List<Person>, val then: ClickHandler) :  RecyclerView.Adapter<UserViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_user, parent, false)
        return UserViewHolder(view)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        val person = list[position]

        holder.userName.text = person.completeName
        holder.userEmail.text = person.email ?: "Hasn't email"

        val options = RequestOptions()
        options.centerCrop()
        options.error(R.drawable.ic_person_black)
        options.diskCacheStrategy(DiskCacheStrategy.AUTOMATIC)

        Glide.with(holder.itemView.context)
                .load(person.picture ?: "")
                .into(holder.photo)

        holder.itemView.setOnClickListener {
            then.invoke(person)
        }

    }

}
