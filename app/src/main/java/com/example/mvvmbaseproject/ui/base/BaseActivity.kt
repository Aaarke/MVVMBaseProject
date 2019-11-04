package com.example.mvvmbaseproject.ui.base

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.mvvmbaseproject.R
import com.example.mvvmbaseproject.Utility.Utils
import com.example.mvvmbaseproject.ui.base.ui.base.BaseFragment
import com.example.mvvmbaseproject.ui.base.ui.base.BaseViewModel

abstract class BaseActivity< V : BaseViewModel<*>> : AppCompatActivity(),BaseFragment.Callback {
    private var mViewModel: V? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.base_activity)
        this.mViewModel = if (mViewModel == null) getViewModel() else mViewModel
    }

    abstract fun getViewModel(): V


    fun hideKeyboard(){
        Utils.hideSoftKeyboard(this)
    }



    override fun onFragmentAttached() {

    }

    override fun onFragmentDetached(tag: String) {

    }



}
