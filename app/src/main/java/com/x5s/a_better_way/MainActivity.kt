package com.x5s.a_better_way

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.x5s.a_better_way.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    var binding:ActivityMainBinding? = null
    var adapter:CategoryAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding?.root)
        GridLayoutManager(this, 3, RecyclerView.VERTICAL,false).apply{

        }
        setUpFact()



    }

    private fun setUpFact(){
        adapter = CategoryAdapter()
        binding?.factListView?.adapter = adapter

    }


    override fun onDestroy(){
        super.onDestroy()
        binding = null
    }

}

