package com.example.a30daysofmountainhikes

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.CardColors
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Shapes
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.a30daysofmountainhikes.ui.theme._30DaysOfMountainHikesTheme
import com.example.a30daysofmountainhikes.ui.theme.onPrimaryContainerLight
import com.example.a30daysofmountainhikes.ui.theme.onSecondaryContainerLight
import com.example.a30daysofmountainhikes.ui.theme.primaryContainerLight
import com.example.a30daysofmountainhikes.ui.theme.primaryLight
import com.example.a30daysofmountainhikes.ui.theme.secondaryContainerLight
import kotlin.contracts.contract

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            _30DaysOfMountainHikesTheme {
                DaysApp()
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DaysApp(modifier: Modifier = Modifier) {
    Scaffold(
        modifier = modifier.fillMaxSize(),
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = stringResource(R.string.app_name),
                        color = onPrimaryContainerLight
                    ) },
                colors = TopAppBarColors(
                    primaryContainerLight,
                    primaryContainerLight,
                    onPrimaryContainerLight,
                    onPrimaryContainerLight,
                    primaryLight
                ),
                navigationIcon = { Icon(painter = painterResource(R.drawable.mountain_icon), null) }
            )
        }
    ) {
        innerPadding ->
        DaysList(
            hikeList = Datasource().loadHikes(),
            padding = innerPadding
        )
    }
}

@Composable
fun DaysList(
    hikeList: List<Hike>,
    padding: PaddingValues,
    modifier: Modifier = Modifier
) {
    LazyColumn (
        contentPadding = padding,
        modifier = Modifier.padding(8.dp).fillMaxSize()
    ) {
        items(hikeList) { hike ->
            HikeCard(
                hike = hike,
                modifier = modifier
            )
        }
    }
}

@Composable
fun HikeCard(
    hike: Hike,
    modifier: Modifier = Modifier
) {
    Card (
        modifier = modifier,
        shape = MaterialTheme.shapes.extraLarge,
        colors = CardColors(
            containerColor = secondaryContainerLight,
            contentColor = onSecondaryContainerLight,
            disabledContentColor = onSecondaryContainerLight,
            disabledContainerColor = secondaryContainerLight
        )
    ) {
        Column {
            Image(
                painter = painterResource(hike.ImageResourceId),
                contentDescription = stringResource(hike.StringResourceId),
                modifier = Modifier.fillMaxWidth().height(200.dp),
                contentScale = ContentScale.Crop
            )
            Text(
                text = hike.level,
                modifier = Modifier.padding(5.dp).align(Alignment.CenterHorizontally),
                style = MaterialTheme.typography.titleMedium
            )
            Divider(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 5.dp),
                thickness = 1.dp
            )
            Text(
                text = stringResource(hike.StringResourceId),
                modifier = Modifier.padding(10.dp),
                style = MaterialTheme.typography.titleLarge,
                fontWeight = FontWeight.Bold
            )
        }

    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    _30DaysOfMountainHikesTheme {
        DaysApp()
    }
}