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

            list.add(Level(id = 1))
            list.add(Level(id = 2))
            list.add(Level(id = 3))
            list.add(Level(id = 4))
            list.add(Level(id = 5))
            list.add(Level(id = 6))
            list.add(Level(id = 7))
            list.add(Level(id = 8))
            list.add(Level(id = 9))
            list.add(Level(id = 10))
            list.add(Level(id = 11))
            list.add(Level(id = 12))
            list.add(Level(id = 13))
            list.add(Level(id = 14))
            list.add(Level(id = 15))
            list.add(Level(id = 16))
            list.add(Level(id = 17))
            list.add(Level(id = 18))
            list.add(Level(id = 19))
            list.add(Level(id = 20))
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
