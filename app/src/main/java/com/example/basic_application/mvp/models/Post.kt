package com.example.basic_application.mvp.models

class Post(
    var userId: Int,
    var id: Int,
    var title: String,
    var body: String
) {
    val displayID: String get() = "User: $userId Post: $id"
}