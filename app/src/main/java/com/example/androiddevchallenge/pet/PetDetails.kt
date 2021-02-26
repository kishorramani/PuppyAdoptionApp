package com.example.androiddevchallenge.pet

import android.widget.Toast
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.androiddevchallenge.model.Pet
import com.example.androiddevchallenge.model.petDataSource
import com.example.androiddevchallenge.ui.theme.MyTheme
import com.example.androiddevchallenge.utils.PetImage
import com.example.androiddevchallenge.utils.PetInfo

@Composable
fun PetDetailsContent(catId: Int) {
    petDataSource.find { it.id == catId }?.let {
        PetDetails(it)
    }
}

@Composable
fun PetDetails(pet: Pet) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(pet.name)
                }
            )
        },
        content = {

            val context = LocalContext.current

            Column {
                PetImage(
                    pet = pet,
                    modifier = Modifier
                        .height(250.dp)
                        .fillMaxWidth()
                )
                PetInfo(pet = pet)

                Row(modifier = Modifier.fillMaxHeight(), verticalAlignment = Alignment.Bottom) {
                    Button(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(100.dp)
                            .padding(24.dp),
                        onClick = {
                            Toast.makeText(context, "Thanks for adopting me", Toast.LENGTH_SHORT).show()
                        }
                    ) {
                        Text(text = "Adopt me")
                    }
                }
            }
        }
    )
}

//region Previewers
@Preview("Light Theme", widthDp = 360, heightDp = 640)
@Composable
fun LightPreview() {
    MyTheme {
        PetDetails(petDataSource[0])
    }
}

@Preview("Dark Theme", widthDp = 360, heightDp = 640)
@Composable
fun DarkPreview() {
    MyTheme(darkTheme = true) {
        PetDetails(petDataSource[0])
    }
}
//endregion
