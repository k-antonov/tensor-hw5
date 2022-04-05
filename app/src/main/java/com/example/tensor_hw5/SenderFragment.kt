package com.example.tensor_hw5

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.StringRes
import androidx.fragment.app.activityViewModels
import com.example.tensor_hw5.databinding.FragmentSenderBinding

class SenderFragment : Fragment() {
    private lateinit var binding: FragmentSenderBinding

    private val viewModel: SharedViewModel by activityViewModels()

    companion object {
        private val TAG = SenderFragment::class.java.simpleName
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentSenderBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.sendMessageButton.setOnClickListener {
            sendMessage(R.string.message_to_send)
            replaceWithReceiverFragment()
        }
    }

    private fun sendMessage(@StringRes resId: Int) = viewModel.setMessageId(resId)

    private fun replaceWithReceiverFragment() {
        requireActivity().supportFragmentManager
            .beginTransaction()
            .replace(R.id.fragment_container_view, ReceiverFragment())
            .addToBackStack(TAG)
            .commit()
    }
}