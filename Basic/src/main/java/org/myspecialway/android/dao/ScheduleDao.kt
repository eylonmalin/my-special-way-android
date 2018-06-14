package org.myspecialway.android.dao

import android.arch.persistence.room.*

enum class DayOfWeek(val dayNumber: Int) {
    SUNDAY(1),
    MONDAY(2),
    TUESDAY(3),
    WEDNESDAY(4),
    THURSDAY(5),
    FRIDAY(6),
    SATURDAY(7),
}

@Entity
data class Lesson(
        @PrimaryKey(autoGenerate = true)
        val id: Long,
        val day: DayOfWeek,
        val startTimeHour: Int,
        val startTimeMinutes: Int,
        val endTimeHour: Int,
        val endTimeMinute: Int
)

@Dao
interface ScheduleDao {

    @Query("SELECT * FROM Lesson")
    fun getAllLessons():List<Lesson>

    @Insert
    fun insert(lesson: Lesson)
}