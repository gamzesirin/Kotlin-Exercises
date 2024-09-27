package com.gamzesirin.sharedpreferencesapp

import android.content.Context
import android.content.SharedPreferences
import android.icu.text.Bidi
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.gamzesirin.sharedpreferencesapp.databinding.ActivityMainBinding
import kotlinx.coroutines.flow.SharedFlow


class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    lateinit var sharedPreferences: SharedPreferences

    var AlinanKullaniciAdi : String?= null
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
         sharedPreferences = this.getSharedPreferences("com.gamzesirin.sharedpreferencesapp",
            Context.MODE_PRIVATE)

        AlinanKullaniciAdi = sharedPreferences.getString("isim","kayıtlı isim yok")
        if(AlinanKullaniciAdi== ""){
            binding.textView.text="Kaydedilen isim :"
        }
        else{
            binding.textView.text="Kaydedilen isim : ${AlinanKullaniciAdi}"
        }
    }
    fun kaydet (view:View) {

        val KullaniciAdi =binding.editTextText.text.toString()
        if(KullaniciAdi == ""){
            Toast.makeText(this@MainActivity,"Adını boş bırakmayınız!",Toast.LENGTH_LONG).show()
        }
        else{
            sharedPreferences.edit().putString("isim",KullaniciAdi).apply()
            binding.textView.text="Kaydedilen İsim :${KullaniciAdi}"
        }

    }


    fun sil (view: View) {
        AlinanKullaniciAdi = sharedPreferences.getString("isim","kayıtlı isim yok")
        if(AlinanKullaniciAdi!= "") {
            sharedPreferences.edit().remove("isim").apply()
            binding.textView.text="Kaydedilen isim :"
        }
    }
}