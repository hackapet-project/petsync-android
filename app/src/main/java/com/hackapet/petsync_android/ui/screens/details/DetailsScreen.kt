package com.hackapet.petsync_android.ui.screens.details

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import com.hackapet.petsync_kmp.ui.details.DetailViewModel
import org.koin.androidx.compose.koinViewModel
import org.koin.core.parameter.parametersOf

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DetailsScreen(
    petId: Long,
    onBack: () -> Unit
) {

    val viewModel: DetailViewModel = koinViewModel { parametersOf(petId) }

    val petState by viewModel.loadPet().collectAsState()
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Remplazar por titulo") },
                navigationIcon = {
                    IconButton(onClick = { onBack() }) {
                        Icon(Icons.AutoMirrored.Filled.ArrowBack, contentDescription = "Menu")
                    }
                }
            )
        }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
        ) {
            petState.run {
                when {
                    !this.loaded -> Text(text = "Pet Loading...")
                    this.pet == null -> Text(text = "Pet Not Found")
                    else -> Text(text = this.pet!!.name)
                }
            }
        }
    }
}