package com.erykhf.android.studentbeanschallenge.ui.main

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.erykhf.android.studentbeanschallenge.R
import com.erykhf.android.studentbeanschallenge.databinding.FragmentItemListBinding
import com.erykhf.android.studentbeanschallenge.databinding.MainFragmentBinding

/**
 * A fragment representing a list of Items.
 */
class PhotoFragment : Fragment(R.layout.fragment_item_list) {

    private lateinit var binding: FragmentItemListBinding


    lateinit var viewModel: MainViewModel
    private val photoAdapter = PhotoRecyclerViewAdapter(arrayListOf())

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }


    fun observeViewModel(){
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



    }

    companion object {

        fun newInstance() = PhotoFragment()
    }
}