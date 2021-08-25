package org.sopt.androidseminar.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ServiceCreator { //ServiceImpl

    private const val BASE_URL = "http://cherishserver.com"

    private val retrofit: Retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    val soptService: SoptService = retrofit.create(SoptService::class.java)

    private const val GITHUB_BASE_URL = "https://api.github.com"

    private val retrofit_github: Retrofit =
        Retrofit.Builder()
            .baseUrl(GITHUB_BASE_URL)
            .addConverterFactory(
                GsonConverterFactory.create()
            ).build()
    val githubService: GithubService = retrofit_github.create(GithubService::class.java)
}