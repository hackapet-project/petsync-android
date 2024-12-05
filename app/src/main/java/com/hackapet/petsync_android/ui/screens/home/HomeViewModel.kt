package com.hackapet.petsync_android.ui.screens.home

import androidx.lifecycle.ViewModel
import com.hackapet.petsync_kmp.PetRepository

class HomeViewModel(private val repository: PetRepository) : ViewModel() {

    fun getPets() =  repository.findAll()


}