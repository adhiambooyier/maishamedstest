package com.soluone.com.maishameds.data

import com.soluone.com.maishameds.domain.Post
import io.reactivex.rxjava3.core.Observable
import retrofit2.http.GET

interface RestInterface {
    @GET("posts")
    fun fetchPosts(): Observable<ArrayList<Post>>
}