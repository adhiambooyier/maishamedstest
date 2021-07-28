package com.soluone.com.maishameds

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.databinding.DataBindingUtil
import com.soluone.com.maishameds.databinding.ActivityMainBinding
import com.soluone.com.maishameds.domain.Post

class MainActivity : AppCompatActivity() {
    private val postsViewModel: PostsViewModel by viewModels()
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.lifecycleOwner = this

        initViewModel()
    }

    private fun initViewModel() {
        postsViewModel.getPosts()
        postsViewModel.posts.observe(this, { results ->
            showPosts(results)
        })
    }

    private fun showPosts(list: ArrayList<Post>) {
        binding.rvPosts.apply {
            adapter = PostsAdapter(list)
        }
    }
}