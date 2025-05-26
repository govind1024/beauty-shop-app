package com.beauty.shop.views

import android.R
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.beauty.shop.models.Deal
import com.beauty.shop.ui.theme.ProductTheme


@Composable
fun DealCard(deal: Deal) {
    Box(
        modifier = Modifier
            .padding(16.dp)
            .fillMaxWidth()
            .clip(RoundedCornerShape(28.dp))
            .padding(20.dp)
    ) {


        Column(modifier = Modifier.fillMaxSize()) {
            Text(
                text = deal.title,
                fontFamily = reviewFont,
                    fontWeight = FontWeight.Bold,
                    color = Color.White,
                    fontSize = 28.sp

            )

            Spacer(modifier = Modifier.height(8.dp))

            Text(
                text = deal.subtitle,
                fontFamily = reviewFont,
                fontWeight = FontWeight.Normal,
                color = Color.White,
                fontSize = 16.sp
            )

            Spacer(modifier = Modifier.height(20.dp))

            Box(
                modifier = Modifier
                    .clip(RoundedCornerShape(20.dp))
                    .background(Color(0xFFB2FF59))
                    .padding(horizontal = 12.dp, vertical = 4.dp)
            ) {
                Text(text = deal.dateRange, color = Color.Black, fontFamily = reviewFont, fontWeight = FontWeight.Bold)
            }
        }

        // Image or placeholder icon (right aligned)
        Icon(
            imageVector = Icons.Default.Add,
            contentDescription = null,
            tint = Color.Gray,
            modifier = Modifier
                .size(48.dp)
                .align(Alignment.BottomEnd)
        )
    }
}
@Preview(showBackground = true)
@Composable
fun DealsSliderPrevieww() {
    val mockDeals = listOf(
        Deal("GET 20% OFF", "Get 20% off", "12–16 October", R.drawable.ic_menu_gallery),
        Deal("BUY 1 GET 1", "Limited time offer", "18–20 October", R.drawable.ic_menu_camera),
        Deal("BUY 4 GET 7", "Limited time offer", "22–26 October", R.drawable.ic_menu_agenda)
    )

    ProductTheme {
        DealsSlider(deals = mockDeals)
    }
}

