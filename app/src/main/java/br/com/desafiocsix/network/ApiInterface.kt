package br.com.desafiocsix.network

import br.com.desafiocsix.response.GitRepositoryListResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiInterface {
    //?q=language:kotlin&sort=stars&page=1
    @GET("search/repositories")
    fun getRepositoryList(@Query("q") q: String, @Query("sort") sort: String, @Query("page") page: Int): Call<GitRepositoryListResponse>
}
