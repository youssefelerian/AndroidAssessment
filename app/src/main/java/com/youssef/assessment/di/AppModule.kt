package com.youssef.assessment.di

import android.app.Application
import android.content.Context
import com.youssef.assessment.BuildConfig
import com.youssef.core.database.local.AssessmentDatabase
import com.youssef.core.network.NetworkHandler
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
    fun providesCitiesDatabase(context: Application): AssessmentDatabase =
        AssessmentDatabase.build(context)
}

