package br.com.desafiocsix.network

import br.com.desafiocsix.request.GitRepository
import br.com.desafiocsix.response.GitRepositoryListResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiInterface {

    @GET("movie/popular")
    fun getEventList(@Query("page") pageNo: Int): Call<GitRepositoryListResponse>

    @GET("event/{event_id}")
    fun getEventDetails(@Path("event_id") eventId: Int, @Query("api_key") apiKey: String): Call<GitRepository>

}
