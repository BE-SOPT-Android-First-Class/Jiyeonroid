package org.sopt.week4.data

import com.google.gson.annotations.SerializedName

data class FollowingUserInfo(
    @SerializedName("login")
    val userName: String,
    @SerializedName("id")
    val userId: Int,
    @SerializedName("avatar_url")
    val userImgUrl: String,
    @SerializedName("html_url")
    val userHtmlUrl: String
)