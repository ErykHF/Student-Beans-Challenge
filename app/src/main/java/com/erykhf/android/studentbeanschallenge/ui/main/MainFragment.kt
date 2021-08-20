package com.erykhf.android.studentbeanschallenge.ui.main

import android.os.Bundle
import android.util.Patterns
import android.view.View
import android.widget.EditText
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.erykhf.android.studentbeanschallenge.R
import com.erykhf.android.studentbeanschallenge.databinding.MainFragmentBinding
import java.util.regex.Pattern

class MainFragment : Fragment(R.layout.main_fragment) {

    private lateinit var binding: MainFragmentBinding
    private lateinit var viewModel: MainViewModel
    private lateinit var email: EditText
    private lateinit var password: EditText

    companion object {
        fun newInstance() = MainFragment()
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = MainFragmentBinding.bind(view)
        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)

        email = view.findViewById(R.id.email_edit_text)
        password = view.findViewById(R.id.password_edit_text)
        val loginButton = binding.loginButton


        loginButton.setOnClickListener {

            if (emailValidation(email) && passwordValidation(password)) {
                requireActivity().supportFragmentManager
                    .beginTransaction()
                    .addToBackStack("")
                    .replace(R.id.container, PhotoFragment.newInstance())
                    .commit()
            }
        }
    }

    private fun passwordValidation(password: EditText): Boolean {
        val passwordInput = password.text.toString()

        if (passwordInput.isEmpty()) {
            password.error = "Enter a password"
            return false
        } else if (passwordInput.length < 6) {
            password.error = "Password must be 5 characters or longer"
            return false
        }
        password.error = null
        return true
    }


    private fun emailValidation(email: EditText): Boolean {
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
}