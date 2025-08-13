package com.example.a30daysofmountainhikes

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ButtonElevation
import androidx.compose.material3.Card
import androidx.compose.material3.CardColors
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.FloatingActionButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonColors
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarColors
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shadow
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            _30DaysOfMountainHikesTheme(darkTheme = false) {
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
        containerColor = MaterialTheme.colorScheme.surface,
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = stringResource(R.string.app_name),
                        color = MaterialTheme.colorScheme.onPrimary,
                        style = MaterialTheme.typography.titleLarge.copy(
                            shadow = Shadow(
                                color = Color.Black.copy(alpha = 0.25f),
                                offset = Offset(2f, 2f),
                                blurRadius = 4f
                            )),
                        fontWeight = FontWeight.Bold
                    ) },
                colors = TopAppBarColors(
                    MaterialTheme.colorScheme.primary,
                    MaterialTheme.colorScheme.primary,
                    MaterialTheme.colorScheme.onPrimary,
                    MaterialTheme.colorScheme.onPrimary,
                    MaterialTheme.colorScheme.primary
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
        Sidebar(Modifier.padding(innerPadding))

    }
}

@Composable
fun DaysList(
    hikeList: List<Hike>,
    padding: PaddingValues,
    modifier: Modifier = Modifier
) {
    val listState = rememberLazyListState()
    val coroutineScope = rememberCoroutineScope()

    LazyColumn (
        state = listState,
        contentPadding = padding,
        modifier = Modifier.padding(8.dp).fillMaxSize()
    ) {
        items(hikeList) { hike ->
            Column (
                modifier = Modifier
            ) {
                HikeCard(
                    hike = hike,
                    modifier = modifier,
                )
                if (hike.day == 30) {
                    Finish()
                }

            }
        }
    }
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(padding),
        contentAlignment = Alignment.BottomEnd
    ) {
        FloatingActionButton (
            onClick = {
                coroutineScope.launch {
                    listState.animateScrollToItem(hikeList.size - 1)
                }
            },
            modifier = Modifier
                .align(Alignment.BottomEnd),
            elevation = FloatingActionButtonDefaults.elevation(12.dp),
            containerColor = MaterialTheme.colorScheme.error,
            contentColor = MaterialTheme.colorScheme.onError
        ) {
            Text("Scroll to End")
        }
    }
}

@Composable
fun HikeCard(
    hike: Hike,
    modifier: Modifier = Modifier,
) {
    Card (
        modifier = modifier.padding(16.dp),
        shape = MaterialTheme.shapes.extraLarge,
        colors = CardColors(
            containerColor = MaterialTheme.colorScheme.secondary,
            contentColor = MaterialTheme.colorScheme.onSecondary,
            disabledContentColor = MaterialTheme.colorScheme.onSecondary,
            disabledContainerColor = MaterialTheme.colorScheme.secondary
        ),
        elevation = CardDefaults.cardElevation(12.dp)
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            val day = hike.day
            Text(

                text = "Day $day",
                style = MaterialTheme.typography.titleLarge.copy(
                        shadow = Shadow(
                            color = Color.Black.copy(alpha = 0.25f),
                            offset = Offset(2f, 2f),
                            blurRadius = 4f
                        )),
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(start = 8.dp, end = 8.dp, top = 8.dp, bottom = 8.dp)
            )
            Image(
                painter = painterResource(hike.ImageResourceId),
                contentDescription = stringResource(hike.StringResourceId),
                modifier = Modifier
                            .fillMaxWidth()
                            .height(200.dp)
                            .padding(start = 16.dp, end = 16.dp)
                            .clip(RoundedCornerShape(16.dp)),
                contentScale = ContentScale.Crop,

            )
            CardText(hike)
        }

    }
}

@Composable
fun AnimatedMountainLevel(hike: Hike) {
    var currIndex by remember { mutableStateOf(0) }
    val description = listOf<String>(hike.level, hike.mountain)

    Box (
        modifier = Modifier.fillMaxWidth()
    ) {
        Image(
            painter = painterResource(hike.trail),
            contentDescription = "trail marking",
            modifier = Modifier
                .fillMaxWidth(0.15f)
                .align(Alignment.CenterStart)
        )
        IconButton(
            onClick = {
                currIndex = (currIndex + 1) % description.size
            },
            modifier = Modifier.align(Alignment.CenterEnd)
        ) {
            Icon(
                imageVector = Icons.Filled.KeyboardArrowRight,
                contentDescription = "next",
                modifier = Modifier.size(32.dp)
            )
        }

        AnimatedContent(
            targetState = description[currIndex],
            modifier = Modifier.padding(end = 8.dp).align(Alignment.Center)
        ) { text ->
            Text(
                text = text,
                style = MaterialTheme.typography.bodyLarge
            )
        }
    }

}

