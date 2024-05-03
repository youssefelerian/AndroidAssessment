package com.youssef.assessment.di


import com.youssef.assessment.MainActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector


/**
 * Created by Youssef Ebrahim Elerian on 3/5/24.
 * youssef.elerian@gmail.com
 */

@Module
abstract class ActivitiesModule {

    @ContributesAndroidInjector()
    abstract fun contributeMainActivityAndroidInjector(): MainActivity


}