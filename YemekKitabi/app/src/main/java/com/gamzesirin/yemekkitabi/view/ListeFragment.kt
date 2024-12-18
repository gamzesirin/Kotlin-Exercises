package com.gamzesirin.yemekkitabi.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.room.Room
import com.gamzesirin.yemekkitabi.adapter.TarifAdapter
import com.gamzesirin.yemekkitabi.databinding.FragmentListeBinding
import com.gamzesirin.yemekkitabi.model.Tarif
import com.gamzesirin.yemekkitabi.roomdb.TarifDAO
import com.gamzesirin.yemekkitabi.roomdb.TarifDatabase
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.schedulers.Schedulers


class ListeFragment : Fragment() {

    private var _binding: FragmentListeBinding? = null
    private val binding get() = _binding!!

    private val mDisposable = CompositeDisposable()
    private lateinit var db : TarifDatabase
    private lateinit var tarifDao: TarifDAO

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        db = Room.databaseBuilder(requireContext(), TarifDatabase::class.java, "Tarifler")
            //.allowMainThreadQueries()
            .build()

        tarifDao = db.tarifDao()

    }

    private fun handleResponse(tarifler: List<Tarif>) {
        val tarifAdapter = TarifAdapter(tarifler)
        binding.recyclerView.adapter = tarifAdapter
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentListeBinding.inflate(inflater, container, false)
        val view = binding.root
        return view
    }



    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.floatingActionButton.setOnClickListener { addNew(it) }
        binding.recyclerView.layoutManager = LinearLayoutManager(requireContext())

        verileriAl()
    }


    private fun verileriAl() {
        mDisposable.add(tarifDao.getAll()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(this::handleResponse))
    }

    fun addNew(view: View) {
        val action = ListeFragmentDirections.actionListeFragmentToTarifFragment(bilgi = "yeni", id = -1)
        Navigation.findNavController(view).navigate(action)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
        mDisposable.clear()
    }
}