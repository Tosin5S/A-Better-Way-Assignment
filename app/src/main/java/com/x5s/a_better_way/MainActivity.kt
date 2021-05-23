package com.x5s.a_better_way

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.x5s.a_better_way.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

   private lateinit var binding:ActivityMainBinding
    private var adapter = CategoryAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding?.root)
        //GridLayoutManager(this, 2, RecyclerView.VERTICAL,false).apply{
            //factListView.layoutManager = this

        //}
        setUpFact(binding)



    }

    private fun setUpFact(binding: ActivityMainBinding){
        adapter = CategoryAdapter()
        binding.factListView.adapter = adapter
        binding.factListView.layoutManager = GridLayoutManager(this,2)

    }


    //override fun onDestroy(){
        //super.onDestroy()
        //binding = null
    //}

}

