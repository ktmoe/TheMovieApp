package com.example.ktmmoe.themovieapp.activities

import android.os.Bundle
import androidx.lifecycle.ViewModelProviders
import com.example.ktmmoe.themovieapp.BuildConfig
import com.example.ktmmoe.themovieapp.R
import com.example.ktmmoe.themovieapp.adapters.*
import com.example.ktmmoe.themovieapp.data.vos.CastVO
import com.example.ktmmoe.themovieapp.data.vos.GenreVO
import com.example.ktmmoe.themovieapp.data.vos.MovieVO
import com.example.ktmmoe.themovieapp.mvp.presenters.MainPresenter
import com.example.ktmmoe.themovieapp.mvp.presenters.impls.MainPresenterImpl
import com.example.ktmmoe.themovieapp.mvp.views.MainView
import kotlinx.android.synthetic.main.layout_list_best_actors.*
import kotlinx.android.synthetic.main.layout_list_popular_movies.*
import kotlinx.android.synthetic.main.layout_list_showcases.*
import kotlinx.android.synthetic.main.layout_movie_by_genre.*
import kotlinx.android.synthetic.main.layout_slider.*

class MainActivity : BaseActivity(), MainView {
    private val dummyImageUrls = listOf("/AqIes6H9NlRoo0YjlO7exLCu72v.jpg", "/c18HVnKTybcAUYVQd8rOcdbqwY.jpg", "/QtSxEuCwcZSfCTMZfER3nHDVsG.jpg")
    private lateinit var mSliderAdapter: SliderAdapter
    private lateinit var mPopularMovieAdapter: MovieRecyclerAdapter
    private lateinit var mShowCaseAdapter: ShowCaseRecyclerAdapter
    private lateinit var mBestActorAdapter: CastRecyclerAdapter

    private lateinit var mPresenter : MainPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setupPresenter()

        setupSliderView()
        setupRecyclers()
        mPresenter.onUiReady(this)
    }

    private fun setupPresenter() {
        mPresenter = ViewModelProviders.of(this).get(MainPresenterImpl::class.java)
        mPresenter.initPresenter(this)
    }

    private fun setupSliderView() {
        mSliderAdapter = SliderAdapter(this, mPresenter)
        sliderView.sliderAdapter = mSliderAdapter
    }

    private fun setupRecyclers() {
        mPopularMovieAdapter = MovieRecyclerAdapter(mPresenter)
        mShowCaseAdapter = ShowCaseRecyclerAdapter()
        mBestActorAdapter = CastRecyclerAdapter(mPresenter)

        mShowCaseAdapter.setNewData(dummyImageUrls.toMutableList())

        rvPopularMovies.adapter = mPopularMovieAdapter
        rvShowCases.adapter = mShowCaseAdapter
        rvBestActor.adapter = mBestActorAdapter
    }

    private fun setupPagerWithTab(genres: List<GenreVO>) {
        val viewPagerAdapter = MovieByGenrePagerAdapter(supportFragmentManager, genres)
        viewpager.adapter = viewPagerAdapter
        viewpager.currentItem = 0
        tabLayout.setupWithViewPager(viewpager)
    }

    override fun displayTop5(list: MutableList<MovieVO>) {
        mSliderAdapter.addMovieList(list)
    }

    override fun displayMoviesList(list: MutableList<MovieVO>) {
        mPopularMovieAdapter.setNewData(list)
    }

    override fun displayGenresList(list: MutableList<GenreVO>) {
        setupPagerWithTab(list)
    }

    override fun displayBestActorsList(list: MutableList<CastVO>) {
        mBestActorAdapter.setNewData(list)
    }

    override fun navigateToMovieDetail(movieId: Int) {
        startActivity(MovieDetailActivity.newIntent(this, movieId))
    }

    override fun navigateToTrailerActivity(movieId: Int) {
        startActivity(TrailerActivity.newIntent(this, movieId))
    }

    override fun showMessageSnackBar(message: String) {
        showSnackBar(message)
    }

}