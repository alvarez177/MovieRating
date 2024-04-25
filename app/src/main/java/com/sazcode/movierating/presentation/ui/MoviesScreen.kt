package com.sazcode.movierating.presentation.ui

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import coil.compose.AsyncImage
import com.sazcode.movierating.AppScreen
import com.sazcode.movierating.model.MovieView
import com.sazcode.movierating.presentation.VisualizeContentViewModel


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun VisualizeContentScreen(
    navController: NavController
) {
    val viewModel: VisualizeContentViewModel = hiltViewModel()
    val contentList = viewModel.contentState.observeAsState().value?.movies ?: emptyList()
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(text = "Movies")},
            )
        }
    ) {
        LazyVerticalGrid(modifier = Modifier.padding(it), columns = GridCells.Fixed(2)) {
            items(contentList) { movieView: MovieView ->
                VisualContentItemScreen(visualizeContentView = movieView) {
                    navController.navigate(route = AppScreen.MovieDetailScreen.route+"/${movieView.id}")
                }
            }
        }
    }
}

@Composable
private fun VisualContentItemScreen(visualizeContentView: MovieView, action: () -> Unit) {
    Card(
        modifier = Modifier
            .padding(horizontal = 8.dp, vertical = 8.dp)
            .size(width = 180.dp, height = 350.dp)
            .clickable {
                action()
            }
    ) {
        Column {
            AsyncImage(
                modifier = Modifier.clip(
                    shape = RoundedCornerShape(
                        topStart = 16.dp,
                        topEnd = 16.dp
                    )
                ),
                model = "https://image.tmdb.org/t/p/w500/${visualizeContentView.image}",
                contentDescription = null
            )
            Text(
                modifier = Modifier.padding(horizontal = 2.dp, vertical = 1.dp),
                text = visualizeContentView.title,
                fontSize = 16.sp,
                fontWeight = FontWeight.SemiBold,
                color = Color.Black
            )
            Text(
                modifier = Modifier.padding(horizontal = 2.dp, vertical = 1.dp),
                text = "14 de feb 2024",
                fontSize = 12.sp
            )
        }
    }
}


/*@Preview(showBackground = true)
@Composable
private fun VisualContentItemScreen() {
    Card(
        modifier = Modifier
            .padding(horizontal = 8.dp, vertical = 8.dp)
            .size(width = 200.dp, height = 300.dp)
    ) {
        Column {
            Image(
                modifier = Modifier.clip(
                    shape = RoundedCornerShape(
                        topStart = 16.dp,
                        topEnd = 16.dp
                    )
                ),
                painter = painterResource(id = R.drawable.movieimgtest),
                contentDescription = null
            )
            Text(

                modifier = Modifier.padding(horizontal = 2.dp, vertical = 1.dp),
                text = "Madame Web lorem ipsum oe oeoeoeeoeoe djdjkdjksdjksjddksjdksjdkskdjkkdjskdjsk",
                fontSize = 16.sp,
                fontWeight = FontWeight.SemiBold,
                color = Color.Black
            )
            Text(
                modifier = Modifier.padding(horizontal = 2.dp, vertical = 1.dp),
                text = "14 de feb 2024",
                fontSize = 12.sp
            )
        }
    }
}*/
