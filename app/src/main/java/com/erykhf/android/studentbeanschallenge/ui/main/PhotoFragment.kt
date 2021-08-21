package com.erykhf.android.studentbeanschallenge.ui.main

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
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


    lateinit var viewModel: PhotoFragmentViewModel
    private val photoAdapter = PhotoRecyclerViewAdapter(arrayListOf())


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding = FragmentItemListBinding.bind(view)
        binding.photosList.apply {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = photoAdapter
        }

        viewModel = ViewModelProvider(this).get(PhotoFragmentViewModel::class.java)
        observeViewModel()

        binding.swipeRefreshLayout.setOnRefreshListener {
            binding.swipeRefreshLayout.isRefreshing = false
            viewModel.refresh()
            observeViewModel()
        }

        binding.toolbarHome.apply {
            setNavigationIcon(R.drawable.ic_baseline_arrow_back)
            setNavigationOnClickListener {

                val fragmentManager: FragmentManager = requireActivity().supportFragmentManager
                val count: Int = fragmentManager.backStackEntryCount
                for (i in 0 until count) {
                    fragmentManager.popBackStackImmediate()
                }
                fragmentManager
                    .beginTransaction()
                    .setReorderingAllowed(true)
                    .replace(R.id.fragmentContainer, MainFragment.newInstance())
                    .commit()
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        viewModel.photosLiveData.removeObservers(viewLifecycleOwner)
    }


    private fun observeViewModel() {
        viewModel.photosLiveData.observe(viewLifecycleOwner, Observer {
            it?.let {
                binding.itemFragmentList.visibility = View.VISIBLE
                photoAdapter.updatePhotos(it)
            }
        })
    }

    companion object {
        fun newInstance() = PhotoFragment()
    }
}