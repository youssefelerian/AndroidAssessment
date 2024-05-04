package com.youssef.details.di


import com.youssef.details.data.repository.UniversityDetailsRepositoryImpl
import com.youssef.details.data.source.local.UniversityDetailsLocalDS
import com.youssef.details.domain.repository.UniversityDetailsRepository
import dagger.Module
import dagger.Provides


/**
 * Created by Youssef Ebrahim Elerian on 5/5/24.
 * youssef.elerian@gmail.com
 */


@Module
class UniversityDetailsModule {

    @UniversityDetailsScope
    @Provides
    fun provideUniversityDetailsRepository(
        universityDetailsLocalDS: UniversityDetailsLocalDS
    ): UniversityDetailsRepository =
        UniversityDetailsRepositoryImpl(universityDetailsLocalDS)
}