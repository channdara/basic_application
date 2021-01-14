package com.example.basic_application.activities

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.basic_application.R
import com.example.basic_application.adapters.MainAdapter
import com.example.basic_application.adapters.MainRecyclerViewListener
import com.example.basic_application.mvp.models.Post
import com.example.basic_application.mvp.presenters.MainPresenter
import com.example.basic_application.mvp.views.MainView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), MainView {
    private lateinit var presenter: MainPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        presenter = MainPresenter(this)
        presenter.getPosts()
    }

    override fun onDestroy() {
        super.onDestroy()
        presenter.dispose()
    }

    override fun onLoading() {
        main_recycler_view.visibility = View.GONE
        main_progress_bar.visibility = View.VISIBLE
        main_tv_error.visibility = View.GONE
    }

    override fun onError(message: String) {
        main_recycler_view.visibility = View.GONE
        main_progress_bar.visibility = View.GONE
        main_tv_error.text = message
        main_tv_error.visibility = View.VISIBLE
    }

    override fun onGetPostsSuccess(list: ArrayList<Post>) {
        main_recycler_view.visibility = View.VISIBLE
        main_progress_bar.visibility = View.GONE
        main_tv_error.visibility = View.GONE
        main_recycler_view.apply {
            layoutManager = LinearLayoutManager(this@MainActivity)
            adapter = MainAdapter(list, object : MainRecyclerViewListener {
                override fun onItemPressed(post: Post) {
                    Toast.makeText(this@MainActivity, post.title, Toast.LENGTH_SHORT).show()
                }
            })
        }
    }
}