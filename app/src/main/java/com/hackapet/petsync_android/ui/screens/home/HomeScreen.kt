package com.hackapet.petsync_android.ui.screens.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
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
    onNavigateToCreate: () -> Unit = {},
    onNavigateToList: () -> Unit = {}
) {

    val petListState by viewModel.loadPets().collectAsState()

    Scaffold { paddingValues ->
        if (petListState.loaded) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(paddingValues)
            ) {
                ListPetButton(
                    modifier = Modifier
                        .size(dimensionResource(R.dimen.pet_list_button_size))
                        .align(Alignment.End),
                    onNavigateToList
                )
                LazyRow(modifier = Modifier.height(dimensionResource(R.dimen.pet_list_horizontal_height))) {
                    val pets = petListState.pets
                    items(pets.size, key = { index -> pets[index].itemId }) { index ->
                        when (val item = pets[index]) {
                            is PetItem.CreteNewPetItem ->
                                CreateNewItemView(
                                    Modifier
                                        .fillMaxHeight()
                                        .width(dimensionResource(R.dimen.pet_create_button_width)),
                                    onNavigateToCreate
                                )

                            is PetItem.DetailPetItem ->
                                PetListItemView(
                                    Modifier.fillMaxHeight(),
                                    item.pet,
                                    onNavigateToDetail
                                )
                        }
                    }
                }
            }
        } else {
            LoadingView()
        }
    }
}

@Composable
fun ListPetButton(modifier: Modifier, onNavigateToList: () -> Unit = {}) {
    Image(
        modifier = modifier.clickable { onNavigateToList() },
        painter = painterResource(id = R.drawable.ic_pet_list),
        contentScale = ContentScale.None,
        contentDescription = stringResource(R.string.pet_list_button_description),
    )
}

@Composable
fun LoadingView(){
    Column {
        CircularProgressIndicator()
        Text("Loading...")
    }
}

@Composable
fun CreateNewItemView(modifier: Modifier, onNavigateToCreate: () -> Unit = {}) {
    Box(
        modifier = modifier
            .background(Color.LightGray)
            .clickable { onNavigateToCreate() },
        contentAlignment = Alignment.Center
    ) {
        Image(
            painter = painterResource(id = R.drawable.ic_pet_add),
            contentDescription =  stringResource(R.string.pet_create_image_description),
            modifier = Modifier.size(dimensionResource(R.dimen.pet_create_image_size)),
            alignment = Alignment.Center,
            colorFilter = ColorFilter.tint(Color.White)
        )
    }
}

@Composable
fun PetListItemView(modifier: Modifier, pet: Pet, onNavigateToDetail: (Long) -> Unit = {}) {
    Box(
        modifier = modifier.clickable { onNavigateToDetail(pet.id) }
    ) {
        UrlImage(
            Modifier
                .fillMaxHeight()
                .width(150.dp), "add url to pet model")
        Text(
            text = pet.name,
            color = Color.White,
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .background(Color.Black, RoundedCornerShape(15.dp))
                .padding(start = 15.dp, top = 5.dp, end = 15.dp, bottom = 5.dp)
        )
    }
}

@OptIn(ExperimentalGlideComposeApi::class)
@Composable
fun UrlImage(modifier: Modifier, url: String) =
    GlideImage(
        model = url,
        contentDescription = "",
        modifier = modifier
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