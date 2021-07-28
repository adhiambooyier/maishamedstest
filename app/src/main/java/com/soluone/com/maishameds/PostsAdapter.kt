package com.soluone.com.maishameds

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.soluone.com.maishameds.databinding.ItemPostBinding
import com.soluone.com.maishameds.domain.Post

class PostsAdapter(private val postsList: ArrayList<Post>) :
    RecyclerView.Adapter<PostsAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostsAdapter.ViewHolder {
        val viewBinding =
            ItemPostBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(viewBinding)
    }

    override fun onBindViewHolder(holder: PostsAdapter.ViewHolder, position: Int) {
        val postItem = postsList[holder.adapterPosition]
        holder.bindItems(postItem)
    }

    override fun getItemCount(): Int = postsList.size

    inner class ViewHolder(private val viewBinding: ItemPostBinding) :
        RecyclerView.ViewHolder(viewBinding.root) {

        fun bindItems(post: Post) {
            viewBinding.txtUser.text = post.userId.toString()

            viewBinding.txtTitle.text = post.title

            viewBinding.txtBody.text = post.body
        }
    }
}