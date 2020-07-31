package com.example.ktmmoe.themovieapp.activities

import android.content.Context
import android.content.Intent
import android.content.res.ColorStateList
import android.graphics.Color
import android.os.Bundle
import androidx.core.content.ContextCompat
import androidx.lifecycle.ViewModelProviders
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.ktmmoe.themovieapp.R
import com.example.ktmmoe.themovieapp.adapters.CastRecyclerAdapter
import com.example.ktmmoe.themovieapp.adapters.CrewRecyclerAdapter
import com.example.ktmmoe.themovieapp.data.vos.CastVO
import com.example.ktmmoe.themovieapp.data.vos.CrewVO
import com.example.ktmmoe.themovieapp.data.vos.MovieDetailVO
import com.example.ktmmoe.themovieapp.mvp.presenters.MovieDetailPresenter
import com.example.ktmmoe.themovieapp.mvp.presenters.impls.MovieDetailPresenterImpl
import com.example.ktmmoe.themovieapp.mvp.views.MovieDetailView
import com.example.ktmmoe.themovieapp.views.viewpods.HorizontalDescriptionViewPod
import com.example.ktmmoe.themovieapp.views.viewpods.MovieBackDropInfoViewPod
import com.google.android.material.chip.Chip
import kotlinx.android.synthetic.main.activity_movie_detail.*
import kotlinx.android.synthetic.main.appbar_movie_detail.*
import kotlinx.android.synthetic.main.backdrop_movie_detail.*
import kotlinx.android.synthetic.main.backdrop_movie_detail.view.*
import kotlinx.android.synthetic.main.layout_list_actors.*
import kotlinx.android.synthetic.main.layout_list_creators.*
import kotlinx.android.synthetic.main.viewpod_movie_backdrop_info.*

class MovieDetailActivity : BaseActivity(), MovieDetailView {
    private lateinit var mMovieBackDropInfoViewPod: MovieBackDropInfoViewPod
    private lateinit var mCastRecyclerAdapter: CastRecyclerAdapter
    private lateinit var mCrewRecyclerAdapter: CrewRecyclerAdapter

    private lateinit var mViewPodOriginalTitle: HorizontalDescriptionViewPod
    private lateinit var mViewPodType: HorizontalDescriptionViewPod
    private lateinit var mViewPodProduction: HorizontalDescriptionViewPod
    private lateinit var mViewPodPremiere: HorizontalDescriptionViewPod
    private lateinit var mViewPodDescription: HorizontalDescriptionViewPod

    private lateinit var mMovieDetail: MovieDetailVO

    private lateinit var mPresenter: MovieDetailPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_movie_detail)

        val movieId = intent.getIntExtra(MOVIE_ID_EXTRA, 0)

        setupPresenter()

        setupRecyclerViews()
        setupViewPod()
        setupListeners()
        mPresenter.onUiReady(this, movieId)
    }

    private fun setupPresenter() {
        mPresenter = ViewModelProviders.of(this).get(MovieDetailPresenterImpl::class.java)
        mPresenter.initPresenter(this)
    }

    private fun setupRecyclerViews() {
        mCastRecyclerAdapter = CastRecyclerAdapter(mPresenter)
        mCrewRecyclerAdapter = CrewRecyclerAdapter(mPresenter)

        rvActors.adapter = mCastRecyclerAdapter
        rvCreators.adapter = mCrewRecyclerAdapter
    }

    private fun setupViewPod() {
        mMovieBackDropInfoViewPod = viewPodMovieBackDropInfo as MovieBackDropInfoViewPod
        mMovieBackDropInfoViewPod.setDelegate(mPresenter)

        mViewPodOriginalTitle = viewPodOriginalTitle as HorizontalDescriptionViewPod
        mViewPodType = viewPodType as HorizontalDescriptionViewPod
        mViewPodProduction = viewPodProduction as HorizontalDescriptionViewPod
        mViewPodPremiere = viewPodPremiere as HorizontalDescriptionViewPod
        mViewPodDescription = viewPodDescription as HorizontalDescriptionViewPod

    }

    private fun bindData() {
        mMovieBackDropInfoViewPod.setData(mMovieDetail)
        Glide.with(this)
            .load(mMovieDetail.absoluteBackDropPath())
            .apply(RequestOptions().placeholder(R.drawable.ic_launcher_background).error(R.drawable.ic_launcher_background).centerCrop())
            .into(ivMovieBackdrop)
        tvStoryLine.text = mMovieDetail.tagLine
        displayRecycleViews()
        displayMovieDescriptions()
    }

    private fun displayRecycleViews () {
        mCastRecyclerAdapter.setNewData(mMovieDetail.credits.cast.toMutableList())
        mCrewRecyclerAdapter.setNewData(mMovieDetail.credits.crew.toMutableList())

    }

    private fun displayMovieDescriptions() {
        mViewPodOriginalTitle.titleAndDescription("OriginalTitle", mMovieDetail.originalTitle)
        var type = ""
        mMovieDetail.genres.forEach { type += it.name +"," }
        mViewPodType.titleAndDescription("Type", type.substring(0, type.length - 1))
        var country = ""
        mMovieDetail.productionCountries.forEach { country += "${it.name}, ${it.iso},"}
        mViewPodProduction.titleAndDescription("Production", country.substring(0, country.length - 1))
        mViewPodPremiere.titleAndDescription("Premiere", mMovieDetail.releaseDate)
        mViewPodDescription.titleAndDescription("Description", mMovieDetail.overview)
    }

    companion object {
        private const val MOVIE_ID_EXTRA = "movie-id-extra"
        fun newIntent(context: Context, id: Int) : Intent {
            val intent =  Intent(context, MovieDetailActivity::class.java)
            intent.putExtra(MOVIE_ID_EXTRA, id)
            return intent
        }
    }

    override fun displayMovieDetails(movieDetail: MovieDetailVO) {
        mMovieDetail = movieDetail
        bindData()
    }

    override fun showMessageSnackBar(message: String) {
        showSnackBar(message)
    }

    private fun setupListeners(){
        navigatorUp.setOnClickListener { onBackPressed() }
    }
}