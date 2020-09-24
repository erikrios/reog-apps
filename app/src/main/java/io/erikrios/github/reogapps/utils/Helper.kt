package io.erikrios.github.reogapps.utils

import android.app.Activity
import android.widget.Toast
import androidx.core.content.ContextCompat
import io.erikrios.github.reogapps.R
import io.erikrios.github.reogapps.databinding.ToastIconTextBinding

enum class ToastState {
    SUCCESS, INFO, ERROR
}

fun Activity.showToast(
    text: String,
    state: ToastState,
    duration: Int
) {
    val binding = ToastIconTextBinding.inflate(layoutInflater)

    val toast = Toast(applicationContext)
    toast.duration = duration

    val imageResource: Int
    val cardBackgroundColor: Int

    when (state) {
        ToastState.SUCCESS -> {
            imageResource = R.drawable.ic_baseline_done_24
            cardBackgroundColor = ContextCompat.getColor(this, android.R.color.holo_green_light)
        }
        ToastState.INFO -> {
            imageResource = R.drawable.ic_baseline_error_outline_24
            cardBackgroundColor = ContextCompat.getColor(this, android.R.color.holo_blue_light)
        }
        ToastState.ERROR -> {
            imageResource = R.drawable.ic_baseline_close_24
            cardBackgroundColor = ContextCompat.getColor(this, android.R.color.holo_red_light)
        }
    }

    binding.tvMessage.text = text
    binding.imgIcon.setImageResource(imageResource)
    binding.cardParent.setCardBackgroundColor(cardBackgroundColor)

    toast.view = binding.root
    toast.show()
}