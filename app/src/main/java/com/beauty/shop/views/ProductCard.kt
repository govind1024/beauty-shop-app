package com.beauty.shop.views

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconToggleButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.beauty.shop.R

@Composable
fun ProductCard(
    isBestSeller: Boolean,
    isFavorite: Boolean,
    productImage: Painter, // Product image
    productName: String,
    productDescription: String,
    productBenefits: String,
    oldPrice: Double,
    newPrice: Double,
    rating: Float,
    reviewsCount: Int,
    isInStock: Boolean,
    onFavoriteClick: () -> Unit,
    onAddToCartClick: () -> Unit
) {


    Box(
        modifier = Modifier
            .padding(horizontal = 0.dp, vertical = 10.dp)
            .clip(RoundedCornerShape(40.dp))
            .background(Color.Transparent)
            .fillMaxWidth()
    ) {

        Image(
            painter = painterResource(id = R.drawable.bg_view),
            contentDescription = "Background Image",
            contentScale = ContentScale.FillBounds, // Ensures image matches container size
            modifier = Modifier.matchParentSize() // Forces image to take the size of Column
        )

        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .fillMaxWidth()
        ) {
            Row(
                modifier = Modifier.
                    padding(
                        start = 16.dp, // Left padding
                        top = 10.dp, // Top padding
                        end = 30.dp, // Right padding
                        bottom = 4.dp // Bottom padding
                    ).fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Box(
                    modifier = Modifier
                        .size(38.dp) // Adjust the circle size
                        .background(Color.Black, shape = CircleShape) // Black circular background
                        .padding(4.dp) // Adds padding around the icon
                ) {
                    IconToggleButton(
                        checked = isFavorite,
                        onCheckedChange = { onFavoriteClick() }
                    ) {
                        Icon(
                            imageVector = if (isFavorite) Icons.Default.Favorite else Icons.Default.FavoriteBorder,
                            contentDescription = "Favorite",
                            tint = Color(0xFFB6A1EF)
                        )
                    }
                }

                if (isBestSeller) {
                    Text(
                        text = "Best seller",
                        color = Color(0xFFB6EB43),
                        modifier = Modifier
                            .background(Color(0xFF111111), shape = RoundedCornerShape(15.dp))
                            .padding(horizontal = 10.dp, vertical = 5.dp)
                            ,
                        fontSize = 12.sp,
                        fontFamily = reviewFont,
                        fontWeight = FontWeight.Bold
                    )
                }
            }

            Spacer(modifier = Modifier.height(2.dp))

            Image(
                painter = productImage,
                contentDescription = "Product Image",
                modifier = Modifier
                    .height(300.dp)
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(16.dp)),
                contentScale = ContentScale.Fit
            )

            Spacer(modifier = Modifier.height(12.dp))

            Box(
                modifier = Modifier.padding(horizontal = 14.dp, vertical = 4.dp)
                    .fillMaxWidth()
                    .background(Color.Transparent) // Just in case
            ) {
                Image(
                    painter = painterResource(id = R.drawable.product_title_card),
                    contentDescription = "Details Background",
                    modifier = Modifier.fillMaxWidth(),
                    contentScale = ContentScale.FillBounds
                )

                Column(
                    modifier = Modifier
                        .padding(start = 14.dp, top = 12.dp, end = 8.dp, bottom = 12.dp)
                ) {


                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(
                            text = productName,
                            fontFamily = productNameFont,
                            fontSize = 22.sp,
                            color = Color(0xFFB6EB43),
                        )

                        Text(
                            text = "• " + if (isInStock) "In stock" else "Out of stock",
                            color = if (isInStock) Color(0xFFB4F34E) else Color.Red,
                            fontSize = 12.sp,
                            fontWeight = FontWeight.SemiBold,
                            modifier = Modifier.padding(end = 10.dp)
                        )
                    }

                    Spacer(modifier = Modifier.height(12.dp))

                    Text(
                        text = productDescription,
                        fontFamily = reviewFont,
                        color = Color.White,
                        fontSize = 14.sp
                    )
                    Spacer(modifier = Modifier.height(4.dp))

                    Text(
                        text = productBenefits,
                        color = Color.White,
                        fontFamily = reviewFont,
                        fontSize = 12.sp,
                        fontWeight = FontWeight.SemiBold
                    )

                    Spacer(modifier = Modifier.height(4.dp))

                    Row(verticalAlignment = Alignment.CenterVertically) {

                        Column(
                            modifier = Modifier
                                .padding(
                                    top = 4.dp, // Top padding
                                    end = 20.dp, // Right padding
                                    bottom = 16.dp // Bottom padding
                                )
                                .weight(1f) // Takes proportional space instead of full width
                        ) {
                            Row(verticalAlignment = Alignment.CenterVertically) {
                                Text(
                                    text = "₹$newPrice",
                                    color = Color(0xFFB5A0EE),
                                    fontWeight = FontWeight.Bold,
                                    fontFamily = reviewFont,
                                    fontSize = 16.sp
                                )
                                Spacer(modifier = Modifier.width(8.dp))
                                Text(
                                    text = "₹$oldPrice",
                                    color = Color.Gray,
                                    fontFamily = reviewFont,
                                    fontSize = 12.sp,
                                    textDecoration = TextDecoration.LineThrough
                                )
                            }

                            Spacer(modifier = Modifier.height(1.dp))

                            Row(verticalAlignment = Alignment.CenterVertically) {
                                repeat(5) {
                                    Icon(
                                        imageVector = Icons.Default.Star,
                                        contentDescription = null,
                                        tint = if (it < rating.toInt()) Color(0xFFFFD700) else Color.Gray,
                                        modifier = Modifier.size(16.dp)
                                    )
                                }
                                Spacer(modifier = Modifier.width(4.dp))
                                Text(
                                    text = "$reviewsCount reviews",
                                    color = Color.White,
                                    fontSize = 12.sp ,
                                    fontFamily = reviewFont,
                                    textDecoration = TextDecoration.Underline
                                )
                            }
                        }

                        Spacer(modifier = Modifier.height(8.dp))
                        Box(
                            contentAlignment = Alignment.Center, // Centers icon inside the circle
                            modifier = Modifier
                                .size(55.dp) // Defines box size
                                .background(Color.Transparent, shape = CircleShape) // Ensures visibility
                                .border(1.dp, Color(0xFFB6EB43), shape = CircleShape) // Adds border
                        ) {
                            IconButton(
                                onClick = onAddToCartClick,
                                modifier = Modifier.size(44.dp) // Ensures button fits well inside the box
                            ) {
                                Icon(
                                    painter = painterResource(id = R.drawable.cart_image),
                                    contentDescription = "Add to Cart",
                                    modifier = Modifier.size(24.dp),
                                    tint = Color.Unspecified // Prevents unwanted coloring
                                )
                            }
                        }

                    }

                }

            }

        }
    }

}


@Preview(showBackground = true)
@Composable
fun ProductCardPreview() {
    ProductCard(
        isBestSeller = true,
        isFavorite = true,
        productImage = painterResource(id = R.drawable.product_image), // Product image
        productName = "clencera",
        productDescription = "A refreshing blend of premium green tea leaves.",
        productBenefits = "Boosts metabolism • Rich in antioxidants • Improves focus",
        oldPrice = 499.0,
        newPrice = 349.0,
        rating = 4.5f,
        reviewsCount = 1200,
        isInStock = true,
        onFavoriteClick = {},
        onAddToCartClick = {}
    )
}