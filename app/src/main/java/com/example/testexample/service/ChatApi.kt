package com.example.testexample.service

import com.example.testexample.model.MessageResponse
import com.example.testexample.model.UserLoginRequest
import com.example.testexample.model.UserLoginResponse
import com.google.gson.JsonNull
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.POST
import retrofit2.http.Path

interface ChatApi {
    companion object {
        const val BASE_URL = "http://192.168.101.8:3001/api/v1/"
    }

    @GET("rooms/{roomId}/messages")
    suspend fun getMessages(
        @Path("roomId") roomId: String,
        @Header("Authorization") token: String
    ): Response<MessageResponse>

    @POST("users/login")
    suspend fun loginUser(
        @Body userLoginRequest: Any
    ): Response<UserLoginResponse>
}