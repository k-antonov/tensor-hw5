package com.example.tensor_hw5

import androidx.annotation.StringRes
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class SharedViewModel : ViewModel() {
    private val mutableMessageId = MutableLiveData(R.string.ellipsis)

    val messageId: LiveData<Int>
        get() = mutableMessageId

    fun setId(@StringRes resId: Int) {
        mutableMessageId.value = resId
    }
}