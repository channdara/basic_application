package com.example.basic_application.network.services

import com.example.basic_application.mvp.models.Post
import io.reactivex.Single
import retrofit2.http.GET

interface PostService {
    @GET("posts")
    fun getPosts(): Single<ArrayList<Post>>
}