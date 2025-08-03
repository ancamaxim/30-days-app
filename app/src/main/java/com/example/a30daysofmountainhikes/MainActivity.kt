package com.example.a30daysofmountainhikes

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.a30daysofmountainhikes.ui.theme._30DaysOfMountainHikesTheme
import com.example.a30daysofmountainhikes.ui.theme.onPrimaryContainerLight
import com.example.a30daysofmountainhikes.ui.theme.primaryContainerLight
import com.example.a30daysofmountainhikes.ui.theme.primaryLight

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
            modifier = Modifier.padding(innerPadding)
        )
    }
}

@Composable
fun DaysList(
    modifier: Modifier = Modifier
) {

}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    _30DaysOfMountainHikesTheme {
        DaysApp()
    }
}