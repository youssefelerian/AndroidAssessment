package com.youssef.core.data.database.local

import android.app.Application
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.youssef.core.data.database.model.UniversitiesDto

/**
 * Created by Youssef Ebrahim Elerian on 3/5/24.
 * youssef.elerian@gmail.com
 */

@Database(entities = [UniversitiesDto::class], version = 1)
@TypeConverters(value = [Converters::class])
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