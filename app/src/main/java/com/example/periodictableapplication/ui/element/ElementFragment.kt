package com.example.periodictableapplication.ui.element

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.bumptech.glide.Glide
import com.example.periodictableapplication.databinding.FragmentElementBinding
import com.example.periodictableapplication.domain.model.Element

class ElementFragment : Fragment() {
    private var _binding: FragmentElementBinding? = null
    private val binding get() = _binding!!
    private val args: ElementFragmentArgs by navArgs()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentElementBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initHeader()
        initMore()
        onBackListener()
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

    private fun onBackListener() {
        binding.ivBackArrow.setOnClickListener {
            requireActivity().onBackPressedDispatcher.onBackPressed()
        }
    }

    private fun initHeader() {
        val element: Element = args.element
        Glide
            .with(binding.root)
            .load(element.imageUrl)
            .into(binding.ivElement)
        binding.tvName.text = element.name
        binding.tvNameSmaller.text = element.name
        binding.tvMass.text = element.atomicMass.toString()
        binding.tvCategory.text = element.category
        binding.tvSymbol.text = element.symbol
        binding.tvNumber.text = element.number.toString()
        binding.ivWiki.setOnClickListener {
            openWikipediaPage(element.source)
        }
    }

    private fun initMore() {
        val element: Element = args.element
        binding.tvSummaryText.text = element.summary
        binding.tvAppearanceText.text = element.appearance ?: "-"
        binding.tvDiscoveredText.text = element.discoveredBy ?: "-"
        binding.tvPhaseText.text = element.phase
        binding.tvEngNameText.text = element.engName
        binding.tvLatinNameText.text = element.latinName
    }

    private fun openWikipediaPage(url: String) {
        val intent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
        startActivity(intent)
    }
}