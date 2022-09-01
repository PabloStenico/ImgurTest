package com.example.imgurtest.adapter

import android.content.Context
import android.os.Parcel
import android.os.Parcelable
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.Adapter
import com.bumptech.glide.Glide
import com.example.imgurtest.R
import com.example.imgurtest.databinding.GalleryBinding
import com.example.imgurtest.model.*

 class GalleryAdpter(private var gallery: MutableList<CatsModel>): RecyclerView.Adapter<GalleryAdpter.MyViewHolder>() {
  class MyViewHolder(private val itemBinding: GalleryBinding): RecyclerView.ViewHolder(itemBinding.root){
   fun bind(gallery: CatsModel){
     itemBinding.run {
      gallery.images?.forEach {
       var url = it.link
       Glide.with(itemView.context).load(url).into(this.imageViewImgur)
      }
    }
   }
   companion object{
      fun create(parent: ViewGroup): MyViewHolder{
      val itemBinding = GalleryBinding.inflate(LayoutInflater.from(parent.context), parent, false)
      return MyViewHolder(itemBinding)
    }
   }
  }

  override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
    return MyViewHolder.create(parent)
  }

  override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
    holder.bind(gallery[position])
  }

  override fun getItemCount(): Int {
    val gal : Int = gallery.size
     return gal
  }


 }