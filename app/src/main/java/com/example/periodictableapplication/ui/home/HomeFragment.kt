package com.example.periodictableapplication.ui.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.SearchView
import androidx.fragment.app.viewModels
import androidx.navigation.Navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import com.example.periodictableapplication.R
import com.example.periodictableapplication.databinding.FragmentHomeBinding
import com.example.periodictableapplication.domain.model.Element
import com.example.periodictableapplication.ui.model.PeriodGroup
import com.google.android.material.chip.Chip
import dagger.hilt.android.AndroidEntryPoint

private const val TABLE_IMAGE = "https://purepng.com/public/uploads/large/periodic-table-bee.png"
@AndroidEntryPoint
class HomeFragment : Fragment() {
    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    private val adapter = ElementsAdapter {
        navigateToCurrentStock(it)
    }
    private val model: HomeFragmentViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Glide
            .with(binding.root)
            .load(TABLE_IMAGE)
            .into(binding.ivTable)
        initChipGroup()
        setupChipGroupListener()
        observeElements()
        observeViewModel()
        searchViewListener()
        initRecyclerView()
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }


    private fun initChipGroup() {
        binding.chipGroupView.isHorizontalScrollBarEnabled = false

        val periodGroups = getPeriodGroups()

        for (periodGroup in periodGroups) {
            val chip = Chip(binding.chipGroup.context)
            chip.text = periodGroup.periodName
            chip.isClickable = true
            chip.isCheckable = true
            chip.tag = periodGroup.groupNumber

            binding.chipGroup.addView(chip)
        }
    }

    private fun searchViewListener() {
        binding.searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String): Boolean {
                return false
            }

            override fun onQueryTextChange(newText: String): Boolean {
                model.searchElements(newText)
                return true
            }
        })
    }

    private fun setupChipGroupListener() {
        binding.chipGroup.setOnCheckedChangeListener { chipGroup, checkedId ->
            if (checkedId == View.NO_ID) {
                showAllElements()
            } else {
                val selectedChip = chipGroup.findViewById<Chip>(checkedId)
                val selectedGroupNumber = selectedChip?.tag as? Int
                model.filterElementsByGroup(selectedGroupNumber)
            }
        }
    }

    private fun observeNoChipSelected() {
        model.filterElementsByGroup(null)
    }

    private fun showAllElements() {
        binding.chipGroup.clearCheck()
        observeNoChipSelected()
    }

    private fun observeElements() {
        model.elements.observe(viewLifecycleOwner) { elements ->
            adapter.submitList(elements)
        }
    }

    private fun observeViewModel() {
        model.elements.observe(viewLifecycleOwner) { elements ->
            adapter.submitList(elements)
        }
    }

    private fun initRecyclerView() {
        binding.rvNews.adapter = adapter
        binding.rvNews.layoutManager = LinearLayoutManager(context)
    }

    private fun navigateToCurrentStock(element: Element) {
        val action = HomeFragmentDirections.actionHomeFragmentToElementFragment(element)
        findNavController().navigate(action)
    }

    private fun getPeriodGroups(): List<PeriodGroup> {
        return listOf(
            PeriodGroup("1 период", 1),
            PeriodGroup("2 период", 2),
            PeriodGroup("3 период", 3),
            PeriodGroup("4 период", 4),
            PeriodGroup("5 период", 5),
            PeriodGroup("6 период", 6),
            PeriodGroup("7 период", 7)
        )
    }
}