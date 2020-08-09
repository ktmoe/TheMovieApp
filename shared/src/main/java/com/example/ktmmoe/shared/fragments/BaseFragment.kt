package com.example.ktmmoe.shared.fragments

import android.app.Dialog
import android.view.LayoutInflater
import androidx.fragment.app.Fragment
import androidx.lifecycle.LifecycleOwner
import com.example.ktmmoe.shared.mvp.views.BaseView

/**
 * Created by ktmmoe on 01, August, 2020
 **/
abstract class BaseFragment: Fragment(), BaseView {

    private var loadingView: Dialog? = null

    abstract override fun showLoading()

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