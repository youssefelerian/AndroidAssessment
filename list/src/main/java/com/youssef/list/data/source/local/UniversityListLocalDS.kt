package com.youssef.list.data.source.local

import com.youssef.core.domain.entity.Outcome
import com.youssef.list.domain.entity.UniversityEntity


/**
 * Created by Youssef Ebrahim Elerian on 4/5/24.
 * youssef.elerian@gmail.com
 */
interface UniversityListLocalDS {

    suspend fun getUniversityList(searchName: String): List<UniversityEntity>

    suspend fun setUniversityList(
        searchName: String,
        universityList: List<UniversityEntity>
    ): Outcome<List<UniversityEntity>>
}