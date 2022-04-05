package com.example.tensor_hw5

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import com.example.tensor_hw5.databinding.FragmentReceiverBinding

class ReceiverFragment : Fragment() {
    private lateinit var binding: FragmentReceiverBinding

    private val viewModel: SharedViewModel by activityViewModels()

    companion object {
        private val TAG = ReceiverFragment::class.java.simpleName
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d(
            TAG, "Back stack entry count: ${
                requireActivity().supportFragmentManager.backStackEntryCount
            }"
        )
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentReceiverBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.messageId.observe(viewLifecycleOwner) {
            binding.messageTextview.setText(it)
        }

        binding.readButton.setOnClickListener {
            markAsRead()
        }
    }

    private fun markAsRead() = viewModel.setMessageId(R.string.messages_read)
}