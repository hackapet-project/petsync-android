package com.hackapet.petsync_android.ui.screens.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.bumptech.glide.integration.compose.GlideImage
import com.hackapet.petsync_android.R
import com.hackapet.petsync_kmp.Pet
import com.hackapet.petsync_kmp.ui.home.HomeViewModel
import com.hackapet.petsync_kmp.ui.home.PetItem
import org.koin.androidx.compose.koinViewModel


@Composable
fun HomeScreen(
    viewModel: HomeViewModel = koinViewModel(),
    onNavigateToDetail: (Long) -> Unit = {},
    onNavigateToCreate: () -> Unit = {}
) {

    val petListState by viewModel.loadPets().collectAsState()

    Scaffold { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
        ) {

           if (petListState.loaded) {
                LazyRow {
                    val pets = petListState.pets
                    items(pets.size, key = { index -> pets[index].itemId }) { index ->
                        when (val item = pets[index]) {
                            is PetItem.CreteNewPetItem ->
                                CreateNewItemView(onNavigateToCreate)

                            is PetItem.DetailPetItem ->
                                PetListItemView(item.pet, onNavigateToDetail)
                        }
                    }
                }
            } else {
                Text("Loading...")
            }
        }
    }
}

@Composable
fun CreateNewItemView(onNavigateToCreate: () -> Unit = {}) {
    Box(
        modifier = Modifier
            .height(IntrinsicSize.Max)
            .background(Color.Red)
            .clickable { onNavigateToCreate() }
    ) {
        Image(
            painter = painterResource(id = R.drawable.ic_pet_add),
            contentDescription = "A descriptive text for the image",
            modifier = Modifier.size(50.dp),
            alignment = Alignment.Center
        )
    }
}

@Composable
fun PetListItemView(pet: Pet, onNavigateToDetail: (Long) -> Unit = {}) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.clickable { onNavigateToDetail(pet.id) }
    ) {
        UrlImage("add url to pet model")
        Text(text = pet.name)
    }
}

@OptIn(ExperimentalGlideComposeApi::class)
@Composable
fun UrlImage(url: String) =
    GlideImage(
        model = url,
        contentDescription = "",
        modifier = Modifier
            .size(dimensionResource(id = R.dimen.pet_image_size))
            .padding(dimensionResource(R.dimen.pet_image_padding)),
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