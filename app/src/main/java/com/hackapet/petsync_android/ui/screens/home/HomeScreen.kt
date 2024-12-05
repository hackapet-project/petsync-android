package com.hackapet.petsync_android.ui.screens.home

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.bumptech.glide.integration.compose.GlideImage
import com.hackapet.petsync_android.R
import com.hackapet.petsync_kmp.Pet
import org.koin.androidx.compose.koinViewModel


@Composable
fun HomeScreen(
    viewModel: HomeViewModel = koinViewModel(),
    onNavigateToDetail: (Long) -> Unit = {}
) {

    val pets by viewModel.getPets().collectAsState(initial = emptyList())
    Scaffold { paddingValues ->
        Column(modifier = Modifier
            .fillMaxSize()
            .padding(paddingValues)) {
            LazyRow {
                items(pets.size, key = { index -> pets[index].id }) { index ->
                    PetListItemView(pets[index], onNavigateToDetail)
                }
            }
        }
    }
}

@Composable
fun PetListItemView(pet: Pet, onNavigateToDetail: (Long) -> Unit = {}) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.clickable { onNavigateToDetail(pet.id) }
    ) {
        Image("add url to pet model")
        Text(text = pet.name)
    }
}

@OptIn(ExperimentalGlideComposeApi::class)
@Composable
fun Image(url: String) =
    GlideImage(
        model = url,
        contentDescription = "",
        modifier = Modifier
            .size(dimensionResource(id = R.dimen.pet_image_size))
            .padding(5.dp),
        requestBuilderTransform = {
            it.placeholder(R.drawable.ic_pet_placeholder)
                .error(R.drawable.ic_pet_error)
                .centerCrop()
        }
    )

@Preview(showBackground = true)
@Composable
fun HomeScreenPreview() {
    HomeScreen()
}