package com.example.zedflex.presentation.ui.fragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.zedflex.R
import com.example.zedflex.databinding.FragmentPopularBinding
import com.example.zedflex.presentation.viewmodel.MainViewModel


class PopularFragment : Fragment() {
    private lateinit var binding: FragmentPopularBinding

    private lateinit var mainMvvm: MainViewModel

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
        mainMvvm.getPopularMoviesId()

        observePopularMoviesLiveData()
    }

    private fun observePopularMoviesLiveData() {
        mainMvvm.observePopularMoviesLiveData().observe(viewLifecycleOwner, Observer<List<String>> { moviesList ->
            binding.textViewMoviesList.text = moviesList.joinToString("\n")
            Log.d("API1","${moviesList}")
        })
    }


}