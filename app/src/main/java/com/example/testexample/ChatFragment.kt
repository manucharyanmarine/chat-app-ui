package com.example.testexample

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.testexample.databinding.FragmentChatBinding
import com.example.testexample.socket.SocketManager
import com.redmadrobot.extensions.viewbinding.viewBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ChatFragment : Fragment(R.layout.fragment_chat) {

    private val viewModel: ChatViewModel by viewModels()
    private val binding by viewBinding<FragmentChatBinding>()
    private val chatAdapter: ChatAdapter = ChatAdapter()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


//        viewModel.getMessages("65b61d7a8db4edc72edb9362")

        // Connect to the Socket.IO server
        SocketManager.instance.connect()

        // Example: Send a message when a button is clicked
        binding.btnCreateChat .setOnClickListener {
            val message = "Hello, Server!"
            SocketManager.instance.sendMessage(message)
        }

        viewModel.loginUser()
//        viewModel.getMessages()

        with(binding) {
            rvChat.adapter = chatAdapter
            rvChat.layoutManager = LinearLayoutManager(requireContext())
        }


        binding.teext.text = viewModel.nnn
//        viewModel.productList.onEach {
//            chatAdapter.submitList(it)
//        }.launchIn(viewLifecycleOwner.lifecycleScope)
    }
}


