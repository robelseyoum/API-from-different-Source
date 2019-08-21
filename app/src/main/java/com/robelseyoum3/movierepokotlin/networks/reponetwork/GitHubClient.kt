package com.robelseyoum3.movierepokotlin.networks.reponetwork


import com.robelseyoum3.movierepokotlin.models.repomodels.GithubRepoModel
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path


interface GitHubClient {

    @GET ("/users/{user}/repos") //{user} is a placeholder
    fun getRepos(@Path("user") user: String): Call<List<GithubRepoModel>>
}