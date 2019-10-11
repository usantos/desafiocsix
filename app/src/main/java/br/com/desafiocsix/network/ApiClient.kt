package br.com.desafiocsix.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ApiClient {

    private var BASE_URL = "https://api.github.com/search/repositories?q=language:kotlin&sort=stars&page=1"
    private var retrofit: Retrofit? = null

    val results: Retrofit
        get() {
            if (retrofit == null) {
                retrofit = Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
            }
            return results
        }
}
