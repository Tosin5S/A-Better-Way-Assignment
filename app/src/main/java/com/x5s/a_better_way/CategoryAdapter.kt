package com.x5s.a_better_way

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.x5s.a_better_way.DummyData.agFacts

class CategoryAdapter(private val activity: Context?, private val arrData:List<ContactModel>): RecyclerView.Adapter<CategoryAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent:ViewGroup, viewType:Int): ViewHolder {
        val fact = agFacts


        var itemView: View? = null
        itemView = LayoutInflater.from(activity).inflate(R.layout.fact_item, parent,false)


        val logo = itemView.findViewById<ImageView>(R.id.imageLogo)
        val name = itemView.findViewById<TextView>(R.id.nameTv)

        fact[0].logo.let{
            logo.setImageResource(fact[0].logo)
        }
        name.text = fact[0].name

        itemView.setOnClickListener{
            val intent = Intent (parent.context, DetailActivity::class.java)
            intent.putExtra(LOGO_EXTRAs,fact[0].logo)
            intent.putExtra(NAME_EXTRAS,fact[0].name)
            intent.putExtra(FACT_EXTRAS,fact[0].fact)
            parent.context.startActivity(intent)
        }

        return ViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: CategoryAdapter.ViewHolder, position: Int) {
        val model = arrData[position]

    }

    override fun getItemCount(): Int {
        return arrData.size
    }

    class ViewHolder(view: View?): RecyclerView.ViewHolder(view!!) {
    }


    companion object {
        val LOGO_EXTRAs = "Logo_extras"
        val NAME_EXTRAS = "name_extras"
        val FACT_EXTRAS = "fact_extras"
    }
}