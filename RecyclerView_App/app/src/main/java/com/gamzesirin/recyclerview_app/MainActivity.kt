package com.gamzesirin.recyclerview_app

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.gamzesirin.recyclerview_app.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var SuperKahramanListesi : ArrayList<SuperKahraman>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        enableEdgeToEdge()

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val superman = SuperKahraman("Superman","Gazeteci",R.drawable.superman)
        val batman = SuperKahraman("Batman","Patron",R.drawable.batman)
        val aquaman = SuperKahraman("Aquaman","Kral",R.drawable.aquaman)
        val ironman = SuperKahraman("İronman","Holding Sahibi",R.drawable.ironman)

        val SuperKahramanListesi = arrayListOf(superman,batman,aquaman,ironman)
        val adapter =SuperKahramanAdapter(SuperKahramanListesi)

        binding.superKahramanRecyclerView.layoutManager=LinearLayoutManager(this)
        binding.superKahramanRecyclerView.adapter=adapter

    }
}