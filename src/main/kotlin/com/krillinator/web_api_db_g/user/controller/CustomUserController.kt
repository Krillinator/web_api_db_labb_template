package com.krillinator.web_api_db_g.user.controller

import com.krillinator.web_api_db_g.user.model.CustomUser
import com.krillinator.web_api_db_g.user.repository.CustomUserRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/v1/user")
class CustomUserController @Autowired constructor(
    val customUserRepository: CustomUserRepository
) {

    @GetMapping
    fun getAllUsers(): ResponseEntity<List<CustomUser>> {

        val users: List<CustomUser> = customUserRepository.findAll()

        return ResponseEntity.ok(users)
    }

    @PostMapping
    fun saveUser(
        @RequestBody newUser: CustomUser
    ): ResponseEntity<String> {

        customUserRepository.save(newUser)

        return ResponseEntity.status(201).body("User was successfully created")
    }

}