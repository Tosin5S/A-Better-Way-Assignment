package com.x5s.a_better_way


import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView


class CategoryAdapter: RecyclerView.Adapter<CategoryAdapter.CategoryViewHolder>() {

    private val agFacts = listOf(
            ContactModel(
                    "Family",
                    R.drawable.ic_baseline_family_restroom_24,
                    "Contact to be added"
            ),
            ContactModel(
                    "Friends",
                    R.drawable.ic_baseline_emoji_emotions_24,
                    "Contact to be added"
            ),
            ContactModel(
                    "Colleagues",
                    R.drawable.ic_baseline_sports_kabaddi_24,
                    "Contact to be added"
            ),

            ContactModel(
                    "Tutors",
                    R.drawable.ic_baseline_engineering_24,
                    "Contact to be added"
            ),

            ContactModel(
                    "Favorite",
                    R.drawable.ic_baseline_favorite_24,
                    "Contact to be added"
            )

    )


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.fact_item, parent, false)

        return CategoryViewHolder(itemView)

    }

    override fun onBindViewHolder(holder: CategoryViewHolder, position: Int) {
        val fact = agFacts[position]
        holder.bindItem(fact)



    }


    override fun getItemCount(): Int {
        return agFacts.size
    }

    inner class CategoryViewHolder(itemView: View, ) : RecyclerView.ViewHolder(itemView) {
        val logo = itemView.findViewById<ImageView>(R.id.imageLogo)
        val name = itemView.findViewById<TextView>(R.id.nameTv)
        fun bindItem(fact: ContactModel) {
            //binding.imageLogo = fact.logo
            //binding.nameTv = fact.name


            fact.logo.let {
                logo.setImageResource(fact.logo)
            }
            name?.text = fact.name

            itemView.setOnClickListener {
                val intent = Intent(itemView.context, DetailActivity::class.java)
                intent.putExtra(LOGO_EXTRAs, fact.logo)
                intent.putExtra(NAME_EXTRAS, fact.name)
                intent.putExtra(FACT_EXTRAS, fact.fact)
                itemView.context.startActivity(intent)
            }



        }
    }


        companion object {
            val LOGO_EXTRAs = "Logo_extras"
            val NAME_EXTRAS = "name_extras"
            val FACT_EXTRAS = "fact_extras"
        }
    }