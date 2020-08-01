package com.example.ktmmoe.themovieapp.activities

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.lifecycle.ViewModelProviders
import com.example.ktmmoe.themovieapp.R
import com.example.ktmmoe.themovieapp.mvp.presenters.TrailerPresenter
import com.example.ktmmoe.themovieapp.mvp.presenters.impls.TrailerPresenterImpl
import com.example.ktmmoe.themovieapp.mvp.views.TrailerView
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.YouTubePlayer
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.listeners.AbstractYouTubePlayerListener
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.views.YouTubePlayerView
import kotlinx.android.synthetic.main.activity_you_tube_player.*

class TrailerActivity : BaseActivity(), TrailerView {

    private lateinit var mTrailerView: YouTubePlayerView

    private lateinit var mPresenter : TrailerPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_you_tube_player)
        val movieId = intent.getIntExtra(MOVIE_ID_EXTRA, 0)

        setupPresenter()
        setupYouTubePlayer()

        mPresenter.onUiReady(movieId)
    }

    private fun setupPresenter() {
        mPresenter = ViewModelProviders.of(this).get(TrailerPresenterImpl::class.java)
        mPresenter.initPresenter(this)
    }

    private fun setupYouTubePlayer() {
        mTrailerView = youtubePlayerView as YouTubePlayerView
        lifecycle.addObserver(mTrailerView)
    }

    override fun playVideo(videoKey: String) {
        mTrailerView.addYouTubePlayerListener(object : AbstractYouTubePlayerListener(){
            override fun onReady(youTubePlayer: YouTubePlayer) {
                youTubePlayer.loadVideo(videoKey, 0f)
            }
        })
    }

    override fun showMessageSnackBar(message: String) {
        showSnackBar(message)
    }

    companion object {
        private const val MOVIE_ID_EXTRA = "movie-id-extra"
        fun newIntent(context: Context, id: Int) : Intent {
            val intent =  Intent(context, TrailerActivity::class.java)
            intent.putExtra(MOVIE_ID_EXTRA, id)
            return intent
        }
    }
}