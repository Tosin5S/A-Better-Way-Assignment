package com.x5s.a_better_way

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import androidx.recyclerview.widget.DividerItemDecoration
import com.x5s.a_better_way.databinding.ActivityDetailBinding

class DetailActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDetailBinding
    private val adapter = ContactAdapter()
    private var logo = 0
    private var name: String? = null
    private var detail: String? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding?.root)
        logo = intent.getIntExtra(FactAdapter.LOGO_EXTRAs,0)
        name = intent.getStringExtra(FactAdapter.NAME_EXTRAS)
        detail = intent.getStringExtra(FactAdapter.FACT_EXTRAS)
        setUpFactDetail()
        setUpData(binding)
    }

    private fun setUpFactDetail(){
        binding?.detailTv?.text =detail
        binding?.logoIv?.setImageResource(logo)
        title = name
    }

    private fun setUpData(binding: ActivityDetailBinding){
        binding.contactRv.adapter = adapter
        binding.contactRv.addItemDecoration(DividerItemDecoration(this,LinearLayout.VERTICAL))
        val builder = AlertDialog.Builder(this)
        val view = layoutInflater.inflate(R.layout.add_contact_dialog, null)
        builder.setView(view)

        val name = view.findViewById<TextView>(R.id.nameEt)
        val no = view.findViewById<TextView>(R.id.numberEt)
        val saveBtn = view.findViewById<TextView>(R.id.saveBt)

        no.addTextChangedListener(object:TextWatcher{
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

            }
            override fun onTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
                saveBtn.isEnabled = s?.length == 11

            }

            override fun afterTextChanged(s: Editable?) {
            }
        })


        val alertDialog = builder.create()
        saveBtn.setOnClickListener{
            val contact = Contact(name.text.toString(),no.text.toString())
            val contacts = mutableListOf(contact)
            adapter.setupContacts(contacts)
            alertDialog.dismiss()
        }


        binding.fab.setOnClickListener{
            alertDialog.show();
        }

    }

    //override fun onDestroy(){
        //super.onDestroy()
        //binding = null
    }
