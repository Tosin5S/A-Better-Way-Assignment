package com.x5s.a_better_way

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView

class FactAdapter(context: Context, facts:List<AgTechModel>):
    ArrayAdapter<AgTechModel>(context,0,facts) {

    override fun getView(position: Int, convertView: View?, parent:ViewGroup): View{
        var view = convertView
        val fact = getItem(position)
        if (view == null) {
            view = LayoutInflater.from(parent.context).inflate(R.layout.fact_item,parent, false)
        }
        val logo = view?.findViewById<ImageView>(R.id.imageLogo)
        val name = view?.findViewById<TextView>(R.id.nameTv)
        fact?.logo?.let{
            logo?.setImageResource(fact.logo)
        }
        name?.text = fact?.name

        view?.setOnClickListener{
            val intent = Intent (parent.context, DetailActivity::class.java)
            intent.putExtra(LOGO_EXTRAs,fact?.logo)
            intent.putExtra(NAME_EXTRAS,fact?.name)
            intent.putExtra(FACT_EXTRAS,fact?.fact)
            parent.context.startActivity(intent)
        }
        return view!!
    }

    companion object {
        val LOGO_EXTRAs = "Logo_extras"
        val NAME_EXTRAS = "name_extras"
        val FACT_EXTRAS = "fact_extras"
    }
}