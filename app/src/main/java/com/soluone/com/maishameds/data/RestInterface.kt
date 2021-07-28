package com.soluone.com.maishameds.data

import com.soluone.com.maishameds.domain.Post
import retrofit2.http.GET
import rx.Observable

interface RestInterface {
    @GET("sales/api/kyosk")
    fun fetchPosts(): Observable<Post>
}