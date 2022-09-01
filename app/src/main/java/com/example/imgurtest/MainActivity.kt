package com.example.imgurtest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.get
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.imgurtest.adapter.GalleryAdpter
import com.example.imgurtest.databinding.ActivityMainBinding
import com.example.imgurtest.model.CatsViewModel
import com.example.imgurtest.model.GalleryRepository


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var viewModel: CatsViewModel


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root

        viewModel = ViewModelProvider(this).get()

        getCats()

        setContentView(view)


    }

    fun getCats(){
        viewModel.getcats("cats")?.observe(this, {
            Toast.makeText(applicationContext, "Aguarde...", Toast.LENGTH_LONG).show()
            binding.recyclerView.adapter = GalleryAdpter(it.data)
            binding.recyclerView.layoutManager = GridLayoutManager(applicationContext, 4)
        })

    }





}