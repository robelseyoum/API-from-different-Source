package com.robelseyoum3.movierepokotlin.views.mainview

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.SyncStateContract
import android.view.View
import com.robelseyoum3.movierepokotlin.R
import com.robelseyoum3.movierepokotlin.views.movieviews.MovieActivity
import com.robelseyoum3.movierepokotlin.views.repoviews.RepoActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), View.OnClickListener  {

    override fun onClick(view: View?) {


     when (view!!.id) {

        R.id.btn_popularmovies -> {
            intent = Intent(this, MovieActivity::class.java)

        }

        R.id.btn_githubrepos -> {
            intent = Intent(this, RepoActivity::class.java)
        }
    }
        startActivity(intent)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btn_popularmovies.setOnClickListener(this)
        btn_githubrepos.setOnClickListener(this)
    }

}
