package br.com.desafiocsix.request

import com.google.gson.annotations.SerializedName

class GitRepository(
    @field:SerializedName("id")
    var id: Int,
    @field:SerializedName("name")
    var name: String,
    @field:SerializedName("full_name")
    var fullName: String,
    @field:SerializedName("forks_count")
    var forksCount: Int,
    @field:SerializedName("stargazers_count")
    var stargazers_count: Int,
    @field:SerializedName("owner")
    var owner: List<GitOwner>? = null
)
