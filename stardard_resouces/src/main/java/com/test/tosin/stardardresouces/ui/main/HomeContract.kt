package com.test.tosin.stardardresouces.ui.main

import com.test.tosin.stardardresouces.models.Person

abstract class HomeContract {

    interface HomeView {
        fun setViewRecycler(list: List<Person>)
        fun showLoading(show: Boolean)
        fun showMessage(title: String, message: String)
    }

    interface HomePresent {
        fun requestList()
        fun hasError(error: String)
        fun configList(list: List<Person>)
    }

    interface HomeModel {
        fun requestList()
    }
}