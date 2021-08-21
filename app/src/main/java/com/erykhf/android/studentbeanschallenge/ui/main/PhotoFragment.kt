package com.erykhf.android.studentbeanschallenge.ui.main

import android.os.Bundle
import android.view.View
import android.widget.Toolbar
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.erykhf.android.studentbeanschallenge.R
import com.erykhf.android.studentbeanschallenge.databinding.FragmentItemListBinding


/**
 * A fragment representing a list of Items.
 */
class PhotoFragment : Fragment(R.layout.fragment_item_list) {

    private lateinit var binding: FragmentItemListBinding


    lateinit var viewModel: MainViewModel
    private val photoAdapter = PhotoRecyclerViewAdapter(arrayListOf())


    private fun observeViewModel(){
        viewModel.photosLiveData.observe(viewLifecycleOwner, Observer {

            it?.let {
                photoAdapter.updatePhotos(it)
            }
        })
    }



    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding = FragmentItemListBinding.bind(view)
        binding.photosList.apply {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = photoAdapter
        }
        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)
        observeViewModel()

//        val toolbar = view.findViewById<androidx.appcompat.widget.Toolbar>(R.id.toolbar_home)
//        (requireActivity() as AppCompatActivity?)?.setSupportActionBar(toolbar)
//
//        (requireActivity() as AppCompatActivity?)?.supportActionBar?.setDisplayHomeAsUpEnabled(true)
//        (requireActivity() as AppCompatActivity?)?.supportActionBar?.setDisplayShowHomeEnabled(true)

        binding.toolbarHome.apply {
            setNavigationIcon(R.drawable.ic_baseline_arrow_back)


        }
    }

    companion object {

        fun newInstance() = PhotoFragment()
    }
}