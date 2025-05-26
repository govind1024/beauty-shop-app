package com.beauty.shop.views

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.beauty.shop.R
import com.beauty.shop.models.Deal
import com.beauty.shop.ui.theme.ProductTheme
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.rememberPagerState


@OptIn(ExperimentalPagerApi::class)
@Composable
fun DealsSlider(deals: List<Deal>) {
    val pagerState = rememberPagerState()
    Box(
        modifier = Modifier.fillMaxWidth().height(220.dp).background(Color(0xFF2A2A2A))
    ) {
        // Background Image
        Image(
            painter = painterResource(id = R.drawable.banner_card),
            contentDescription = null,
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.FillBounds // Ensures full image coverage
        )

        Column(
            modifier = Modifier
                .fillMaxWidth().background(Color.Transparent)
                .height(220.dp),
            verticalArrangement = Arrangement.SpaceBetween
        ) {



            HorizontalPager(
                count = deals.size,
                state = pagerState,
                modifier = Modifier.weight(1f)
            ) { page ->
                DealCard(deal = deals[page])
            }

            // Page indicator

            CustomPagerIndicator(
                pagerState = pagerState,
                modifier = Modifier
                    .align(Alignment.Start)
                    .padding(start = 80.dp, bottom = 4.dp, top = 4.dp)
            )

           /* HorizontalPagerIndicator(
                pagerState = pagerState,
                activeColor = Color(0xFFB2FF59), // light green
                inactiveColor = Color.DarkGray,
                indicatorWidth = 10.dp,
                indicatorShape = RoundedCornerShape(4.dp),
                spacing = 8.dp,
                modifier = Modifier
                    .align(Alignment.Start)
                    .padding(start = 80.dp)
            )*/
        }
    }


}
@Preview(showBackground = true)
@Composable
fun DealsSliderPreview() {
    val mockDeals = listOf(
        Deal("GET 20% OFF", "Get 20% off", "12–16 October", android.R.drawable.ic_menu_gallery),
        Deal("BUY 1 GET 1", "Limited time offer", "18–20 October", android.R.drawable.ic_menu_camera),
        Deal("BUY 4 GET 7", "Limited time offer", "22–26 October", android.R.drawable.ic_menu_agenda)
    )

    ProductTheme {
        DealsSlider(deals = mockDeals)
    }
}



