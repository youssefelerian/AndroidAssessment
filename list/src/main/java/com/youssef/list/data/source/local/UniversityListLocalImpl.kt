package com.youssef.list.data.source.local

import com.youssef.core.data.database.local.AssessmentDao
import com.youssef.core.domain.entity.Outcome
import com.youssef.list.data.model.mapper.toDto
import com.youssef.list.data.model.mapper.toEntity
import com.youssef.list.domain.entity.UniversityEntity
import javax.inject.Inject


/**
 * Created by Youssef Ebrahim Elerian on 3/5/24.
 * youssef.elerian@gmail.com
 */
class UniversityListLocalImpl @Inject constructor(private val assessmentDao: AssessmentDao) :
    UniversityListLocalDS {

    override suspend fun getUniversityList(searchName: String): List<UniversityEntity> {
        return assessmentDao.getAllUniversities(searchName).map { university ->
            university.toEntity()
        }
    }

    override suspend fun setUniversityList(
        searchName: String,
        universityList: List<UniversityEntity>
    ): Outcome<List<UniversityEntity>> {
        assessmentDao.insertUniversityList(universityList.map { university ->
            university.toDto(searchName)
        })
        return Outcome.success(universityList)
    }
}