package com.test.tosin.stardardresouces.ui.main

import com.test.tosin.stardardresouces.service.FakeDataUser
import com.test.tosin.stardardresouces.service.RemoteRepository
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class HomeModel(private val presenter: HomePresenter): HomeContract.HomeModel {

    override fun requestList() {
        val service: FakeDataUser = RemoteRepository.createService(FakeDataUser::class.java)

        service.getListFakeUser()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({ response ->
                    kotlin.run {
                        presenter.configList(response ?: arrayListOf())
                    }
                }, { exception ->
                    kotlin.run {
                        presenter.hasError(exception.localizedMessage)
                    }
                })
    }

}