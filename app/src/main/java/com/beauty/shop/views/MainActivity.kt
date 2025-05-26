package com.beauty.shop.views

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.beauty.shop.ui.theme.ProductTheme
import com.google.accompanist.systemuicontroller.rememberSystemUiController


class MainActivity2 : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //enableEdgeToEdge()

        setContent {
            ProductTheme {
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .statusBarsPadding() // Prevents overlap with status bar
                ) {
                    SetupSystemBar()
                    ProductListScreen()
                }
            }
        }
    }
}


@Composable
fun SetupSystemBar() {
    val systemUiController = rememberSystemUiController()
    systemUiController.setSystemBarsColor(
        color = Color(0xFF2A2A2A), // Set the desired status bar color
        darkIcons = false // Ensures light icons for dark background
    )
}