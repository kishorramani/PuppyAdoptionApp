package com.example.androiddevchallenge.pets

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Card
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.navigate
import com.example.androiddevchallenge.model.Pet
import com.example.androiddevchallenge.model.petDataSource
import com.example.androiddevchallenge.utils.PetImage
import com.example.androiddevchallenge.utils.PetInfo

@Composable
fun PetListContent(navController: NavController) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text("Adopt Pet")
                }
            )
        },
        content = {
            PetList(
                pets = petDataSource,
                Modifier.fillMaxWidth()
            ) {
                navController.navigate("detail/$it")
            }
        }
    )
}

@Composable
fun PetList(pets: List<Pet>, modifier: Modifier = Modifier, onClickListener: (petId: Int) -> Unit) {
    LazyColumn(
        modifier = modifier,
        contentPadding = PaddingValues(16.dp),
        verticalArrangement = Arrangement.spacedBy(10.dp)
    ) {
        items(pets) { pet ->
            PetCard(pet, onClickListener)
        }
    }
}

@Composable
fun PetCard(pet: Pet, onClickListener: (petId: Int) -> Unit) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .clickable { onClickListener(pet.id) },
        elevation = 8.dp
    ) {
        Row(
            modifier = Modifier
                .size(150.dp)
        ) {
            PetImage(
                pet = pet,
                modifier = Modifier
                    .fillMaxHeight()
                    .width(150.dp)
            )
            PetInfo(pet = pet)
        }
    }
}