package com.youssef.list.data.source.remote


import com.youssef.list.data.model.UniversityResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query


/**
 * Created by Youssef Ebrahim Elerian on 3/5/24.
 * youssef.elerian@gmail.com
 */
interface UniversityListApiConfig {

    @GET("search")
    suspend fun getUniversityList(@Query("country") country: String): Response<List<UniversityResponse>>
}