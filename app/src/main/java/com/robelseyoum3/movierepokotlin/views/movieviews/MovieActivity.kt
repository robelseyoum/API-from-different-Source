package com.robelseyoum3.movierepokotlin.views.movieviews

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import com.robelseyoum3.kotlinrepo.Constants
import com.robelseyoum3.movierepokotlin.networks.movienetwork.MovieRequest
import com.robelseyoum3.movierepokotlin.R
import com.robelseyoum3.movierepokotlin.models.moviemodels.MoviePopular
import com.robelseyoum3.movierepokotlin.models.moviemodels.Results
import com.robelseyoum3.movierepokotlin.networks.movienetwork.RetrofitInstances
import kotlinx.android.synthetic.main.activity_movie.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MovieActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_movie)

        val movieRequest = RetrofitInstances().retrofitInstances.create(MovieRequest::class.java)

        val call = movieRequest.getMoviesPopular(Constants.API_KEY)

        call.enqueue(object : Callback<MoviePopular>{

            override fun onFailure(call: Call<MoviePopular>, t: Throwable) {

            }

            override fun onResponse(call: Call<MoviePopular>, response: Response<MoviePopular>) {
                val res = response.body()
               // Log.d("MainActivity", res!!.results[1].title
                getTopMoviesList(res!!)
            }

        })
    }

    fun getTopMoviesList(moviePopular: MoviePopular){

        val adapter = MovieAdapter(moviePopular)

        rvList.layoutManager = LinearLayoutManager(this@MovieActivity)
        rvList.adapter = adapter
    }


}
