package com.example.soft.kotlincleanarchitecturetest.presentation.adapters

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.soft.kotlincleanarchitecturetest.R
import com.example.soft.kotlincleanarchitecturetest.domain.model.DPost
import kotlinx.android.synthetic.main.posts_list_item.view.*
import javax.inject.Inject
import kotlin.properties.Delegates

class PostsAdapter @Inject constructor() : RecyclerView.Adapter<PostsAdapter.ViewHolder>() {

    internal var posts: List<DPost> by Delegates.observable(emptyList()) {
        _,_,_ -> notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.posts_list_item, parent, false))

    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {
        viewHolder.bind(posts[position])
    }

    override fun getItemCount() = posts.size

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(post: DPost) {
            itemView.post_id.text = post.id.toString()
            itemView.post_user_id.text = post.userId.toString()
            itemView.post_title.text = post.title
            itemView.post_body.text = post.body
        }
    }
}