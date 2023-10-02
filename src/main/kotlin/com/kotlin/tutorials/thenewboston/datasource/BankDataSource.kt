package com.kotlin.tutorials.thenewboston.datasource

import com.kotlin.tutorials.thenewboston.model.Bank

interface BankDataSource {
    fun retrieveBanks():Collection<Bank>
}