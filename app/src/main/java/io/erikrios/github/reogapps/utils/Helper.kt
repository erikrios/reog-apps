package io.erikrios.github.reogapps.utils

import android.app.Activity
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import io.erikrios.github.reogapps.R
import io.erikrios.github.reogapps.databinding.ToastIconTextBinding

enum class ToastState {
    SUCCESS, INFO, ERROR
}

fun Activity.showErrorToast(text: String, viewGroup: ViewGroup, state: ToastState, duration: Int) {
    val toast = Toast(this)
    toast.duration = duration

    // Inflate view
    val binding = ToastIconTextBinding.inflate(LayoutInflater.from(this), viewGroup, true)

    var imageResource: Int
    var cardBackgroundColor: Int

    when (state) {
        ToastState.SUCCESS -> {
            imageResource = R.drawable.ic_baseline_done_24
            cardBackgroundColor = android.R.color.holo_green_dark
        }
        ToastState.INFO -> {
            imageResource = R.drawable.ic_baseline_error_outline_24
            cardBackgroundColor = android.R.color.holo_blue_dark
        }
        ToastState.ERROR -> {
            imageResource = R.drawable.ic_baseline_close_24
            cardBackgroundColor = android.R.color.holo_red_dark
        }
    }

    binding.apply {
        tvMessage.text = text
        imgIcon.setImageResource(imageResource)

    }
}