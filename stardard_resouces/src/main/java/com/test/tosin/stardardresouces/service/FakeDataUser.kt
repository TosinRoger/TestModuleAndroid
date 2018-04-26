package com.test.tosin.stardardresouces.service

import com.test.tosin.stardardresouces.models.Person
import io.reactivex.Observable
import retrofit2.http.GET

interface FakeDataUser {

    @GET("FakeTestData/master/FakeData.json")
    fun getListFakeUser(): Observable<List<Person>>
}