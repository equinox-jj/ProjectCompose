package com.projectcompose.presentation.home.component

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.projectcompose.domain.model.CharacterResults

@Composable
fun CharacterCard(
    modifier: Modifier = Modifier,
    shape: Shapes = MaterialTheme.shapes,
    data: CharacterResults,
    onClick: () -> Unit,
) {
    Card(
        modifier = modifier
            .height(250.dp)
            .fillMaxWidth()
            .padding(15.dp)
            .clickable { onClick() },
        shape = shape.large,
        elevation = CardDefaults.cardElevation(4.dp)
    ) {
        Box {
            AsyncImage(
                modifier = modifier.fillMaxSize(),
                model = data.image,
                contentDescription = null,
                contentScale = ContentScale.FillBounds
            )
            Column(
                modifier = modifier
                    .align(Alignment.BottomCenter)
                    .padding(8.dp)
            ) {
                Text(
                    modifier = modifier.fillMaxWidth(),
                    text = data.name,
                    textAlign = TextAlign.Center,
                    overflow = TextOverflow.Ellipsis,
                    maxLines = 1,
                    style = MaterialTheme.typography.bodyLarge,

                    )
                Spacer(modifier = modifier.height(4.dp))
                Text(
                    modifier = modifier.fillMaxWidth(),
                    text = data.gender,
                    textAlign = TextAlign.Center,
                    overflow = TextOverflow.Ellipsis,
                    maxLines = 1,
                    style = MaterialTheme.typography.bodyMedium
                )
                Spacer(modifier = modifier.height(4.dp))
                Text(
                    modifier = modifier.fillMaxWidth(),
                    text = data.species,
                    textAlign = TextAlign.Center,
                    overflow = TextOverflow.Ellipsis,
                    maxLines = 1,
                    style = MaterialTheme.typography.bodyMedium,
                )
            }
        }
    }
}