package com.kotlin.tutorials.thenewboston.datasource

import com.kotlin.tutorials.thenewboston.model.Bank

interface BankDataSource {
    fun retrieveBanks():Collection<Bank>
    fun retrieveBank(accountNumber: String): Bank
    fun createBank(bank: Bank): Bank
}