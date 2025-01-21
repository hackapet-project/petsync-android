package com.hackapet.petsync_android.ui.screens.list

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.tooling.preview.Preview
import com.hackapet.petsync_android.R
import com.hackapet.petsync_android.ui.screens.home.LoadingView
import com.hackapet.petsync_android.ui.screens.home.UrlImage
import com.hackapet.petsync_kmp.Pet
import com.hackapet.petsync_kmp.ui.home.HomeViewModel
import com.hackapet.petsync_kmp.ui.home.PetItem
import org.koin.androidx.compose.koinViewModel


@Composable
fun ListScreen(
    viewModel: HomeViewModel = koinViewModel(),
    onNavigateToDetail: (Long) -> Unit = {},
) {

    val petListState by viewModel.loadPets().collectAsState()

    Scaffold { paddingValues ->
        if (petListState.loaded) {
            LazyColumn(modifier = Modifier.padding(paddingValues)) {
                val pets = petListState.pets
                items(pets.size, key = { index -> pets[index].itemId }) { index ->
                    when (val item = pets[index]) {
                        is PetItem.CreteNewPetItem -> {
                            /*nothing to do*/
                        }
                        is PetItem.DetailPetItem ->
                            PetListItemView(
                                Modifier.fillMaxHeight(),
                                item.pet,
                                onNavigateToDetail
                            )
                    }
                }
            }
        } else {
            LoadingView()
        }
    }
}

@Composable
fun PetListItemView(modifier: Modifier, pet: Pet, onNavigateToDetail: (Long) -> Unit = {}) {
    Row(
        modifier = modifier.clickable { onNavigateToDetail(pet.id) },
        verticalAlignment = Alignment.CenterVertically
    ) {
        UrlImage(
            Modifier
                .fillMaxHeight()
                .size(dimensionResource(R.dimen.pet_list_vertical_height)),
            "add url to pet model"
        )
        Text(text = pet.name)
    }
}

@Preview(showBackground = true)
@Composable
fun ListScreenPreview() {
    ListScreen()
}