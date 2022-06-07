package com.rival.my_packet.api

import com.rival.my_packet.model.ResponseDashboard
import com.rival.my_packet.model.ResponseLanding
import retrofit2.Call
import retrofit2.http.GET

interface ApiServices {

    @GET("landing")
    fun getlanding(): Call<ResponseLanding>

    @GET("dashboard")
    fun getdashboard(): Call<ResponseDashboard>
}