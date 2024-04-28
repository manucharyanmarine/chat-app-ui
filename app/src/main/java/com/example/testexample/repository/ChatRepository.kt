package com.example.testexample.repository

import android.util.Log
import com.example.testexample.AppResult
import com.example.testexample.model.MessageResponse
import com.example.testexample.model.UserLoginRequest
import com.example.testexample.model.UserLoginResponse
import com.example.testexample.service.ChatApi
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import java.io.IOException
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class ChatRepository @Inject constructor(
    private val chatApi: ChatApi
) {
    fun getProducts(): Flow<List<String>> = flow {
        emit(listOf("Product 1", "Product 2"))
    }

    suspend fun getMessages(): AppResult<MessageResponse> {
        val response = chatApi.getMessages(
            "65b61d7a8db4edc72edb9362",
            "Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpZCI6IjY2MjBkNzdhZGExMDZiNDA5NWQ4YTRkMiIsIm5hbWUiOiJKb2huIiwiaWF0IjoxNzEzODY4NDkxfQ.GcGiy0vRK2qVpckoCAPt_8P2XdToHyiEX7pvFpG-upU"
        )
        return try {
            AppResult.Success(response.body()!!)
        } catch (e: java.io.IOException) {
            AppResult.Failure(e)
        }
    }

    suspend fun loginUser(loginRequest: UserLoginRequest): AppResult<UserLoginResponse> {
        Log.d("TAG123", "getMessages: 5454545454")
        val response = chatApi.loginUser(loginRequest)
        return try {
            AppResult.Success(response.body()!!)
        } catch (e: IOException) {
            Log.d("1231231", "loginUser: ${e.message}")
            AppResult.Failure(e)
        }
    }
}