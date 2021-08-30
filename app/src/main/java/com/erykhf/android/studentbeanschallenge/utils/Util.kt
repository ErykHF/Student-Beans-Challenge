package com.erykhf.android.studentbeanschallenge.utils

import android.content.Context
import android.util.Patterns
import android.widget.EditText
import android.widget.ImageView
import androidx.swiperefreshlayout.widget.CircularProgressDrawable
import com.erykhf.android.studentbeanschallenge.R
import com.squareup.picasso.Picasso


fun getProgressDrawable(context: Context): CircularProgressDrawable {
    return CircularProgressDrawable(context).apply {
        strokeWidth = 10f
        centerRadius = 50f
        start()
    }
}


fun ImageView.loadImage(uri: String, progressDrawable: CircularProgressDrawable) {
    Picasso.get().load(uri).placeholder(progressDrawable).error(R.mipmap.ic_launcher).into(this)

}

fun passwordValidation(password: EditText): Boolean {
    val passwordInput = password.text.toString()

    if (passwordInput.isEmpty()) {
        password.error = "Enter a password"
        return false
    } else if (passwordInput.length < 6) {
        password.error = "Password must be 6 characters or longer"
        return false
    }
    password.error = null
    return true
}


fun emailValidation(email: EditText): Boolean {
    val emailInput = email.text.toString()

    if (emailInput.isEmpty()) {
        email.error = "Email cant be blank"
        return false
    } else if (!Patterns.EMAIL_ADDRESS.matcher(emailInput).matches()) {
        email.error = "Enter a valid email address"
        return false
    }
    return true
}
