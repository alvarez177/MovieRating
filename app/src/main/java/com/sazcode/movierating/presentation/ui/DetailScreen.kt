package com.sazcode.movierating.presentation.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import coil.compose.AsyncImage
import com.sazcode.movierating.R
import com.sazcode.movierating.model.MovieCreditsView
import com.sazcode.movierating.model.MovieView
import com.sazcode.movierating.presentation.DetailContentViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DetailScreen(navController: NavController, movieId: String?) {
    val viewModel: DetailContentViewModel = hiltViewModel()
    if (movieId != null) {
        viewModel.getDetailContent(movieId)
    }
    val movieDetailView = viewModel.movieDetailState.observeAsState().value?.movieDetailView
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(text = "Detail movie") },
                navigationIcon = {
                    Icon(
                        modifier = Modifier.clickable { navController.popBackStack() },
                        imageVector = Icons.Default.ArrowBack,
                        contentDescription = "back"
                    )
                }
            )
        }
    ) {
        LazyColumn(modifier = Modifier.padding(it)) {
            item {
                AsyncImage(
                    modifier = Modifier
                        .aspectRatio(1.2f)
                        .fillMaxWidth(),
                    contentScale = ContentScale.Crop,
                    model = "https://image.tmdb.org/t/p/w500/${movieDetailView?.image}",
                    contentDescription = null
                )
                Spacer(modifier = Modifier.size(8.dp))

            }
            item { TitleSection(title = "Example") }
            item { Credits(credits = emptyList())}
        }
    }
}

@Composable
fun Credits(credits: List<MovieCreditsView>) {
    LazyRow {
        items(credits) {
            CreditsItem(credits = it)
        }
    }
}


@Composable
private fun CreditsItem(credits: MovieCreditsView) {
    Card(
        modifier = Modifier
            .padding(horizontal = 8.dp, vertical = 8.dp)
            .size(width = 180.dp, height = 350.dp)
            .clickable {}
    ) {
        Column {
            AsyncImage(
                modifier = Modifier.clip(
                    shape = RoundedCornerShape(
                        topStart = 16.dp,
                        topEnd = 16.dp
                    )
                ),
                model = "https://image.tmdb.org/t/p/w500/${credits.image}",
                contentDescription = null
            )
            Text(
                modifier = Modifier.padding(horizontal = 2.dp, vertical = 1.dp),
                text = credits.name,
                fontSize = 16.sp,
                fontWeight = FontWeight.SemiBold,
                color = Color.Black
            )
            Text(
                modifier = Modifier.padding(horizontal = 2.dp, vertical = 1.dp),
                text = credits.characterName,
                fontSize = 12.sp
            )
        }
    }
}

@Composable
private fun TitleSection(title: String) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.padding(vertical = 8.dp, horizontal = 16.dp)
    ) {
        Column {
            Text(text = title, style = MaterialTheme.typography.headlineLarge)
            Text(text = "Dalmata", style = MaterialTheme.typography.labelMedium)
        }
    }
}

@Composable
fun TextContent(movieView: MovieView) {
    Column(modifier = Modifier.padding(16.dp)) {
        Text(text = movieView.title)
        Spacer(modifier = Modifier.size(4.dp))
        Text(
            text = "\n" +
                    "Po se prepara para ser el líder espiritual del Valle de la Paz, buscando un sucesor como Guerrero Dragón. Mientras entrena a un nuevo practicante de kung fu, enfrenta al villano llamado \"el Camaleón\", que evoca villanos del pasado, desafiando todo lo que Po y sus amigos han aprendido."
        )
    }
}


@Preview(showBackground = true)
@Composable
fun DetailScreenPreview() {
    Scaffold(
        topBar = {}
    ) {
        LazyColumn(modifier = Modifier.padding(it)) {
            item {
                Image(
                    modifier = Modifier
                        .aspectRatio(1.2f)
                        .fillMaxWidth(),
                    contentScale = ContentScale.Crop,
                    painter = painterResource(id = R.drawable.movieimgtest),
                    contentDescription = null
                )
                Spacer(modifier = Modifier.size(8.dp))

            }
            item { TextContentPreview() }
        }
    }
}


@Composable
fun TextContentPreview() {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.padding(vertical = 8.dp, horizontal = 16.dp)
    ) {
        Column {
            Text(text = "Inu", style = MaterialTheme.typography.headlineLarge)
            Text(text = "Dalmata", style = MaterialTheme.typography.labelMedium)
        }
    }
}
