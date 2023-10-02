package com.kotlin.tutorials.thenewboston.controller

import com.kotlin.tutorials.thenewboston.model.Bank
import com.kotlin.tutorials.thenewboston.service.BankService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/banks")
class BankController(private val service: BankService) {
    @GetMapping
    fun getBanks(): Collection<Bank> = service.getBanks()
}