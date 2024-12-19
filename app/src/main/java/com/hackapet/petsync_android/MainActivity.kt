package com.hackapet.petsync_android

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.hackapet.petsync_android.ui.AppNavigator
import com.hackapet.petsync_android.ui.screens.home.HomeScreen
import com.hackapet.petsync_android.ui.theme.PetsyncandroidTheme

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            PetsyncandroidTheme {
                AppNavigator()
            }
        }
    }
}




@Preview(showBackground = true)
@Composable
fun PetsPreview() {
    PetsyncandroidTheme {
        AppNavigator()
    }
}