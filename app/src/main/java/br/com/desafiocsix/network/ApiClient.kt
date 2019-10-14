package br.com.desafiocsix.network

import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkInfo
import br.com.desafiocsix.utils.hasNetwork
import br.com.desafiocsix.view.MainApplication
import okhttp3.Cache
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ApiClient {

    private val cacheSize = (5 * 1024 * 1024).toLong()
    private val myCache = Cache(MainApplication.applicationContext().cacheDir, cacheSize)

    private val okHttpClient: OkHttpClient = OkHttpClient.Builder()
        .cache(myCache)
        .addInterceptor { chain ->
            var request = chain.request()
            request = if (hasNetwork(MainApplication.applicationContext())!!)
                request.newBuilder().header("Cache-Control", "public, max-age=" + 5).build()
            else
                request.newBuilder().header("Cache-Control", "public, only-if-cached, max-stale=" + 60 * 60 * 24 * 7).build()
            chain.proceed(request)
        }
        .build()

    private val retrofit = Retrofit.Builder()
        .baseUrl("https://api.github.com/")
        .addConverterFactory(GsonConverterFactory.create())
        .client(okHttpClient)
        .build()

    fun apiService(): ApiInterface = retrofit.create(ApiInterface::class.java)
}