package com.kotlin.tutorials.thenewboston.datasource.mock

import com.kotlin.tutorials.thenewboston.datasource.BankDataSource
import com.kotlin.tutorials.thenewboston.model.Bank
import org.springframework.stereotype.Repository


@Repository
class MockBankDataSource : BankDataSource {
    var banks = mutableListOf(
        Bank("123", 0.1, 12),
        Bank("345", 0.2, 11),
        Bank("567", 0.3, 10)
    )

    override fun retrieveBanks(): Collection<Bank> = banks
    override fun retrieveBank(accountNumber: String): Bank =
        banks.firstOrNull() { it.accountNumber == accountNumber }
            ?: throw NoSuchElementException("Could not find a bank with account $accountNumber")

    override fun createBank(bank: Bank): Bank {
        if (banks.any { it.accountNumber == bank.accountNumber }) {
            throw IllegalArgumentException("the number already exists")
        }
        banks.add(bank)
        return bank
    }


    override fun updateBank(bank: Bank): Bank {
        val currentBank = banks.firstOrNull { it.accountNumber == bank.accountNumber }
            ?: throw NoSuchElementException("Could not find a bank")

        banks.remove(currentBank)
        banks.add(bank)

        return bank
    }

    override fun deleteBank(accountNumber: String) {
        val currentBank = banks.firstOrNull { it.accountNumber == accountNumber }
            ?: throw NoSuchElementException("Could not find a bank")

        banks.remove(currentBank)

    }


}