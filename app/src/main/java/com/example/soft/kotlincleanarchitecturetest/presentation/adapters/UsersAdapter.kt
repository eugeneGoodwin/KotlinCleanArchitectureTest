package com.example.soft.kotlincleanarchitecturetest.presentation.adapters

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.soft.kotlincleanarchitecturetest.R
import com.example.soft.kotlincleanarchitecturetest.domain.model.DUser
import kotlinx.android.synthetic.main.users_list_item.view.*
import javax.inject.Inject
import kotlin.properties.Delegates

class UsersAdapter @Inject constructor() : RecyclerView.Adapter<UsersAdapter.ViewHolder>() {

    internal var users: List<DUser> by Delegates.observable(emptyList()) {
        _,_,_ -> notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.users_list_item, parent, false))

    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {
        viewHolder.bind(users[position])
    }

    override fun getItemCount() = users.size

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(user: DUser) {
            itemView.user_id.text = user.id.toString()
            itemView.user_uname.text = user.userName
            itemView.user_name.text = user.name
            itemView.user_email.text = user.email
        }
    }
}