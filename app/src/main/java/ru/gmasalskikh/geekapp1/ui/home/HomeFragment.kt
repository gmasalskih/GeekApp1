package ru.gmasalskikh.geekapp1.ui.home

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import ru.gmasalskikh.geekapp1.R
import ru.gmasalskikh.geekapp1.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {

    private lateinit var homeViewModel: HomeViewModel
    private var _binding: FragmentHomeBinding? = null

    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        homeViewModel = ViewModelProvider(this).get(HomeViewModel::class.java)

        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val root: View = binding.root
        val textInputLayout3 = binding.textInputLayout3
        val editText1: EditText = binding.editText1
        homeViewModel.text.observe(viewLifecycleOwner, Observer {
//            textView.text = it
        })
        editText1.setOnEditorActionListener { textView, _, _ ->
            if (textView.text.length>5) textInputLayout3.error = "ай-яй-яй" else textInputLayout3.error = ""
            true
        }

        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}