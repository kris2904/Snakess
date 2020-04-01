package com.soft.eac.thedepartmentgl.domain.repositories.models.rest

data class Token(
    val access: String,
    val refresh: String
)