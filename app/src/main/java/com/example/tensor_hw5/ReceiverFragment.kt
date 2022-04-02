package com.example.tensor_hw5

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.StringRes
import com.example.tensor_hw5.databinding.FragmentReceiverBinding

class ReceiverFragment : Fragment() {
    private lateinit var binding: FragmentReceiverBinding

    companion object {
        private const val TAG = "ReceiverFragment"
        private const val MESSAGE_KEY = "MessageKey"

        fun newInstance(@StringRes resId: Int) : Fragment =
            ReceiverFragment().apply {
                val bundle = Bundle()
                bundle.putInt(MESSAGE_KEY, resId)
                arguments = bundle
            }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d(
            TAG, "Back stack entries count: ${
                requireActivity().supportFragmentManager.backStackEntryCount
            }"
        )
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentReceiverBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val messageId = arguments?.getInt(MESSAGE_KEY, R.string.ellipsis)
        messageId?.let { binding.messageTextview.setText(it) }

        binding.readButton.setOnClickListener {
            binding.messageTextview.setText(R.string.messages_read)
        }
    }
}