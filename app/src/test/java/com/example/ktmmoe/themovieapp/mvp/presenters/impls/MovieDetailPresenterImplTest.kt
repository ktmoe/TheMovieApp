package com.example.ktmmoe.themovieapp.mvp.presenters.impls

import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.LifecycleRegistry
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.example.ktmmoe.themovieapp.data.models.MovieModel
import com.example.ktmmoe.themovieapp.data.models.impls.MockMovieModelImpl
import com.example.ktmmoe.themovieapp.data.models.impls.MovieModelImpl
import com.example.ktmmoe.themovieapp.data.vos.MovieDetailVO
import com.example.ktmmoe.themovieapp.data.vos.MovieVO
import com.example.ktmmoe.themovieapp.mvp.views.MovieByGenreView
import com.example.ktmmoe.themovieapp.mvp.views.MovieDetailView
import io.mockk.MockKAnnotations
import io.mockk.impl.annotations.RelaxedMockK
import io.mockk.verify
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mockito
import org.robolectric.annotation.Config

/**
 * Created by ktmmoe on 31, July, 2020
 **/

@RunWith(AndroidJUnit4::class)
@Config(manifest = Config.NONE)
class MovieDetailPresenterImplTest {
    private lateinit var mPresenter: MovieDetailPresenterImpl

    @RelaxedMockK
    private lateinit var mView: MovieDetailView

    private lateinit var mMovieModel: MovieModel

    @Before
    fun setupPresenter() {
        MockKAnnotations.init(this)

        MovieModelImpl.initDatabase(ApplicationProvider.getApplicationContext())
        mMovieModel = MockMovieModelImpl

        mPresenter = MovieDetailPresenterImpl()
        mPresenter.initPresenter(mView)
        mPresenter.mMovieModel = this.mMovieModel
    }

    @Test
    fun onUiReady_calDisplayMovieDetail() {
        val lifeCycleOwner = Mockito.mock(LifecycleOwner::class.java)
        val lifeCycleRegistry = LifecycleRegistry(lifeCycleOwner)
        lifeCycleRegistry.handleLifecycleEvent(Lifecycle.Event.ON_RESUME)
        Mockito.`when`(lifeCycleOwner.lifecycle).thenReturn(lifeCycleRegistry)

        val movieVO = MovieVO(id = 3)
        mPresenter.onUiReady(lifeCycleOwner, movieVO.id)

        verify {
            mView.displayMovieDetails(MovieDetailVO(id = movieVO.id))
        }
    }
}