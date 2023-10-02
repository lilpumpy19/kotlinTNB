package com.kotlin.tutorials.thenewboston.datasource.mock

import com.kotlin.tutorials.thenewboston.datasource.BankDataSource
import com.kotlin.tutorials.thenewboston.model.Bank
import org.springframework.stereotype.Repository


@Repository
class MockBankDataSource:BankDataSource {
    var banks = listOf(
        Bank("123",0.1,12),
        Bank("345",0.2,11),
        Bank("567",0.3,10)
    )

    override fun retrieveBanks(): Collection<Bank> = banks

}