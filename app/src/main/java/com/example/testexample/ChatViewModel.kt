package com.example.testexample

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.testexample.model.MessageList
import com.example.testexample.model.MessageModel
import com.example.testexample.model.MessageModelResponse
import com.example.testexample.model.MessageResponse
import com.example.testexample.model.UserLoginRequest
import com.example.testexample.repository.ChatRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ChatViewModel @Inject constructor(
    private val chatRepository: ChatRepository
) : ViewModel() {

    private val _productList = MutableStateFlow(listOf<MessageModelResponse>())
    val productList = _productList.asStateFlow()

    init {
//        getProductList()
    }

//    private fun getProductList() {
//        viewModelScope.launch {
//            chatRepository.getProducts().collect {
//                _productList.value = it
//            }
//        }
//    }

    fun getMessages(roomId: String) {
        viewModelScope.launch {
            val result = chatRepository.getMessages(roomId).successOrNull()
            if (result != null) _productList.value = result.messageList.messageModelResponses

        }
    }

    var nnn = "123"

    fun loginUser() {
        viewModelScope.launch {
            val result = chatRepository.loginUser(
                UserLoginRequest(
                    "John", "12345678"
                )
            ).successOrNull()
            if (result != null) nnn = result.userToken.token
        }
    }
}