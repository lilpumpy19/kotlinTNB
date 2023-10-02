package com.kotlin.tutorials.thenewboston.service

import com.kotlin.tutorials.thenewboston.datasource.BankDataSource
import io.mockk.every
import io.mockk.mockk
import io.mockk.verify
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

internal class BankServiceTest{
    private val dataSource: BankDataSource= mockk(relaxed = true)
    private val bankService = BankService(dataSource)
    @Test
    internal fun test() {

        bankService.getBanks()

        verify(exactly = 1) { dataSource.retrieveBanks() }
    }
}