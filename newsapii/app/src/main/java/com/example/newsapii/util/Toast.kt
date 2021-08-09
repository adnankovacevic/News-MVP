package com.example.newsapii.util

import android.content.Context
import android.widget.Toast

fun showToast(context: Context, strError: String, length: Int = Toast.LENGTH_SHORT) {
    Toast.makeText(context, strError, length).show()
}