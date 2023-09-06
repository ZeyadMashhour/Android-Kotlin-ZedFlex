package com.example.zedflex.data.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.zedflex.data.models.MovieDetails
import com.example.zedflex.databinding.MovieItemBinding

class MovieViewAdapter:RecyclerView.Adapter<MovieViewAdapter.MovieViewHolder>() {

    private var movieList = ArrayList<MovieDetails>()

    class MovieViewHolder(val binding: MovieItemBinding):RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        return MovieViewHolder(MovieItemBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun getItemCount(): Int {
        return movieList.size
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        Glide.with(holder.itemView)
            .load(movieList[position].results[0].image.url)
            .into(holder.binding.imageView)
    }

}