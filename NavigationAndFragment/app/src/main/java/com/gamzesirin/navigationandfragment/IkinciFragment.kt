package com.gamzesirin.navigationandfragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.gamzesirin.navigationandfragment.databinding.FragmentBirinciBinding
import com.gamzesirin.navigationandfragment.databinding.FragmentIkinciBinding


class IkinciFragment : Fragment() {

    private var _binding: FragmentIkinciBinding? = null
    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentIkinciBinding.inflate(inflater, container, false)
        val view = binding.root
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        arguments?.let{
            val isim = IkinciFragmentArgs.fromBundle(it).KullaniciAdi
            binding.textView2.text = isim
        }
    }

}