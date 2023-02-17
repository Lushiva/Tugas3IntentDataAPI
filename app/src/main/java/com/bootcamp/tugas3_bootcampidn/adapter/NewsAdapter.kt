package com.bootcamp.tugas3_bootcampidn.adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bootcamp.tugas3_bootcampidn.DetailNewsActivity
import com.bootcamp.tugas3_bootcampidn.R
import com.bootcamp.tugas3_bootcampidn.databinding.ItemRowNewsBinding
import com.bootcamp.tugas3_bootcampidn.model.ArticlesItem
import com.bumptech.glide.Glide

class NewsAdapter() : RecyclerView.Adapter<NewsAdapter.NewsViewHolder>() {

    private var dataNews: List<ArticlesItem> = listOf()

    inner class NewsViewHolder (view: View) : RecyclerView.ViewHolder(view) {

        private val binding = ItemRowNewsBinding.bind(view)

        fun bind(data: ArticlesItem) {
            binding.apply {
                tvJudul.text = data.title
                tvPenulis.text = data.author
                tvTanggalPosting.text = data.publishedAt
                Glide.with(imgNews)
                    .load(data.urlToImage)
                    .error(R.drawable.ic_launcher_background)
                    .into(imgNews)
                itemView.setOnClickListener {
                    val intent = Intent(itemView.context, DetailNewsActivity::class.java)
                    intent.putExtra(DetailNewsActivity.EXTRA_NEWS, data)
                    itemView.context.startActivity(intent)
                }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_row_news,parent, false)
        return NewsViewHolder(view)
    }


    override fun onBindViewHolder(holder: NewsViewHolder, position: Int) {
        return holder.bind(dataNews[position])
    }
    override fun getItemCount(): Int {
        return dataNews.size
    }
    fun setData(data : List<ArticlesItem>){
        dataNews = data
        notifyDataSetChanged()
    }
}