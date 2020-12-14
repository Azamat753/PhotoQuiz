package com.lawlett.photoquiz

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.net.toUri
import androidx.navigation.fragment.navArgs
import com.lawlett.photoquiz.databinding.FragmentGameBinding
import com.lawlett.photoquiz.extension.loadImage
import com.lawlett.photoquiz.extension.toastShow
import com.lawlett.photoquiz.viewmodels.GameViewModel
import org.koin.android.ext.android.inject


class GameFragment : BaseFragment(R.layout.fragment_game) {
    private val args: GameFragmentArgs by navArgs()
    private val viewModel by inject<GameViewModel>()

    private var _binding: FragmentGameBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentGameBinding.inflate(inflater, container, false)
        return binding.root
    }
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.getLevel(args.level).observe(viewLifecycleOwner, { level ->
            val model = level[0]
            binding.levelNumber.text=args.level.toString()
            binding.firstImage.loadImage(model.firstImg?.toUri())
            binding.secondImage.loadImage(model.secondImg?.toUri())
            binding.thirdImage.loadImage(model.thirdImg?.toUri())
            binding.fourImage.loadImage(model.fourImg?.toUri())

            binding.tryBtn.setOnClickListener {
                var userAnswer=binding.wordEd.text.toString().trim()
                if (userAnswer == model.answer){
                    requireContext().toastShow("Правильно")
                }else{
                    requireContext().toastShow("Не правильно")
                }
            }

        })
    }
}