package com.youssef.details.data.source.local

import com.youssef.core.data.database.local.AssessmentDao
import com.youssef.details.data.model.toEntity
import com.youssef.details.domain.entity.UniversityDetailsEntity
import javax.inject.Inject


/**
 * Created by Youssef Ebrahim Elerian on 4/5/24.
 * youssef.elerian@gmail.com
 */
class UniversityDetailsLocalImpl @Inject constructor(private val assessmentDao: AssessmentDao) :
    UniversityDetailsLocalDS {

    override suspend fun getUniversityDetails(name: String): UniversityDetailsEntity {
        return assessmentDao.getUniversityDetails(name).toEntity()
    }
}