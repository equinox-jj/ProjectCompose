package com.projectcompose.presentation

import androidx.compose.foundation.layout.Row
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@ExperimentalMaterial3Api
@Composable
fun UiOne(
    modifier: Modifier = Modifier,
    textOne: String = "Hello my name is",
    textTwo: String = "Joshua Jeremia Pardede",
) {
    Card(
        onClick = {  },
        modifier = modifier,
        shape = CardDefaults.outlinedShape,
        elevation = CardDefaults.cardElevation(5.dp)
    ) {
        Row() {

        }
    }
}

@ExperimentalMaterial3Api
@Preview(showBackground = true)
@Composable
fun UiPreview() {
    UiOne()
}