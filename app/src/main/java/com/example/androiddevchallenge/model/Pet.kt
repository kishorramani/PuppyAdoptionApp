package com.example.androiddevchallenge.model

import com.example.androiddevchallenge.R

data class Pet(
    val id: Int,
    val name: String,
    val gender: String,
    val category: String,
    val age: String,
    val image: Int
)

val petDataSource = listOf(
    Pet(
        1, "Cat1", "♂", "CAT", "3 month old", R.drawable.cat1
    ),
    Pet(
        2, "Cat2", "♀", "CAT", "2 year old", R.drawable.cat2
    ),
    Pet(
        3, "Dog1", "♂", "DOG","2 years old", R.drawable.dog1
    ),
    Pet(
        4, "Dog2", "♂", "DOG","5 years old", R.drawable.dog2
    ),
    Pet(
        5, "Cat3", "♀", "CAT", "1.7 year old", R.drawable.cat3
    ),
    Pet(
        6, "Dog3", "♀", "DOG","5 years old", R.drawable.dog2
    ),
)

