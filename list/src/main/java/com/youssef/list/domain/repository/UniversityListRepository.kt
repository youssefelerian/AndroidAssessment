package com.youssef.list.domain.repository

import com.youssef.core.domain.entity.Outcome
import com.youssef.list.domain.entity.UniversityEntity

interface UniversityListRepository {

    suspend fun getUniversityList(searchName: String): Outcome<List<UniversityEntity>>

}