package com.example.mvvmbaseproject.ui.main

import android.os.Bundle
import androidx.lifecycle.ViewModelProviders
import com.example.mvvmbaseproject.R
import com.example.mvvmbaseproject.ui.base.BaseActivity

class MainActivity : BaseActivity<MainViewModel>() {
    private var mMainViewModel: MainViewModel? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.container, MainFragment.newInstance())
                .commitNow()
        }

        fetchDataFromServer()
    }

    override fun getViewModel(): MainViewModel {
        mMainViewModel = ViewModelProviders.of(this).get(MainViewModel::class.java)
        return mMainViewModel as MainViewModel
    }


    private fun fetchDataFromServer(){
        mMainViewModel?.fetchData(this)
    }


}
