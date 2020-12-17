package com.lawlett.photoquiz

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.lawlett.photoquiz.adapter.LevelsAdapter
import com.lawlett.photoquiz.data.Level
import com.lawlett.photoquiz.databinding.FragmentLevelsBinding
import com.lawlett.photoquiz.utils.LevelPreference
import com.lawlett.photoquiz.utils.StartPreference

class LevelsFragment : BaseFragment(R.layout.fragment_levels), LevelsAdapter.Listener {
    private var _binding: FragmentLevelsBinding? = null
    private val binding get() = _binding!!
    private var list: MutableList<Level> = mutableListOf()
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

        var isShown: Boolean = LevelPreference.getInstance(requireContext())!!.isShown
        if (!isShown) {
            for (i in 1..21) list.add(Level(id = i))
            adapter.add(list)
            LevelPreference.getInstance(requireContext())!!.saveShown()
        }
    }

    private fun initAdapter() {
        binding.levelAdapter.adapter = adapter
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onItemClick(level: Int?) {
        findNavController().navigate(
            LevelsFragmentDirections.actionLevelsFragmentToGameFragment(
                level= level!!
            )
        )
    }
}
