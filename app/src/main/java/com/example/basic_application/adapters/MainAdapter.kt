package com.example.basic_application.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.basic_application.R
import com.example.basic_application.mvp.models.Post
import kotlinx.android.synthetic.main.item_main_recycler_view.view.*

class MainAdapter(
    private val list: ArrayList<Post>,
    private val listener: MainRecyclerViewListener
) : RecyclerView.Adapter<MainAdapter.MainViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.item_main_recycler_view, parent, false)
        return MainViewHolder(view)
    }

    override fun onBindViewHolder(holder: MainViewHolder, position: Int) =
        holder.bind(list[holder.adapterPosition])

    override fun getItemCount(): Int = if (list.isNullOrEmpty()) 0 else list.size

    inner class MainViewHolder(private val view: View) : RecyclerView.ViewHolder(view) {
        fun bind(post: Post) {
            view.apply {
                item_tv_number.text = post.displayID
                item_tv_title.text = post.title
                item_tv_body.text = post.body
            }
            itemView.setOnClickListener { listener.onItemPressed(post) }
        }
    }
}

interface MainRecyclerViewListener {
    fun onItemPressed(post: Post)
}