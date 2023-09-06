package com.example.e_commerce.data.retrofit


import com.example.zedflex.data.models.MovieDetails
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface IMDbApi {

    @GET("title/find")
    fun getMovieDetails(@Query("q") query: String): Call<MovieDetails>

    @GET("title/get-most-popular-movies")
    fun getPopularMovies(): Call<List<String>>


}