package com.x5s.a_better_way

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.x5s.a_better_way.databinding.ContactListItemBinding

class ContactAdapter: RecyclerView.Adapter<ContactAdapter.ContactViewHolder>() {

    private val contacts = mutableListOf<Contact>()

    fun setupContacts(contacts: List<Contact>){
        this.contacts.addAll(contacts)
        notifyDataSetChanged()
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ContactViewHolder {
        return ContactViewHolder(
                ContactListItemBinding.inflate(
                        LayoutInflater.from(parent.context),
                        parent,
                        false
                )
        )
    }

    override fun onBindViewHolder(holder: ContactViewHolder, position: Int) {
        val contact = contacts[position]
        holder.bindItem(contact)
    }

    override fun getItemCount(): Int {
        return contacts.size
    }

    inner class ContactViewHolder(private val binding: ContactListItemBinding):
            RecyclerView.ViewHolder(binding.root) {
        fun bindItem(contact: Contact) {
            binding.nameTv.text = contact.name
            binding.numberTv.text = contact.number
        }
    }


}
