package com.kotlin.tutorials.thenewboston.service

import com.kotlin.tutorials.thenewboston.datasource.BankDataSource
import com.kotlin.tutorials.thenewboston.model.Bank
import org.springframework.stereotype.Service

@Service
class BankService(private val dataSource: BankDataSource) {
    fun getBanks(): Collection<Bank> = dataSource.retrieveBanks()
    fun getBank(accountNumber: String): Bank = dataSource.retrieveBank(accountNumber)
}