package com.kotlinspring.service

import com.kotlinspring.dto.CourseDTO
import com.kotlinspring.entity.Course
import com.kotlinspring.repository.CourseRepository
import mu.KLogging
import org.springframework.stereotype.Service

@Service
class CourseService(val courseRepository: CourseRepository) {

    companion object: KLogging()

    fun addCourse(courseDTO: CourseDTO): CourseDTO {
        logger.info { "before saving to database: $courseDTO" }
        // convert courseDto to Course entity
        val courseEntity = courseDTO.let {
            Course(null, it.name, it.category)
        }

        courseRepository.save(courseEntity)

        // Now to return, we need to have the dto object
        val courseResult = courseEntity.let {
            CourseDTO(it.id, it.name, it.category)
        }
        logger.info { "after saving to database: $courseResult" }
        return courseResult
    }
}
