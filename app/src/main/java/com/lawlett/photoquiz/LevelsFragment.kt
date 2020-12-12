package com.lawlett.photoquiz

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.lawlett.photoquiz.adapter.LevelsAdapter
import com.lawlett.photoquiz.data.Level
import com.lawlett.photoquiz.databinding.FragmentLevelsBinding
import com.lawlett.photoquiz.extension.toastShow

class LevelsFragment : BaseFragment(R.layout.fragment_levels),LevelsAdapter.Listener{
    private var _binding: FragmentLevelsBinding? = null
    private val binding get() = _binding!!
    private  var list: MutableList<Level> = mutableListOf()

    private val adapter = LevelsAdapter(this)

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentLevelsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initAdapter()
        addList()
    }
    private fun addList() {
        list.add(Level(1))
        list.add(Level(2))
        list.add(Level(3))
        adapter.add(list)

    }

    private fun initAdapter() {
        binding.levelAdapter.adapter = adapter

    }
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onItemClick(level: Level) {
        requireContext().toastShow(level.level.toString())
    }
}