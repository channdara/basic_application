package com.example.basic_application.mvp.views

import com.example.basic_application.mvp.models.Post

interface MainView : BaseView {
    fun onGetPostsSuccess(list: ArrayList<Post>)
}