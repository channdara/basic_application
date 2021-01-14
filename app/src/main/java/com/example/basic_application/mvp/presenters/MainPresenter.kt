package com.example.basic_application.mvp.presenters

import com.example.basic_application.mvp.models.Post
import com.example.basic_application.mvp.views.MainView
import com.example.basic_application.network.repositories.PostRepository
import com.example.basic_application.network.repositories.PostRepositoryImpl
import io.reactivex.SingleObserver
import io.reactivex.disposables.Disposable

class MainPresenter(private val view: MainView) : BasePresenter() {
    private val repo: PostRepository = PostRepositoryImpl()

    fun getPosts() {
        repo.getPosts().subscribe(object : SingleObserver<ArrayList<Post>> {
            override fun onSubscribe(d: Disposable) {
                view.onLoading()
                addCompositeDisposable(d)
            }

            override fun onSuccess(t: ArrayList<Post>) {
                view.onGetPostsSuccess(t)
            }

            override fun onError(e: Throwable) {
                view.onError(e.message ?: "Unknown Error")
            }
        })
    }
}