package com.youssef.assessment.di

import com.youssef.core.navigation.DeeplinkProcessor
import com.youssef.details.navigation.UniversityDetailsDeeplinkProcessor
import com.youssef.list.navigation.UniversityListDeeplinkProcessor
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoSet
import javax.inject.Singleton

@Module
interface DeepLinkProcessorModule {


    @Singleton
    @Binds
    @IntoSet
    fun provideUniversityDetailsDeeplinkProcessor(universityDetailsDeeplinkProcessor: UniversityDetailsDeeplinkProcessor): DeeplinkProcessor

    @Singleton
    @Binds
    @IntoSet
    fun provideUniversityListDeeplinkProcessor(universityListDeeplinkProcessor: UniversityListDeeplinkProcessor): DeeplinkProcessor

}