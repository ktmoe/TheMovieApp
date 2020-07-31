package com.example.ktmmoe.themovieapp.mvp.presenters.impls

import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.LifecycleRegistry
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.example.ktmmoe.themovieapp.data.models.MovieModel
import com.example.ktmmoe.themovieapp.data.models.impls.MockMovieModelImpl
import com.example.ktmmoe.themovieapp.data.models.impls.MovieModelImpl
import com.example.ktmmoe.themovieapp.data.vos.GenreVO
import com.example.ktmmoe.themovieapp.data.vos.MovieVO
import com.example.ktmmoe.themovieapp.mvp.presenters.MovieByGenrePresenter
import com.example.ktmmoe.themovieapp.mvp.views.MainView
import com.example.ktmmoe.themovieapp.mvp.views.MovieByGenreView
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
class MovieByGenrePresenterImplTest {
    private lateinit var mPresenter: MovieByGenrePresenterImpl

    @RelaxedMockK
    private lateinit var mView: MovieByGenreView

    private lateinit var mMovieModel: MovieModel

    @Before
    fun setupPresenter() {
        MockKAnnotations.init(this)

        MovieModelImpl.initDatabase(ApplicationProvider.getApplicationContext())
        mMovieModel = MockMovieModelImpl

        mPresenter = MovieByGenrePresenterImpl()
        mPresenter.initPresenter(mView)
        mPresenter.mMovieModel = this.mMovieModel
    }

    @Test
    fun onUiReady_callDisplayMoviesList(){
        val lifeCycleOwner = Mockito.mock(LifecycleOwner::class.java)
        val lifeCycleRegistry = LifecycleRegistry(lifeCycleOwner)
        lifeCycleRegistry.handleLifecycleEvent(Lifecycle.Event.ON_RESUME)
        Mockito.`when`(lifeCycleOwner.lifecycle).thenReturn(lifeCycleRegistry)

        val genreVo = GenreVO(id = 1)
        mPresenter.onUiReady(lifeCycleOwner, genreVo.id)
        verify {
            mView.displayMoviesList(mutableListOf(MovieVO(), MovieVO(), MovieVO()))
        }
    }
}