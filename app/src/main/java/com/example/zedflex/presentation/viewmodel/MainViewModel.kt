package com.example.zedflex.presentation.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.e_commerce.data.retrofit.IMDbApi
import com.example.zedflex.data.retrofit.RetrofitInstance
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainViewModel : ViewModel() {

    private lateinit var popularMoviesLiveData: MutableLiveData<List<String>>

    init {
        popularMoviesLiveData = MutableLiveData()
    }



    fun getPopularMoviesId() {
        val imDbApi = RetrofitInstance.instance.create(IMDbApi::class.java)
        imDbApi.getPopularMovies().enqueue(object : Callback<List<String>> {
            override fun onResponse(call: Call<List<String>>, response: Response<List<String>>) {
                if (response.isSuccessful) {
                    Log.d("API","${response.body()}")
                    popularMoviesLiveData.value = response.body()
                } else {
                    return
                }
            }

            override fun onFailure(call: Call<List<String>>, t: Throwable) {
                Log.e("title", "Failure: ${t.message.toString()}")
            }
        })
    }

    fun observePopularMoviesLiveData(): LiveData<List<String>> {
        return popularMoviesLiveData
    }
}
