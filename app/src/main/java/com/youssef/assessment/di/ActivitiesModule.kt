package com.youssef.assessment.di


import com.youssef.assessment.MainActivity
import com.youssef.details.di.UniversityDetailsFragmentModule
import com.youssef.list.di.UniversityListFragmentModule
import dagger.Module
import dagger.android.ContributesAndroidInjector


/**
 * Created by Youssef Ebrahim Elerian on 3/5/24.
 * youssef.elerian@gmail.com
 */

@Module
abstract class ActivitiesModule {

    @ContributesAndroidInjector(modules = [UniversityListFragmentModule::class, UniversityDetailsFragmentModule::class])
    abstract fun contributeMainActivityAndroidInjector(): MainActivity


}