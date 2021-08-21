package com.erykhf.android.studentbeanschallenge.ui.main

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.erykhf.android.studentbeanschallenge.R
import com.erykhf.android.studentbeanschallenge.databinding.MainFragmentBinding
import com.erykhf.android.studentbeanschallenge.utils.emailValidation
import com.erykhf.android.studentbeanschallenge.utils.passwordValidation

class MainFragment : Fragment(R.layout.main_fragment) {

    private lateinit var binding: MainFragmentBinding

    companion object {
        fun newInstance() = MainFragment()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = MainFragmentBinding.bind(view)

        val email = binding.emailEditText
        val password = binding.passwordEditText
        val loginButton = binding.loginButton

        loginButton.setOnClickListener {

            if (emailValidation(email) && passwordValidation(password)) {
                requireActivity().supportFragmentManager
                    .beginTransaction()
                    .setReorderingAllowed(true)
                    .addToBackStack(null)
                    .replace(R.id.fragmentContainer, PhotoFragment.newInstance())
                    .commit()
            }
        }
    }

}