package com.lawlett.photoquiz

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.lawlett.photoquiz.databinding.FragmentStartBinding
import org.koin.android.ext.android.bind


class GameFragment : BaseFragment(R.layout.fragment_game) {
    private lateinit var binding: FragmentStartBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding= FragmentStartBinding.inflate(layoutInflater)
    }
}