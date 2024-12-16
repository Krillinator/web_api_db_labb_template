package com.krillinator.web_api_db_g.user.repository

import com.krillinator.web_api_db_g.user.model.CustomUser
import org.springframework.data.jpa.repository.JpaRepository

interface CustomUserRepository: JpaRepository<CustomUser, Long> {
}

