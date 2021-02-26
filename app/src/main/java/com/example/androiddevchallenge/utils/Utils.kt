package com.example.androiddevchallenge.utils

import android.graphics.Color.BLACK
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Colors
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.androiddevchallenge.model.Pet
import com.example.androiddevchallenge.ui.theme.black
import com.example.androiddevchallenge.ui.theme.grayFont

@Composable
fun PetImage(pet: Pet, modifier: Modifier) {
    Image(
        painter = painterResource(id = pet.image),
        contentDescription = pet.name,
        modifier = modifier
    )
}

@Composable
fun PetInfo(pet: Pet) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 16.dp, top = 16.dp)
    ) {
        Row {
            Text(
                text = pet.name,
                style = MaterialTheme.typography.h5,
                color = black,
                modifier = Modifier.padding(bottom = 10.dp)
            )
            Text(
                text = pet.gender,
                color = grayFont,
                style = MaterialTheme.typography.body1,
                textAlign = TextAlign.End,
                modifier = Modifier
                    .padding(top = 5.dp, end = 16.dp)
                    .fillMaxWidth()
            )
        }
        Text(
            text = pet.category,
            style = MaterialTheme.typography.body1,
            color = grayFont,
            modifier = Modifier.padding(bottom = 10.dp)
        )

        Text(
            text = pet.age,
            style = MaterialTheme.typography.body2,
            color = grayFont
        )
    }
}