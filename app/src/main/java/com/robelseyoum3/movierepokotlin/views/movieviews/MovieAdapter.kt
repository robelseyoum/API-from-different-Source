package com.robelseyoum3.movierepokotlin.views.movieviews

import com.robelseyoum3.kotlinrepo.Constants
import com.robelseyoum3.movierepokotlin.R
import kotlinx.android.synthetic.main.movie_row.view.*

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView


import com.robelseyoum3.movierepokotlin.models.moviemodels.MoviePopular
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.movie_row.view.*

class MovieAdapter (private val moviePopular: MoviePopular)
    : RecyclerView.Adapter<MovieViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        return MovieViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.movie_row, parent, false))
    }

    override fun getItemCount(): Int {
        return moviePopular.results.size
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        holder.tvTitle.text = moviePopular.results[position].title
        Picasso.get().load(Constants.PICTURE_PATH+moviePopular.results[position].poster_path).into(holder.image)
        holder.tvOverView.text = moviePopular.results[position].overview
        holder.ratingbar.rating = moviePopular.results[position].vote_average.toFloat()

    }

}

class MovieViewHolder (view: View) : RecyclerView.ViewHolder(view){

    val tvTitle = view.tv_title
    val tvOverView = view.tv_overview
    val image = view.tv_image
    val ratingbar = view.rb_vote

}


