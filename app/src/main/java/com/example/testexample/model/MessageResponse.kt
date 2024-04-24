package com.example.testexample.model

import com.google.gson.annotations.SerializedName

data class MessageResponse(
    @SerializedName("messages")
    val messageList: MessageList,
    @SerializedName("status")
    val status: String
)