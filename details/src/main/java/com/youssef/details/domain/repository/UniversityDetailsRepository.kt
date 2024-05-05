package com.youssef.details.domain.repository

import com.youssef.core.domain.entity.Outcome
import com.youssef.details.domain.entity.UniversityDetailsEntity

interface UniversityDetailsRepository {

    suspend fun getUniversityDetails(name: String): Outcome<UniversityDetailsEntity>

}