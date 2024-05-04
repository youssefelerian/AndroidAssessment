package com.youssef.core.data.network


import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.converter.scalars.ScalarsConverterFactory


/**
 * Created by Youssef Ebrahim Elerian on 3/5/24.
 * youssef.elerian@gmail.com
 */
class NetworkHandler {

    private lateinit var mainRetrofit: Retrofit
    private var isDebug: Boolean = false

    fun setup(baseURL: String, isDebug: Boolean): NetworkHandler {
        this.isDebug = isDebug
        mainRetrofit = getClient(baseURL)
        return this
    }


    private fun getClient(baseUrl: String): Retrofit {
        return Retrofit.Builder()
            .baseUrl(baseUrl)
            .client(getHttpClient())
            .addConverterFactory(ScalarsConverterFactory.create())
            .addConverterFactory(GsonConverterFactory.create())
            .build()


    }


    private fun getHttpClient(): OkHttpClient {
        val httpClient = OkHttpClient.Builder()
        if (isDebug) {
            val logging = HttpLoggingInterceptor()
            logging.level = HttpLoggingInterceptor.Level.BODY
            httpClient.addInterceptor(logging)
        }
        return httpClient.build()

    }

    fun <T> create(service: Class<T>): T {
        return mainRetrofit.create(service)
    }

    companion object {
        val request: NetworkHandler = NetworkHandler()
    }
}