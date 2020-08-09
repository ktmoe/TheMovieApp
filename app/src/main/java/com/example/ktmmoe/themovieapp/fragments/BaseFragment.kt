package com.example.ktmmoe.themovieapp.fragments

import android.app.Dialog
import android.view.LayoutInflater
import androidx.fragment.app.Fragment
import androidx.lifecycle.LifecycleOwner
import com.example.ktmmoe.shared.mvp.views.BaseView
import com.example.ktmmoe.themovieapp.R

/**
 * Created by ktmmoe on 01, August, 2020
 **/
abstract class BaseFragment: Fragment(), BaseView {

    private var loadingView: Dialog? = null

    override fun showLoading() {
        if (loadingView == null) {
            loadingView = Dialog(requireContext())
        }
        loadingView?.let {
            val view = LayoutInflater.from(requireContext()).inflate(R.layout.layout_loading_dialog, null)
            it.setContentView(view)
            it.setCancelable(false)
            it.show()
            it.window?.setBackgroundDrawable(null)
        }
    }

    override fun hideLoading() {
        loadingView?.let {
            if (it.isShowing) {
                it.cancel()
                loadingView = null
            }
        }
    }

    override fun getOwner(): LifecycleOwner = requireActivity()
}