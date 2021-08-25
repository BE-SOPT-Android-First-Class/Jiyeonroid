package org.sopt.androidseminar.api

import org.sopt.androidseminar.data.request.RequestLoginData
import org.sopt.androidseminar.data.request.RequestSignUpData
import org.sopt.androidseminar.data.response.ResponseLoginData
import org.sopt.androidseminar.data.response.ResponseSignUpData
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

interface SoptService {
    @POST("/login/signin")
    fun postLogin(
        @Body body: RequestLoginData
    ): Call<ResponseLoginData>

    @POST("login/signup")
    fun postSignUp(
        @Body body: RequestSignUpData
    ): Call<ResponseSignUpData>
}