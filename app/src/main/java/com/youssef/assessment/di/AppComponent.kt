package com.youssef.assessment.di

import android.app.Application
import com.youssef.assessment.application.AssessmentApplication
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import javax.inject.Singleton


/**
 * Created by Youssef Ebrahim Elerian on 3/5/24.
 * youssef.elerian@gmail.com
 */

@Singleton
@Component(modules = [AndroidInjectionModule::class, ActivitiesModule::class])
interface AppComponent {

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: Application): Builder

        fun build(): AppComponent
    }

    fun inject(app: AssessmentApplication)
}