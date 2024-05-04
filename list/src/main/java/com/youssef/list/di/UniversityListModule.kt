package com.youssef.list.di


import com.youssef.core.data.database.local.AssessmentDao
import com.youssef.core.data.network.NetworkHandler
import com.youssef.core.data.network.NetworkMonitor
import com.youssef.core.data.network.data.source.NetworkDataSource
import com.youssef.list.data.repository.UniversityListRepositoryImpl
import com.youssef.list.data.source.local.UniversityListLocalDS
import com.youssef.list.data.source.local.UniversityListLocalImpl
import com.youssef.list.data.source.remote.GetUniversityListRemoteDS
import com.youssef.list.data.source.remote.GetUniversityListRemoteImpl
import com.youssef.list.data.source.remote.UniversityListApiConfig
import com.youssef.list.domain.repository.UniversityListRepository
import dagger.Module
import dagger.Provides


/**
 * Created by Youssef Ebrahim Elerian on 3/5/24.
 * youssef.elerian@gmail.com
 */


@Module
class UniversityListModule {

    @UniversityListScope
    @Provides
    fun provideGetUniversityListRemoteDS(networkDataSource: NetworkDataSource<UniversityListApiConfig>): GetUniversityListRemoteDS =
        GetUniversityListRemoteImpl(networkDataSource)

    @UniversityListScope
    @Provides
    fun provideUniversityListLocalDS(assessmentDao: AssessmentDao): UniversityListLocalDS =
        UniversityListLocalImpl(assessmentDao)


    @UniversityListScope
    @Provides
    fun provideUniversityListApiConfig(
        network: NetworkHandler,
        networkMonitor: NetworkMonitor
    ): NetworkDataSource<UniversityListApiConfig> {
        val universityListApiConfig = network.create(UniversityListApiConfig::class.java)
        return NetworkDataSource(universityListApiConfig, networkMonitor)
    }


    @UniversityListScope
    @Provides
    fun provideUniversityListRepository(
        universityListRemoteDS: GetUniversityListRemoteDS,
        universityListLocalDS: UniversityListLocalDS
    ): UniversityListRepository =
        UniversityListRepositoryImpl(universityListRemoteDS, universityListLocalDS)
}