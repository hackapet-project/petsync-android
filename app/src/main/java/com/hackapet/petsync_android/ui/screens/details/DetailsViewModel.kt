package com.hackapet.petsync_android.ui.screens.details

import androidx.lifecycle.ViewModel
import com.hackapet.petsync_kmp.PetRepository

class DetailsViewModel(private val repository: PetRepository) : ViewModel() {

    fun getPet(petId: Long) = repository.findById(petId)


}