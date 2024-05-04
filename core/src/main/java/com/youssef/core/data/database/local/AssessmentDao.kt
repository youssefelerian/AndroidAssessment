package com.youssef.core.data.database.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Transaction
import com.youssef.core.data.database.model.UniversitiesDto

/**
 * Created by Youssef Ebrahim Elerian on 3/5/24.
 * youssef.elerian@gmail.com
 */

@Dao
interface AssessmentDao {

    @Transaction
    @Query("SELECT * FROM universities WHERE searchName= :searchName")
    suspend fun getAllUniversities(searchName: String): List<UniversitiesDto>

    @Transaction
    @Query("SELECT * FROM universities WHERE name= :name")
    suspend fun getUniversityDetails(name: String): UniversitiesDto

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertUniversityList(universities: List<UniversitiesDto>)

    @Query("DELETE FROM universities WHERE searchName = :searchName")
    suspend fun deleteUniversities(searchName: String)

}