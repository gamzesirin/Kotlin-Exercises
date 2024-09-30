package com.gamzesirin.calculatorapp

import android.os.Bundle
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.gamzesirin.calculatorapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    var sayi1 : Double? = null
    var sayi2 : Double? = null
    var sonuc: Double? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        enableEdgeToEdge()

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }


    fun arti(view:View){
        sayi1=binding.editText.text.toString().toDoubleOrNull()
        sayi2=binding.editText2.text.toString().toDoubleOrNull()

        if(sayi1!=null && sayi2!=null){
            sonuc=sayi1!!+sayi2!!
            binding.textView.text = "Sonuç : ${sonuc}"
        }
        else{
            binding.textView.text = "Numaraları giriniz"
        }

    }
    fun eksi(view:View){
        sayi1=binding.editText.text.toString().toDoubleOrNull()
        sayi2=binding.editText2.text.toString().toDoubleOrNull()
        if(sayi1!=null && sayi2!=null){
            sonuc=sayi1!! - sayi2!!
            binding.textView.text = "Sonuç : ${sonuc}"
        }
        else{
            binding.textView.text = "Numaraları giriniz"
        }
    }
    fun carpi(view:View){
        sayi1=binding.editText.text.toString().toDoubleOrNull()
        sayi2=binding.editText2.text.toString().toDoubleOrNull()
        if(sayi1!=null && sayi2!=null){
            sonuc=sayi1!! * sayi2!!
            binding.textView.text = "Sonuç : ${sonuc}"
        }
        else{
            binding.textView.text = "Numaraları giriniz"
        }
    }
    fun bolu(view:View){
        sayi1=binding.editText.text.toString().toDoubleOrNull()
        sayi2=binding.editText2.text.toString().toDoubleOrNull()

        if(sayi1!=null && sayi2!=null){
            sonuc=sayi1!! / sayi2!!
            binding.textView.text = "Sonuç : ${sonuc}"
        }
        else{
            binding.textView.text = "Numaraları giriniz"
        }

    }

}