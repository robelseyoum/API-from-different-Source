package com.robelseyoum3.movierepokotlin.views.repoviews

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.robelseyoum3.movierepokotlin.R
import com.robelseyoum3.movierepokotlin.models.repomodels.GithubRepoModel
import kotlinx.android.synthetic.main.repo_row.view.*

class RepoAdapter (private val githubRepoModel: List<GithubRepoModel>): RecyclerView.Adapter<RepoViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RepoViewHolder {
        return RepoViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.repo_row, parent, false))
    }

    override fun getItemCount(): Int {
        return githubRepoModel.size
    }

    override fun onBindViewHolder(holder: RepoViewHolder, position: Int) {
        holder.tvName.text = githubRepoModel[position].name
        holder.tvLanguage.text = githubRepoModel[position].language
    }
}


class RepoViewHolder (view: View): RecyclerView.ViewHolder(view){
    val tvName = view.tv_name
    val tvLanguage = view.tv_language

}