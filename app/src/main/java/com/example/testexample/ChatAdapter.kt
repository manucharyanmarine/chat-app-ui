package com.example.testexample

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.testexample.databinding.ItemBinding
import com.example.testexample.model.MessageModelResponse
import com.example.testexample.model.MessageResponse

class ChatAdapter : RecyclerView.Adapter<ChatAdapter.TestViewHolder>() {

    private var productList = listOf<MessageModelResponse>()

    fun submitList(list: List<MessageModelResponse>) {
        productList = list
        notifyItemRangeChanged(0, list.size)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TestViewHolder =
        TestViewHolder(ItemBinding.inflate(LayoutInflater.from(parent.context), parent, false))


    override fun onBindViewHolder(holder: TestViewHolder, position: Int) {
        holder.bind(productList[position])
    }

    override fun getItemCount(): Int = productList.size


    class TestViewHolder(private val binding: ItemBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(product: MessageModelResponse) {
            binding.product.text = product.message
        }
    }

//    class ChatDiffUtilCallback():DiffUtil.ItemCallback<>(){
//
//    }
}