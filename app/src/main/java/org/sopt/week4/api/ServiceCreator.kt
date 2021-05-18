package org.sopt.week4.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ServiceCreator {
    private const val BASE_URL = "http://cherishserver.com"
    private val retrofit: Retrofit =
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    val soptService: SoptService = retrofit.create(SoptService::class.java)

    private const val GITHUB_BASE_URL = "http://api.github.com"
    private val githubRetrofit: Retrofit =
        Retrofit.Builder()
            .baseUrl(GITHUB_BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    val githubService: GithubService = githubRetrofit.create(GithubService::class.java)
}