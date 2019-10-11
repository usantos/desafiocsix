package br.com.desafiocsix.request

import com.google.gson.annotations.SerializedName

class GitOwner(
    @field:SerializedName("id")
    var id: Int,
    @field:SerializedName("login")
    var login: String,
    @field:SerializedName("avatar_url")
    var avatar_url: String
)
