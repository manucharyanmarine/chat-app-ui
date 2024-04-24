package com.example.testexample.model

import com.google.gson.annotations.SerializedName

data class MessageList(
    @SerializedName("messageModels")
    val messageModelResponses: List<MessageModelResponse>
)