package com.example.tensor_hw5

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.StringRes
import com.example.tensor_hw5.databinding.FragmentSenderBinding

class SenderFragment : Fragment() {
    private lateinit var binding: FragmentSenderBinding

    companion object {
        private const val TAG = "SenderFragment"
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentSenderBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.sendMessageButton.setOnClickListener {
            replaceWithReceiverFragment()
        }
    }

    private fun replaceWithReceiverFragment() {
        val receiverFragment = ReceiverFragment.newInstance(R.string.message_to_send)
        requireActivity().supportFragmentManager
            .beginTransaction()
            .replace(R.id.fragment_container_view, receiverFragment)
            .addToBackStack(TAG)
            .commit()
    }


}