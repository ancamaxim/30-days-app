package com.example.a30daysofmountainhikes

import android.graphics.Paint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Arrangement.Absolute.spacedBy
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
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowLeft
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material3.Card
import androidx.compose.material3.CardColors
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CardElevation
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Shapes
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarColors
import androidx.compose.material3.rememberTopAppBarState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shadow
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.layout.ModifierLocalBeyondBoundsLayout
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.a30daysofmountainhikes._30DaysOfMountainHikesTheme
import com.example.a30daysofmountainhikes.onPrimaryContainerLight
import com.example.a30daysofmountainhikes.onSecondaryContainerLight
import com.example.a30daysofmountainhikes.onSurfaceLight
import com.example.a30daysofmountainhikes.primaryContainerLight
import com.example.a30daysofmountainhikes.primaryLight
import com.example.a30daysofmountainhikes.secondaryContainerLight
import com.example.a30daysofmountainhikes.secondaryDarkHighContrast
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
                        color = onPrimaryContainerLight,
                        style = MaterialTheme.typography.titleLarge.copy(
                            shadow = Shadow(
                                color = Color.Black.copy(alpha = 0.25f),
                                offset = Offset(2f, 2f),
                                blurRadius = 4f
                            )),
                        fontWeight = FontWeight.Bold
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
            Column (
                modifier = Modifier
            ) {
                HikeCard(
                    hike = hike,
                    modifier = modifier,
                )
            }
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
            containerColor = secondaryDarkHighContrast,
            contentColor = onSecondaryContainerLight,
            disabledContentColor = onSecondaryContainerLight,
            disabledContainerColor = secondaryDarkHighContrast
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
    _30DaysOfMountainHikesTheme {
        DaysApp()
    }
}