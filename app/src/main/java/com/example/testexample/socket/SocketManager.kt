package com.example.testexample.socket

import io.socket.client.IO
import io.socket.client.Socket
import java.net.URISyntaxException

class SocketManager private constructor() {
    companion object {
        private const val SERVER_URL = "http://192.168.101.8:3001"

        val instance: SocketManager by lazy { Holder.INSTANCE }

        private object Holder {
            val INSTANCE = SocketManager()
        }
    }

    private var socket: Socket? = null

    init {
        try {
            val options = IO.Options().apply {
                // Set any options here if needed
            }
            socket = IO.socket(SERVER_URL, options)
        } catch (e: URISyntaxException) {
            e.printStackTrace()
        }
    }

    fun connect() {
        socket?.connect()
    }

    fun disconnect() {
        socket?.disconnect()
    }

    fun sendMessage(message: String) {
        socket?.emit("message", message)
    }
}
