package com.test.tosin.stardardresouces.ui.main

import com.test.tosin.stardardresouces.models.Person

class HomePresenter(val view: HomeActivity): HomeContract.HomePresent {
    private val model = HomeModel(this)

    override fun requestList() {
        view.showLoading(true)
        model.requestList()
    }

    override fun hasError(error: String) {
        view.showLoading(false)
        view.showMessage("Error", error)
        view.setViewRecycler(arrayListOf())
    }

    override fun configList(list: List<Person>) {
        view.showLoading(false)
        view.setViewRecycler(list)
    }

}