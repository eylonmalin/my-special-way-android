package org.myspecialway.android.intergrationTest.dao

import android.arch.persistence.room.Room
import android.os.Build
import org.hamcrest.MatcherAssert.assertThat
import org.hamcrest.Matchers.contains
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.myspecialway.android.dao.DayOfWeek
import org.myspecialway.android.dao.Lesson
import org.myspecialway.android.dao.MswDB
import org.robolectric.RobolectricTestRunner
import org.robolectric.annotation.Config
import org.robolectric.RuntimeEnvironment;

@RunWith(RobolectricTestRunner::class)
@Config(constants = Config::class, sdk = intArrayOf(Build.VERSION_CODES.M), packageName = "org.myspecialway.android.dao")
class ScheduleDaoTest {
    lateinit var mswDb: MswDB;

    @Before
    fun initDB() {
        mswDb = Room.inMemoryDatabaseBuilder(RuntimeEnvironment.application, MswDB::class.java).build();
    }

    @After
    fun closeDB() {
        mswDb.close();
    }

    @Test
    fun testCRUD() {
        var lesson = Lesson(1L,DayOfWeek.MONDAY,9,11, 10, 0 )
        mswDb.scheduleDao().insert(lesson)
        assertThat(mswDb.scheduleDao().getAllLessons(), contains(lesson))
    }

}