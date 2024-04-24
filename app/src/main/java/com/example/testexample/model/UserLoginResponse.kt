package com.example.testexample.model

data class UserLoginResponse(
    val userToken: UserToken,
    val status: String
)