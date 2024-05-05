package com.youssef.assessment.di

import android.app.Application
import android.content.Context
import com.youssef.assessment.BuildConfig
import com.youssef.assessment.navigation.RootDeeplinkHandler
import com.youssef.core.data.database.local.AssessmentDao
import com.youssef.core.data.database.local.AssessmentDatabase
import com.youssef.core.data.network.NetworkHandler
import com.youssef.core.navigation.DeeplinkHandler
import com.youssef.core.navigation.DeeplinkProcessor
import dagger.Module
import dagger.Provides
import javax.inject.Singleton


/**
 * Created by Youssef Ebrahim Elerian on 3/5/24.
 * youssef.elerian@gmail.com
 */
@Module
class AppModule {

    @Provides
    @Singleton
    fun provideContext(application: Application): Context {
        return application
    }

    @Provides
    @Singleton
    fun provideNetworkHandler(): NetworkHandler =
        NetworkHandler.request.setup(BuildConfig.ASSESSMENT_API, BuildConfig.DEBUG)

    @Provides
    @Singleton
    fun providesAssessmentDatabase(context: Application): AssessmentDatabase =
        AssessmentDatabase.build(context)

    @Provides
    @Singleton
    fun providesAssessmentDao(assessmentDatabase: AssessmentDatabase): AssessmentDao =
        assessmentDatabase.getAssessmentDao()

    @Provides
    @Singleton
    fun providesRootDeeplinkHandler(processors: Set<@JvmSuppressWildcards DeeplinkProcessor>): DeeplinkHandler =
        RootDeeplinkHandler(processors)


}

