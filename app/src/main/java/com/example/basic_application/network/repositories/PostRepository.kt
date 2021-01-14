package com.example.basic_application.network.repositories

import com.example.basic_application.mvp.models.Post
import com.example.basic_application.network.api.NetworkConfig
import com.example.basic_application.network.services.PostService
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

interface PostRepository {
    fun getPosts(): Single<ArrayList<Post>>
}

class PostRepositoryImpl : PostRepository {
    private var networkConfig: NetworkConfig = NetworkConfig()

    override fun getPosts(): Single<ArrayList<Post>> {
        return networkConfig.retrofit()
            .create(PostService::class.java)
            .getPosts()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
    }
}