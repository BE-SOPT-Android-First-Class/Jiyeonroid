package org.sopt.week4.data.request

data class RequestSignUpData(
    val email: String,
    val password: String,
    val sex: String,
    val nickname: String,
    val phone: String,
    val birth: String
)