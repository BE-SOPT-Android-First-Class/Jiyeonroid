package org.sopt.week4.api

import org.sopt.week4.data.request.RequestLoginData
import org.sopt.week4.data.request.RequestSignUpData
import org.sopt.week4.data.response.ResponseLoginData
import org.sopt.week4.data.response.ResponseSignUpData
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

interface SoptService {
    @POST("/login/signin")
    fun postLogin(@Body body: RequestLoginData): Call<ResponseLoginData>

    @POST("/login/signup")
    fun postSignUp(@Body body: RequestSignUpData): Call<ResponseSignUpData>
}