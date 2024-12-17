package com.krillinator.web_api_db_g.user.controller

import com.krillinator.web_api_db_g.user.model.CustomUser
import com.krillinator.web_api_db_g.user.repository.CustomUserRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

// TODO - Validate bcrypt Password from DB
// TODO - Check intellij Version (latest)
@RestController
@RequestMapping("/api/v1/user")
class CustomUserController @Autowired constructor(
    val customUserRepository: CustomUserRepository,
    val passwordEncoder: PasswordEncoder // TODO - Why does imports not show up in suggestion
) {

    @GetMapping("/password")
    fun getBcryptPassword(): String {
        val testPassword = "123"
        return passwordEncoder.encode(testPassword)
    }

    @GetMapping
    fun getAllUsers(): ResponseEntity<List<CustomUser>> {
        val users: List<CustomUser> = customUserRepository.findAll()
        return ResponseEntity.ok(users)
    }

    @PostMapping
    fun saveUser(
        @Validated @RequestBody newUser: CustomUser
    ): ResponseEntity<String> {

        // password = 123
        val bcryptUser = CustomUser(
            newUser.username,
            passwordEncoder.encode(newUser.password) // 123 -> bcrypt
        )

        // Save
        customUserRepository.save(bcryptUser)

        return ResponseEntity.status(201).body("User was successfully created")
    }

}