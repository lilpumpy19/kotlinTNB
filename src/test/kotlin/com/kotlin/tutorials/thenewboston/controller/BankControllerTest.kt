package com.kotlin.tutorials.thenewboston.controller

import com.fasterxml.jackson.databind.ObjectMapper
import com.kotlin.tutorials.thenewboston.model.Bank
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.http.MediaType
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.get
import org.springframework.test.web.servlet.post

@SpringBootTest
@AutoConfigureMockMvc
internal class BankControllerTest @Autowired constructor(
     val mockMvc: MockMvc,
     val objectMapper: ObjectMapper
) {




    @Test
    internal fun test() {
        mockMvc.get("/api/banks")
            .andDo { print() }
            .andExpect {
                status { isOk() }
                content { contentType(MediaType.APPLICATION_JSON) }
            }
    }

    @Test
    internal fun getOneBank() {
        val accountNumber = 123

        mockMvc.get("/api/banks/$accountNumber")
            .andDo { print() }
            .andExpect {
                status { isOk() }
                content { contentType(MediaType.APPLICATION_JSON) }
                jsonPath("$.trust") { value(0.1) }
                jsonPath("$.transactionFee") { value(12) }
            }

    }

    @Test
    internal fun postBank() {
        //given
        val newBank = Bank("qwert", 1.0, 2)
        //when
        var perfomPost=mockMvc.post("/api/banks") {
            contentType = MediaType.APPLICATION_JSON
            content = objectMapper.writeValueAsString(newBank)
        }

            //then
            perfomPost
                .andDo { print() }
                .andExpect {
                status { isCreated() }
                    content { contentType(MediaType.APPLICATION_JSON) }
                    jsonPath("$.accountNumber"){value("qwert")}
            }
    }

    @Test
    internal fun postBank1() {          //the number already exists
        val invalidBank = Bank("123",0.1,0)

        var perfomPost=mockMvc.post("/api/banks") {
            contentType = MediaType.APPLICATION_JSON
            content = objectMapper.writeValueAsString(invalidBank)
        }
        perfomPost.andDo { print() }
            .andExpect { status { isBadRequest() } }
    }
}