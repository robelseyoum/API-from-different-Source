package com.robelseyoum3.movierepokotlin.models.moviemodels

import com.google.gson.annotations.SerializedName
import com.robelseyoum3.movierepokotlin.models.moviemodels.Results

data class MoviePopular (

	@SerializedName("page") val page : Int,
	@SerializedName("total_results") val total_results : Int,
	@SerializedName("total_pages") val total_pages : Int,
	@SerializedName("results") val results : List<Results>
)