package com.example.testexample.model

import com.google.gson.annotations.SerializedName

data class MessageModelResponse(
    @SerializedName("__v")
    val __v: Int,
    @SerializedName("_id")
    val messageId: String,
    @SerializedName("date")
    val messageDate: String,
    @SerializedName("message")
    val message: String,
    @SerializedName("roomID")
    val roomID: String,
    @SerializedName("senderID")
    val senderID: String
) {
    companion object {
        fun toMessageModel(messageResponse: MessageModelResponse) = MessageModel(
            messageResponse.messageId,
            messageResponse.messageDate,
            messageResponse.message,
            messageResponse.roomID,
            messageResponse.senderID
        )
    }
}
