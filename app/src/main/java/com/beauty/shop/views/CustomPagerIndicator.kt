package com.beauty.shop.views

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.google.accompanist.pager.ExperimentalPagerApi

@OptIn(ExperimentalPagerApi::class)
@Composable
fun CustomPagerIndicator(
    pagerState: com.google.accompanist.pager.PagerState,
    modifier: Modifier = Modifier,
    activeColor: Color = Color(0xFFB2FF59),
    inactiveColor: Color = Color(0xFF111111),
    activeWidth: Dp = 24.dp,
    inactiveSize: Dp = 10.dp,
    spacing: Dp = 8.dp
) {
    val pageCount = pagerState.pageCount
    val currentPage = pagerState.currentPage

    Row(
        horizontalArrangement = Arrangement.spacedBy(spacing),
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier
    ) {
        repeat(pageCount) { index ->
            val isSelected = index == currentPage

            Box(
                modifier = Modifier
                    .height(inactiveSize)
                    .width(if (isSelected) activeWidth else inactiveSize)
                    .clip(RoundedCornerShape(50))
                    .background(if (isSelected) activeColor else inactiveColor)
            )
        }
    }
}
