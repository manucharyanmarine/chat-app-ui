package com.example.testexample.socket

import android.util.Log
import java.io.BufferedReader
import java.io.InputStreamReader
import java.io.PrintWriter
import java.net.Socket

class SocketThread : Thread() {
    override fun run() {
        try {
            Log.d("TAG123", "run: 4444")

            val socket = Socket("127.0.0.1", 3001)

            Log.d("TAG123", "run: 55555")
            val inputStream = BufferedReader(InputStreamReader(socket.getInputStream()))
            val outputStream = PrintWriter(socket.getOutputStream(), true)

            outputStream.println("Hello, server!")

            val response = inputStream.readLine()
            println("Response from server: $response")

            socket.close()
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }
}