package com.example.basic_application.mvp.views

interface BaseView {
    fun onLoading()
    fun onError(message: String)
}