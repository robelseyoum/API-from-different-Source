package com.robelseyoum3.movierepokotlin.views.repoviews

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import com.robelseyoum3.kotlinrepo.Constants
import com.robelseyoum3.movierepokotlin.R
import com.robelseyoum3.movierepokotlin.models.repomodels.GithubRepoModel
import com.robelseyoum3.movierepokotlin.networks.reponetwork.GitHubClient
import com.robelseyoum3.movierepokotlin.networks.reponetwork.RetrofitInstances
import kotlinx.android.synthetic.main.activity_repo.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class RepoActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_repo)


        val getHubClient = RetrofitInstances().retrofitInstances.create(GitHubClient::class.java)

        val call = getHubClient.getRepos(Constants.USERNAME)

        call.enqueue(object : Callback<List<GithubRepoModel>> {
            override fun onFailure(call: Call<List<GithubRepoModel>>, t: Throwable) {

            }

            override fun onResponse(call: Call<List<GithubRepoModel>>, response: Response<List<GithubRepoModel>>) {
                val res = response.body()
                Log.d("First Repo", res!![0].name)

                getGithupList(res)
            }

        })
    }

    fun getGithupList(githubRepoModel: List<GithubRepoModel>){

        val adapter = RepoAdapter(githubRepoModel)


        rvList.layoutManager = LinearLayoutManager(this@RepoActivity)
        rvList.adapter = adapter

    }


}
