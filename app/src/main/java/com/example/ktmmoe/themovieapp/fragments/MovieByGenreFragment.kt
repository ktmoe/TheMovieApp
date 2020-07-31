package com.example.ktmmoe.themovieapp.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import com.example.ktmmoe.themovieapp.R
import com.example.ktmmoe.themovieapp.activities.MovieDetailActivity
import com.example.ktmmoe.themovieapp.adapters.MovieRecyclerAdapter
import com.example.ktmmoe.themovieapp.data.vos.MovieVO
import com.example.ktmmoe.themovieapp.mvp.presenters.MovieByGenrePresenter
import com.example.ktmmoe.themovieapp.mvp.presenters.impls.MovieByGenrePresenterImpl
import com.example.ktmmoe.themovieapp.mvp.views.MovieByGenreView
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.fragment_movie_by_genre.*

/**
 * Created by ktmmoe on 29, July, 2020
 **/
class MovieByGenreFragment : Fragment(), MovieByGenreView {
    private lateinit var mMovieRecyclerAdapter: MovieRecyclerAdapter
    private var genreId : Int? = null

    private lateinit var mPresenter: MovieByGenrePresenter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        genreId = arguments?.getInt(GENRE_ID)
        return inflater.inflate(R.layout.fragment_movie_by_genre, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupPresenter()
        setupRecyclerView()
        mPresenter.onUiReady(this, genreId?:0)
    }

    private fun setupPresenter() {
        mPresenter = ViewModelProviders.of(this).get(MovieByGenrePresenterImpl::class.java)
        mPresenter.initPresenter(this)
    }

    private fun setupRecyclerView() {
        mMovieRecyclerAdapter = MovieRecyclerAdapter(mPresenter)
        rvMovieByGenre.adapter = mMovieRecyclerAdapter
    }

    companion object {
        private const val GENRE_ID = "genre-id"
        fun newInstance(id: Int) : MovieByGenreFragment {
            val bundle: Bundle = Bundle()
            bundle.putInt(GENRE_ID, id)
           val fragment = MovieByGenreFragment()
            fragment.arguments = bundle
            return fragment
        }
    }

    override fun displayMoviesList(list: MutableList<MovieVO>) {
        mMovieRecyclerAdapter.setNewData(list)
    }

    override fun navigateToMovieDetail(movieId: Int) {
        requireActivity().startActivity(MovieDetailActivity.newIntent(requireContext(), movieId))
    }

    override fun showMessageSnackBar(message: String) {
        Snackbar.make(requireView(), message, Snackbar.LENGTH_SHORT).show()
    }

}