package com.example.ktmmoe.themovieapp.adapters

import android.util.Log
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter
import com.example.ktmmoe.themovieapp.data.vos.GenreVO
import com.example.ktmmoe.themovieapp.fragments.MovieByGenreFragment

/**
 * Created by ktmmoe on 29, July, 2020
 **/
class MovieByGenrePagerAdapter(fm: FragmentManager, private val genres: List<GenreVO>) :
    FragmentStatePagerAdapter(fm, genres.count()) {

    override fun getItem(position: Int): Fragment {
        return MovieByGenreFragment.newInstance(genres[position].id)
    }

    override fun getCount(): Int {
        return genres.count()
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return genres[position].name
    }

}