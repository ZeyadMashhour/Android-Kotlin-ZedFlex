package com.example.zedflex.presentation.ui.fragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import com.example.zedflex.data.adapters.MovieViewAdapter
import com.example.zedflex.data.models.MovieDetails
import com.example.zedflex.databinding.FragmentPopularBinding
import com.example.zedflex.presentation.viewmodel.MainViewModel

class PopularFragment : Fragment() {
    private lateinit var binding: FragmentPopularBinding
    private lateinit var mainMvvm: MainViewModel
    private var movieList = ArrayList<MovieDetails>()

    private lateinit var popularMovieAdapter:MovieViewAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mainMvvm = ViewModelProvider(this)[MainViewModel::class.java]
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentPopularBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Fetch popular movies and observe them
        mainMvvm.getPopularMoviesId()
        observePopularMoviesLiveData()
//        preparePopularMovieRecyclerView()
    }

    private fun preparePopularMovieRecyclerView() {
        binding.rvPopularMovies.apply {
            layoutManager= GridLayoutManager(context, 2, GridLayoutManager.HORIZONTAL, false)
            adapter = popularMovieAdapter
        }
    }

    private fun observeMovieDetailsLiveData() {
        mainMvvm.observeMovieDetailsLiveData().observe(viewLifecycleOwner, Observer { movieDetails ->
            if (movieDetails != null) {
                movieList.add(movieDetails)
//                Log.d("API MD", movieList.toString())

            } else {
                Log.d("API1", "Movie details are null in pofrag")
            }
        })
    }


    private fun observePopularMoviesLiveData() {
        mainMvvm.observePopularMoviesLiveData().observe(viewLifecycleOwner, Observer<List<String>> { moviesList ->
            val modifiedList = moviesList.map { it.replace("/title/tt", "tt").removeSuffix("/") }
            MainViewModel.moviesIds = modifiedList
            Log.d("API1", modifiedList.toString())
            getTopMoviesDetails(modifiedList)
        })
    }

    private fun getTopMoviesDetails(idList:List<String>){
        for (i in 0 until 10) {
            val item = idList[i]
            mainMvvm.getMovieDetails(item)
            observeMovieDetailsLiveData()
        }
    }


}
