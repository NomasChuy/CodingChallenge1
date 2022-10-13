package com.example.codingchallenge.presentation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.codingchallenge.databinding.FragmentQuotesListBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class QuotesListFragment : Fragment() {
    private val adapter = MyAdapter()
    private lateinit var binding : FragmentQuotesListBinding
    private val viewModel by viewModels<QuotesListViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentQuotesListBinding.inflate(inflater,container,false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.quoteListRecycler.adapter = adapter
        binding.quoteListRecycler.layoutManager = LinearLayoutManager(requireContext())

        binding.radioGroupAPIChange.setOnCheckedChangeListener{ _ , id ->
            when (id){
                binding.animeButton.id -> viewModel.repositoryType = RepositoryType.Animes
                binding.authorButton.id -> viewModel.repositoryType = RepositoryType.Authors
                binding.movieButton.id -> viewModel.repositoryType = RepositoryType.Movies
            }
            viewModel.getQuoteList()
        }

        viewModel.quoteList.observe(viewLifecycleOwner){
            adapter.submitList(it)
        }

        viewModel.error.observe(viewLifecycleOwner){
            Toast.makeText(context, it, Toast.LENGTH_SHORT).show()
        }
    }

}