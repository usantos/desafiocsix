package br.com.desafiocsix.request

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class GitRepository(
    @field:SerializedName("id")
    @Expose
    var id: Int,

    @field:SerializedName("name")
    @Expose
    var name: String,

    @field:SerializedName("full_name")
    @Expose
    var fullName: String,

    @field:SerializedName("forks_count")
    @Expose
    var forksCount: Int,

    @field:SerializedName("stargazers_count")
    @Expose
    var stargazers_count: Int,

    @field:SerializedName("owner")
    @Expose
    var owner: GitOwner
)
