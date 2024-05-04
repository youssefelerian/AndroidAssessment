package com.youssef.details.data.repository

import com.youssef.core.data.network.data.model.NOT_FOUND
import com.youssef.core.domain.entity.ErrorEntity
import com.youssef.core.domain.entity.Outcome
import com.youssef.details.data.source.local.UniversityDetailsLocalDS
import com.youssef.details.di.UniversityDetailsScope
import com.youssef.details.domain.repository.UniversityDetailsRepository
import com.youssef.details.domain.entity.UniversityDetailsEntity
import javax.inject.Inject


@UniversityDetailsScope
class UniversityDetailsRepositoryImpl @Inject constructor(
    private val universityDetailsLocalDS: UniversityDetailsLocalDS
) : UniversityDetailsRepository {

    override suspend fun getUniversityDetails(name: String): Outcome<UniversityDetailsEntity> {
        return try {
            Outcome.success(universityDetailsLocalDS.getUniversityDetails(name))
        }catch (e:Exception){
            Outcome.error(ErrorEntity(e, NOT_FOUND))
        }

    }
}