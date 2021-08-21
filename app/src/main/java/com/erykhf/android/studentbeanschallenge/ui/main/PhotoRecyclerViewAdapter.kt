package com.erykhf.android.studentbeanschallenge.ui.main

import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.erykhf.android.studentbeanschallenge.databinding.FragmentItemBinding
import com.erykhf.android.studentbeanschallenge.model.PhotosDataItem
import com.erykhf.android.studentbeanschallenge.R
import com.erykhf.android.studentbeanschallenge.utils.getProgressDrawable
import com.erykhf.android.studentbeanschallenge.utils.loadImage



class PhotoRecyclerViewAdapter(var photos: ArrayList<PhotosDataItem>) :
    RecyclerView.Adapter<PhotoRecyclerViewAdapter.ViewHolder>() {


    fun updatePhotos(newPhotos: List<PhotosDataItem>) {
        photos.clear()
        photos.addAll(newPhotos)
        notifyDataSetChanged()

    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        return ViewHolder(
            FragmentItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )

    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(photos[position])

    }

    override fun getItemCount() = photos.size

    inner class ViewHolder(binding: FragmentItemBinding) : RecyclerView.ViewHolder(binding.root) {
        val photoImage = binding.photoImage
        val photoText = binding.photoText
        private val progressDrawable = getProgressDrawable(itemView.context)

        fun bind(photoData: PhotosDataItem) {
            val photoUri = photoData.thumbnailUrl
            photoText.text = photoData.title
            photoImage.loadImage("$photoUri.jpg", progressDrawable)


        }

    }


}