package dev.franz.businesscard.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import dev.franz.businesscard.App
import dev.franz.businesscard.R
import dev.franz.businesscard.data.BusinessCard
import dev.franz.businesscard.databinding.ActivityAddBusinessCardBinding


class AddBusinessCardActivity : AppCompatActivity() {

    private val binding by lazy { ActivityAddBusinessCardBinding.inflate(layoutInflater) }

    private val mainViewModel: MainViewModel by viewModels {
        MainViewModelFactory((application as App).repository)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        insertListeners ()
    }

    private fun insertListeners () {
        binding.btnClose.setOnClickListener{
            finish()
        }

        binding.btnConfirm.setOnClickListener {
            val businessCard = BusinessCard (
                nome = binding.tilName.editText?.text.toString(),
                empresa = binding.tilCompany.editText?.text.toString(),
                telefone = binding.tilPhone.editText?.text.toString(),
                email = binding.tilMail.editText?.text.toString(),
                fundoPersonalizado = binding.tilColor.editText?.text.toString()
            )
            mainViewModel.insert(businessCard)
            Toast.makeText(this, R.string.label_show_sucess, Toast.LENGTH_SHORT).show()
            finish()
        }
    }
}