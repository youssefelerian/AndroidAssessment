package com.youssef.list.data.source.remote

import com.youssef.core.domain.entity.Outcome
import com.youssef.list.domain.entity.UniversityEntity


/**
 * Created by Youssef Ebrahim Elerian on 4/5/24.
 * youssef.elerian@gmail.com
 */
interface GetUniversityListRemoteDS {

    suspend fun getUniversityList(searchName: String): Outcome<List<UniversityEntity>>

}