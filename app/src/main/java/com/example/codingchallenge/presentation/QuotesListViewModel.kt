package com.example.codingchallenge.presentation

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.codingchallenge.di.AnimesRepository
import com.example.codingchallenge.di.AuthorsRepository
import com.example.codingchallenge.di.MoviesRepository
import com.example.codingchallenge.domain.Quote
import com.example.codingchallenge.domain.repository.QuotesRepository
import com.example.codingchallenge.utils.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class QuotesListViewModel @Inject constructor(
    @AnimesRepository
    private var animesRepository: QuotesRepository,
    @AuthorsRepository
    private var authorsRepository: QuotesRepository,
    @MoviesRepository
    private var moviesRepository: QuotesRepository
    ) :
    ViewModel() {
    private val _quoteList = MutableLiveData<ArrayList<Quote>>()
    val quoteList : LiveData<ArrayList<Quote>> get() = _quoteList
    private val _error = MutableLiveData<String>()
    val error get() = _error
    var repositoryType : RepositoryType = RepositoryType.Authors

    init {
        getQuoteList()
    }

     fun getQuoteList(){
        val currentRepository = when(repositoryType){
            is RepositoryType.Animes -> animesRepository
            is RepositoryType.Authors -> authorsRepository
            is RepositoryType.Movies -> moviesRepository
        }
        viewModelScope.launch(Dispatchers.IO){
            try {
                when(val result = currentRepository.fetchQuote()){
                    is Resource.Success -> result.data.let { _quoteList.postValue(it) }
                    is Resource.Failure -> _error.postValue(result.message?:"Error")
                }
            } catch (e: Exception){
                Log.e("CharacterViewmodel",e.toString())
            }
        }
    }
}

sealed interface RepositoryType{
    object Authors: RepositoryType
    object Animes : RepositoryType
    object Movies : RepositoryType
}