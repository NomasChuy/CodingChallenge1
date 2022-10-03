package com.example.codingchallenge.presentation

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.codingchallenge.domain.AnimeCharacter
import com.example.codingchallenge.domain.repository.AnimeRepository
import com.example.codingchallenge.utils.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CharacterListViewModel @Inject constructor(private var repository: AnimeRepository) :
    ViewModel() {
    private val _animeList = MutableLiveData<ArrayList<AnimeCharacter>>()
    val animeList : LiveData<ArrayList<AnimeCharacter>> get() = _animeList
    private val _error = MutableLiveData<String>()
    val error get() = _error

    init {
        getAnimeList()
    }

    private fun getAnimeList(){
        viewModelScope.launch(Dispatchers.IO){
            try {
                when(val result = repository.fetchAnimes()){
                    is Resource.Success -> result.data.let { _animeList.postValue(it) }
                    is Resource.Failure -> _error.postValue(result.message?:"Error")
                }
            } catch (e: Exception){
                Log.e("CharacterViewmodel",e.toString())
            }
        }
    }
}