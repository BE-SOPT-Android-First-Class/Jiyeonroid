package org.sopt.androidseminar.data

data class FollowingUserInfo(
    val userName: String
) {
    val userImgSrc = "https://github.com/$userName.png"
}