package com.robelseyoum3.movierepokotlin.networks.movienetwork


import com.robelseyoum3.movierepokotlin.models.moviemodels.MoviePopular
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface MovieRequest {

    @GET("movie/popular")
    fun getMoviesPopular(@Query("api_key") apiKey: String): Call<MoviePopular>

    //@GET("movie/{movie_id}")
    //fun getTopMovieDetails(@Path("movie_id") movieID: Int, @Query("api_key") apiKey: String): Call<android.telecom.Call.Details>
}