@Composable
fun AnimatedInfo(hike: Hike) {
    var expanded by remember { mutableStateOf(false) }

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 10.dp, vertical = 10.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(20.dp)
    ) {
        Text(
            text = stringResource(hike.StringResourceId),
            style = MaterialTheme.typography.titleLarge.copy(
                shadow = Shadow(
                    color = Color.Black.copy(alpha = 0.25f),
                    offset = Offset(2f, 2f),
                    blurRadius = 4f
                )
            ),
            modifier = Modifier.weight(1f)
        )

        IconButton(
            onClick = { expanded = !expanded }
        ) {
            Icon(
                imageVector = if (expanded) {
                    Icons.Filled.KeyboardArrowUp
                } else {
                    Icons.Filled.KeyboardArrowDown
                },
                contentDescription = "info",
                tint = Color.Black,
                modifier = Modifier.size(48.dp)
            )
        }
    }
    AnimatedVisibility(
        visible = expanded
    ) {
        Text(
            text = hike.info,
            style = MaterialTheme.typography.bodyMedium,
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp, vertical = 8.dp)
        )
    }
}

@Composable
fun Sidebar(modifier: Modifier = Modifier) {
    var expanded by remember { mutableStateOf(false) }

    Box(modifier = modifier.fillMaxSize()) {
        Row (
            modifier = Modifier.align(Alignment.CenterStart),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
            AnimatedVisibility(
                visible = expanded
            ) {
                Card(
                    colors = CardColors(
                        containerColor = MaterialTheme.colorScheme.primary,
                        contentColor = MaterialTheme.colorScheme.onPrimary,
                        disabledContentColor = MaterialTheme.colorScheme.onPrimary,
                        disabledContainerColor = MaterialTheme.colorScheme.primary
                    ),
                    elevation = CardDefaults.cardElevation(defaultElevation = 4.dp),
                    modifier = Modifier.width(50.dp)
                ) {
                    Column (
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Image(
                            painter = painterResource(R.drawable.facebook),
                            contentDescription = "facebook",
                            contentScale = ContentScale.Crop,
                            modifier = Modifier
                                .width(30.dp)
                                .height(30.dp)
                                .align(Alignment.CenterHorizontally)
                        )
                        Spacer(modifier = Modifier.height(16.dp))
                        Image(
                            painter = painterResource(R.drawable.instagram),
                            contentDescription = "facebook",
                            contentScale = ContentScale.Crop,
                            modifier = Modifier
                                .width(30.dp)
                                .height(30.dp)
                                .align(Alignment.CenterHorizontally)
                        )
                        Spacer(modifier = Modifier.height(16.dp))
                        Image(
                            painter = painterResource(R.drawable.x),
                            contentDescription = "x",
                            contentScale = ContentScale.Crop,
                            modifier = Modifier
                                .width(30.dp)
                                .height(30.dp)
                                .align(Alignment.CenterHorizontally)
                        )
                    }
                }
            }
            IconButton(
                onClick = { expanded = !expanded },
                colors = IconButtonColors(
                    containerColor = MaterialTheme.colorScheme.primary,
                    contentColor = MaterialTheme.colorScheme.onPrimary,
                    disabledContentColor = MaterialTheme.colorScheme.onPrimary,
                    disabledContainerColor = MaterialTheme.colorScheme.primary
                )
            ) {
                Icon(
                    imageVector = if (expanded) {
                        Icons.Filled.KeyboardArrowLeft
                    } else {
                        Icons.Filled.KeyboardArrowRight
                    },
                    contentDescription = "info",
                    tint = Color.Black,
                    modifier = Modifier
                        .size(48.dp)
                )
            }
        }
    }
}

@Composable
fun Finish() {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(R.drawable.medal),
            contentDescription = "finish",
            modifier = Modifier
                .size(200.dp)
                .clip(RoundedCornerShape(8.dp))
                .align(Alignment.CenterHorizontally),
            contentScale = ContentScale.Crop
        )
        Text(
            "You reached the end!",
            color = MaterialTheme.colorScheme.inverseSurface,
            style = MaterialTheme.typography.titleLarge.copy(
                shadow = Shadow(
                    color = Color.Black.copy(alpha = 0.25f),
                    offset = Offset(2f, 2f),
                    blurRadius = 4f
                )),
            fontWeight = FontWeight.Bold
        )
    }
}

@Composable
fun CardText(hike: Hike) {
    AnimatedMountainLevel(hike)
    Divider(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 5.dp),
        thickness = 1.dp
    )
    AnimatedInfo(hike)
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    _30DaysOfMountainHikesTheme(darkTheme = false) {
        DaysApp()
    }
}