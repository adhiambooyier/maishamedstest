package com.soluone.com.maishameds

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.soluone.com.maishameds.data.RestClient
import com.soluone.com.maishameds.data.RestInterface
import com.soluone.com.maishameds.domain.Post
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.schedulers.Schedulers

class PostsViewModel : ViewModel() {
    private val disposable = CompositeDisposable()
    private val restInterface by lazy {
        RestClient.client.create(RestInterface::class.java)
    }
    val posts = MutableLiveData<ArrayList<Post>>()

    fun getPosts() {
        disposable.add(
            restInterface.fetchPosts()
                .subscribeOn(Schedulers.io())
                .subscribe({ apiResult ->
                    posts.postValue(apiResult)
                }) {
                    //Handle Errors
                }
        )
    }
}