package org.myspecialway.android.test


import org.hamcrest.CoreMatchers.equalTo
import org.hamcrest.MatcherAssert.assertThat
import org.junit.Test
import org.myspecialway.android.dao.DayOfWeek
import org.myspecialway.android.dao.Lesson

class KtTest {

    @Test
    fun testCRUD() {
        var lesson = Lesson(1L, DayOfWeek.MONDAY, 9, 11, 10, 0);
        assertThat(lesson.id, equalTo(1L))


    }
}
