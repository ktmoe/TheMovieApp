package com.example.ktmmoe.themovieapp.activities

import android.app.Dialog
import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.LifecycleOwner
import com.example.ktmmoe.themovieapp.R
import com.example.ktmmoe.themovieapp.mvp.views.BaseView
import com.google.android.material.snackbar.Snackbar

/**
 * Created by ktmmoe on 25, July, 2020
 **/
abstract class BaseActivity: AppCompatActivity(), BaseView {
    private var loadingView: Dialog? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    fun showSnackBar (message: String) {
        Snackbar.make(window.decorView, message, Snackbar.LENGTH_SHORT).show()
    }

    override fun showLoading() {
       if (loadingView == null) {
           loadingView = Dialog(this)
       }
        loadingView?.let {
            val view = LayoutInflater.from(this).inflate(R.layout.layout_loading_dialog, null)
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

    override fun getOwner(): LifecycleOwner = this

}