package com.example.basic_application.mvp.models

class Post(
    var userId: Int,
    var id: Int,
    var title: String,
    var body: String
) {
    companion object {
        val dummy = arrayListOf<Post>(
            Post(1, 1, "1", "1"),
            Post(1, 1, "1", "1"),
            Post(1, 1, "1", "1"),
            Post(1, 1, "1", "1"),
            Post(1, 1, "1", "1"),
            Post(1, 1, "1", "1"),
            Post(1, 1, "1", "1"),
            Post(1, 1, "1", "1"),
            Post(1, 1, "1", "1"),
            Post(1, 1, "1", "1"),
            Post(1, 1, "1", "1"),
            Post(1, 1, "1", "1"),
            Post(1, 1, "1", "1"),
            Post(1, 1, "1", "1"),
            Post(1, 1, "1", "1"),
            Post(1, 1, "1", "1"),
            Post(1, 1, "1", "1"),
            Post(1, 1, "1", "1"),
            Post(1, 1, "1", "1"),
            Post(1, 1, "1", "1"),
            Post(1, 1, "1", "1"),
            Post(1, 1, "1", "1"),
            Post(1, 1, "1", "1"),
        )
    }
}