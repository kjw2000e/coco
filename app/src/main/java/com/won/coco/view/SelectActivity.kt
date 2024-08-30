package com.won.coco.view

import android.os.Bundle
import android.widget.LinearLayout
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.won.coco.R
import com.won.coco.databinding.ActivitySelectBinding
import com.won.coco.view.adapter.IntroCoinAdapter

class SelectActivity : AppCompatActivity() {

    private val selectViewModel: SelectViewModel by viewModels()

    private lateinit var binding: ActivitySelectBinding
    private lateinit var introCoinAdapter: IntroCoinAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivitySelectBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setRecyclerView()

        selectViewModel.getAllCoinList()
        selectViewModel.resultList.observe(this) { currentItemList ->
            introCoinAdapter.submitList(currentItemList)
        }
    }

    private fun setRecyclerView() {
        introCoinAdapter = IntroCoinAdapter()

        binding.coinListRV.apply {
            setHasFixedSize(true)
            layoutManager = LinearLayoutManager(this@SelectActivity, LinearLayoutManager.VERTICAL, false)
            adapter = introCoinAdapter
            introCoinAdapter.setOnItemClickListener { item ->
                Toast.makeText(this@SelectActivity, item.coinName, Toast.LENGTH_SHORT).show()
            }
        }
    }
}