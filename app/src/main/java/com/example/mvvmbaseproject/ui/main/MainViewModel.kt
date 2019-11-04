package com.example.mvvmbaseproject.ui.main

import RestClient
import android.content.Context
import androidx.lifecycle.MutableLiveData
import com.example.mvvmbaseproject.model.Example
import com.example.mvvmbaseproject.ui.base.ui.base.BaseViewModel
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.observers.DisposableSingleObserver
import io.reactivex.schedulers.Schedulers

class MainViewModel : BaseViewModel<Any>() {
    var data = MutableLiveData<Example>()
    var dataLoadError = MutableLiveData<Boolean>()
    var loading = MutableLiveData<Boolean>()
    private val compositeDisposable = CompositeDisposable()


    fun fetchData(context: Context){
        loading.value = true
        compositeDisposable.add(
            RestClient.getApiInterface(context).dataFromServer
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(object : DisposableSingleObserver<Example>() {
                    override fun onSuccess(example: Example) {
                        data.value = example
                        dataLoadError.value = false
                        loading.value = false
                    }

                    override fun onError(throwable: Throwable) {
                        dataLoadError.value = true
                        loading.value = false
                        throwable.printStackTrace()
                    }

                })
        )

    }

}
