
package com.kotlin.tutorials.thenewboston.datasource.mock

import org.assertj.core.api.Assertions.*
import org.junit.jupiter.api.Test

internal class MockBankDataSourceTest{
    private val mockBankDataSource=MockBankDataSource()
    @Test
    fun test() {
        //given

        //when
        val banks = mockBankDataSource.retrieveBanks()

        //then
        assertThat(banks).isNotEmpty

    }
    @Test
    fun test1() {
        //when
        val banks = mockBankDataSource.retrieveBanks()
        //then
        assertThat(banks).allMatch { it.accountNumber.isNotBlank() }
        assertThat(banks).allMatch { it.trust!=0.0 }
        assertThat(banks).allMatch { it.transactionFee!=0 }

    }
}