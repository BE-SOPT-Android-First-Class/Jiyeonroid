package org.sopt.androidseminar.api

import org.sopt.androidseminar.data.FollowingListInfo
import org.sopt.androidseminar.data.RepoListInfo
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface GithubService {
    @GET("/users/{username}/repos")
    fun getRepositories(@Path("userName") username: String): Call<List<RepoListInfo>>

    @GET("/users/{username}/followers")
    fun getFollowerInfo(@Path("userName") username: String): Call<List<FollowingListInfo>>
}