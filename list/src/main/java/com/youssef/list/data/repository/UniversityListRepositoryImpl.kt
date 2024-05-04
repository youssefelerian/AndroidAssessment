package com.youssef.list.data.repository

import com.youssef.core.domain.entity.Outcome
import com.youssef.core.domain.entity.doOnSuccess
import com.youssef.core.domain.entity.onErrorResume
import com.youssef.list.data.source.local.UniversityListLocalDS
import com.youssef.list.data.source.remote.GetUniversityListRemoteDS
import com.youssef.list.di.UniversityListScope
import com.youssef.list.domain.entity.UniversityEntity
import com.youssef.list.domain.repository.UniversityListRepository
import javax.inject.Inject


@UniversityListScope
class UniversityListRepositoryImpl @Inject constructor(
    private val universityListRemoteDS: GetUniversityListRemoteDS,
    private val universityListLocalDS: UniversityListLocalDS
) : UniversityListRepository {

    override suspend fun getUniversityList(searchName: String): Outcome<List<UniversityEntity>> {
        return universityListRemoteDS.getUniversityList(searchName).doOnSuccess { list ->
            universityListLocalDS.setUniversityList(searchName, list)
        }.onErrorResume { error ->
            val items = universityListLocalDS.getUniversityList(searchName)
            if (items.isEmpty()) {
                error
            } else {
                Outcome.success(items)
            }
        }
    }
}