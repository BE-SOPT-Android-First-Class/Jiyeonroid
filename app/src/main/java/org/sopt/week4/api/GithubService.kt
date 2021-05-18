package org.sopt.week4.api

import org.sopt.week4.data.FollowingUserInfo
import org.sopt.week4.data.RepositoryListInfo
import retrofit2.Call
import retrofit2.http.GET

interface GithubService {
    @GET("/users/todayiswindy/repos")
    fun getRepositoryListInfo(): Call<List<RepositoryListInfo>>

    @GET("/users/todayiswindy/followers")
    fun getFollowingUserInfo(): Call<List<FollowingUserInfo>>
}