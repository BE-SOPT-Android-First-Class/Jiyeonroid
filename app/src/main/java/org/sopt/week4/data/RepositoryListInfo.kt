package org.sopt.week4.data

import com.google.gson.annotations.SerializedName

data class RepositoryListInfo(
    @SerializedName("id")
    val repoId: Int,
    @SerializedName("name")
    val repoName: String,
    @SerializedName("description")
    val repoDesc: String,
    @SerializedName("language")
    val repoLang: String
)