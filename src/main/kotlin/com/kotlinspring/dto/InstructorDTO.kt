package com.kotlinspring.dto

import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.validation.constraints.NotBlank

class InstructorDTO (
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    val id: Int?,
    @get:NotBlank(message = "InstructorDTO.name must not be blank")
    var name: String
)
