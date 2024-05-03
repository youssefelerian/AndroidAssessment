package com.youssef.core.database.local

import android.app.Application
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

/**
 * Created by Youssef Ebrahim Elerian on 3/5/24.
 * youssef.elerian@gmail.com
 */

@Database(entities = [AssessmentDao::class], version = 1)
abstract class AssessmentDatabase : RoomDatabase() {
    abstract fun getAssessmentDao(): AssessmentDao


    companion object {
        fun build(context: Application): AssessmentDatabase = Room.databaseBuilder(
            context, AssessmentDatabase::class.java, "assessment_db"
        ).fallbackToDestructiveMigration()
            .allowMainThreadQueries()
            .build()
    }
}