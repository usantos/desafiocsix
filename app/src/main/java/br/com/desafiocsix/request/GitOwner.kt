package br.com.desafiocsix.request

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class GitOwner(
    @field:SerializedName("login")
    @Expose
    var login: String,

    @field:SerializedName("id")
    @Expose
    var id: Int,

    @field:SerializedName("avatar_url")
    @Expose
    var avatar_url: String
)
