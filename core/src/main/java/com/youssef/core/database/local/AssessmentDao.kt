package com.youssef.core.database.local

import androidx.room.Dao
import androidx.room.Query
import androidx.room.Transaction
import com.youssef.core.database.model.UniversitiesDto

/**
 * Created by Youssef Ebrahim Elerian on 3/5/24.
 * youssef.elerian@gmail.com
 */

@Dao
interface AssessmentDao {

    @Transaction
    @Query("SELECT * FROM universities")
    suspend fun getAllUniversities(): List<UniversitiesDto>

}