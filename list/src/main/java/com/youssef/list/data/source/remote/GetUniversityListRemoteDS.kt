package com.youssef.list.data.source.remote

import com.youssef.core.data.network.data.source.NetworkDataSource
import com.youssef.core.domain.entity.Outcome
import com.youssef.list.data.model.mapper.toEntity
import com.youssef.list.domain.entity.UniversityEntity
import javax.inject.Inject


/**
 * Created by Youssef Ebrahim Elerian on 3/5/24.
 * youssef.elerian@gmail.com
 */
class GetUniversityListRemoteDS @Inject constructor(private val networkDataSource: NetworkDataSource<UniversityListApiConfig>) {

    suspend fun getUniversityList(searchName: String): Outcome<List<UniversityEntity>> {
        return networkDataSource.performRequest(request = {
            getUniversityList(searchName)
        }, onSuccess = { list ->
            Outcome.success(list.map { university -> university.toEntity() })
        })
    }
}