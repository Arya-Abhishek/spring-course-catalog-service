package com.kotlinspring.repository

import com.kotlinspring.entity.Course
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.CrudRepository

interface CourseRepository: CrudRepository<Course, Int> {

    // this can be an implementation of, finding courses based on matching keyword in the name of course
    fun findByNameContaining(courseName: String): List<Course>

    @Query(value = "SELECT * FROM COURSES where name like %?1%", nativeQuery = true)
    fun findCoursesbyName(courseName: String): List<Course>
}