package com.krillinator.web_api_db_g.user.model

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.validation.constraints.NotEmpty
import jakarta.validation.constraints.Size

@Entity
class CustomUser(

    @field:NotEmpty
    @field:Size(min = 2, max = 16)
    val username: String,

    @field:NotEmpty
    @field:Size(min = 7, max = 73)
    val password: String,

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    val id: Long? = null
) {
}