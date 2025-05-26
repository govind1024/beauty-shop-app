package com.beauty.shop.views

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.beauty.shop.R
import com.beauty.shop.models.Category
import com.beauty.shop.models.Deal
import com.beauty.shop.models.Product

val mainTitleFont = FontFamily(
    Font(R.font.century_old_style_std_bold, FontWeight.Normal)
)
val productNameFont = FontFamily(
    Font(R.font.tangerine, FontWeight.Normal)
)

val reviewFont = FontFamily(
    Font(R.font.neuzeitsltstdbook, FontWeight.Normal)
)




@Preview()
@Composable
fun ProductListScreen() {
    val favoriteCount = remember { mutableStateOf(0) }
    val cartCount = remember { mutableStateOf(0) }
    val painter =
        painterResource(id = R.drawable.product_image) // Add your product image to resources
    val mockCategories = listOf(
        Category("Cleaners", R.drawable.categorysample),
        Category("Toner", R.drawable.categorysample),
        Category("Serums", R.drawable.categorysample),
        Category("Moisturisers", R.drawable.categorysample),
        Category("Sunscreen", R.drawable.categorysample),
        Category("Glow", R.drawable.categorysample),
        Category("Aftershave", R.drawable.categorysample),
        Category("Shaver", R.drawable.categorysample)
    )

    val mockDeals = listOf(
        Deal("GET 20% OFF", "Get 20% off", "12–16 October", android.R.drawable.ic_menu_gallery),
        Deal(
            "BUY 1 GET 1",
            "Limited time offer",
            "18–20 October",
            android.R.drawable.ic_menu_camera
        ),
        Deal(
            "BUY 4 GET 7",
            "Limited time offer",
            "22–26 October",
            android.R.drawable.ic_menu_agenda
        )
    )

    val productList = remember {
        mutableStateListOf(
            Product(
                productName = "Glow",
                productDescription = "A brightening serum infused with Vitamin C.",
                productBenefits = "Evens skin tone • Fights dullness • Hydrates",
                oldPrice = 699.0,
                newPrice = 549.0,
                rating = 4.7f,
                reviewsCount = 1543,
                isBestSeller = true,
                isFavorite = false,
                isAddedToCart = false,
                isInStock = true,
                productImage = R.drawable.product_image
            ),
            Product(
                productName = "Afterglow",
                productDescription = "A soothing post-sun recovery cream.",
                productBenefits = "Repairs sun damage • Hydrates • Reduces redness",
                oldPrice = 799.0,
                newPrice = 599.0,
                rating = 4.6f,
                reviewsCount = 890,
                isBestSeller = false,
                isFavorite = false,
                isAddedToCart = false,
                isInStock = false,
                productImage = R.drawable.product_image
            ),
            Product(
                productName = "Facewash",
                productDescription = "Deep cleansing facewash with green tea extracts.",
                productBenefits = "Controls oil • Removes impurities • Refreshes skin",
                oldPrice = 499.0,
                newPrice = 349.0,
                rating = 4.5f,
                reviewsCount = 1200,
                isBestSeller = true,
                isFavorite = false,
                isAddedToCart = false,
                isInStock = true,
                productImage = R.drawable.product_image
            ),
            Product(
                productName = "HydraBoost",
                productDescription = "Intense hydration gel with Hyaluronic Acid.",
                productBenefits = "Moisturizes • Plumps skin • Locks hydration",
                oldPrice = 699.0,
                newPrice = 549.0,
                rating = 4.8f,
                reviewsCount = 2134,
                isBestSeller = true,
                isFavorite = false,
                isAddedToCart = false,
                isInStock = true,
                productImage = R.drawable.product_image
            ),
            Product(
                productName = "Sunscreen Pro",
                productDescription = "Lightweight SPF 50 sunscreen with matte finish.",
                productBenefits = "Blocks UV rays • Oil-free formula • Non-greasy",
                oldPrice = 899.0,
                newPrice = 699.0,
                rating = 4.7f,
                reviewsCount = 1780,
                isBestSeller = true,
                isFavorite = false,
                isAddedToCart = false,
                isInStock = true,
                productImage = R.drawable.product_image
            ),
            Product(
                productName = "Night Repair",
                productDescription = "Overnight skin recovery serum.",
                productBenefits = "Repairs skin barrier • Anti-aging • Deep nourishment",
                oldPrice = 999.0,
                newPrice = 799.0,
                rating = 4.9f,
                reviewsCount = 2430,
                isBestSeller = true,
                isFavorite = false,
                isAddedToCart = false,
                isInStock = true,
                productImage = R.drawable.product_image
            ),
            Product(
                productName = "Moisture Lock",
                productDescription = "Ultra-hydrating moisturizer for all skin types.",
                productBenefits = "Softens skin • Hydrates deeply • Long-lasting",
                oldPrice = 649.0,
                newPrice = 499.0,
                rating = 4.6f,
                reviewsCount = 1300,
                isBestSeller = false,
                isFavorite = false,
                isAddedToCart = false,
                isInStock = false,
                productImage = R.drawable.product_image
            ),
            Product(
                productName = "ClearSkin",
                productDescription = "Acne-fighting gel with Salicylic Acid.",
                productBenefits = "Reduces pimples • Prevents breakouts • Gentle formula",
                oldPrice = 799.0,
                newPrice = 599.0,
                rating = 4.5f,
                reviewsCount = 960,
                isBestSeller = false,
                isFavorite = false,
                isAddedToCart = false,
                isInStock = true,
                productImage = R.drawable.product_image
            ),
            Product(
                productName = "Aftershave Balm",
                productDescription = "Cooling balm for post-shave hydration.",
                productBenefits = "Soothes skin • Prevents irritation • Refreshing formula",
                oldPrice = 599.0,
                newPrice = 449.0,
                rating = 4.4f,
                reviewsCount = 845,
                isBestSeller = false,
                isFavorite = false,
                isAddedToCart = false,
                isInStock = true,
                productImage = R.drawable.product_image
            ),
            Product(
                productName = "Shaver Pro",
                productDescription = "Advanced electric shaver for precision shaving.",
                productBenefits = "Smooth shave • Skin-friendly blades • Long battery life",
                oldPrice = 1899.0,
                newPrice = 1499.0,
                rating = 4.7f,
                reviewsCount = 1920,
                isBestSeller = true,
                isFavorite = false,
                isAddedToCart = false,
                isInStock = true,
                productImage = R.drawable.product_image
            )
        )
    }

    Box(
        modifier = Modifier.fillMaxSize().background(Color(0xFF2A2A2A)) // Set background color
    ) {
        Column(
            modifier = Modifier.fillMaxSize()
        ) {

            ShopTopBar(
                cartCount = cartCount.value, // Update dynamically
                favoriteCount = favoriteCount.value, // Update dynamically
                onBackClick = {},
                onSearchClick = {},
                onFavoriteClick = {},
                onCartClick = {}
            )
            Spacer(modifier = Modifier.height(4.dp))
            LazyColumn( // Converts the full UI into a scrollable list
                modifier = Modifier.fillMaxSize()
            ) {
                item {
                    DealsSlider(deals = mockDeals)
                    Spacer(modifier = Modifier.height(12.dp))
                    CategoriesSection(categories = mockCategories)
                    Spacer(modifier = Modifier.height(12.dp))

                    Row(
                        modifier = Modifier.fillMaxWidth().padding(12.dp),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(
                            text = "New Products",
                            fontFamily = mainTitleFont,
                            fontSize = 22.sp,
                            color = Color.White,
                        )
                        Text(
                            text = "See all",
                            color = Color.White,
                            fontSize = 12.sp,
                            fontWeight = FontWeight.SemiBold,
                            textDecoration = TextDecoration.Underline
                        )
                    }

                    Spacer(modifier = Modifier.height(12.dp))
                }

                items(productList) { product ->
                    ProductCard(
                        isBestSeller = product.isBestSeller,
                        isFavorite = product.isFavorite,
                        productImage = painterResource(id = product.productImage),
                        productName = product.productName,
                        productDescription = product.productDescription,
                        productBenefits = product.productBenefits,
                        oldPrice = product.oldPrice,
                        newPrice = product.newPrice,
                        rating = product.rating,
                        reviewsCount = product.reviewsCount,
                        isInStock = product.isInStock,
                        onFavoriteClick = { markFavorite(productList, product, favoriteCount) },
                        onAddToCartClick = { addToCart(productList, product, cartCount) }
                    )
                }

            }
        }
    }
}
fun markFavorite(productList: SnapshotStateList<Product>, product: Product, favoriteCount: MutableState<Int>) {
    val index = productList.indexOf(product)
    if (index != -1) {
        val currentFavoriteStatus = productList[index].isFavorite // Check current status
        val updatedProduct = product.copy(isFavorite = !currentFavoriteStatus) // Toggle

        productList[index] = updatedProduct // Apply update

        // Update favorite count based on the new state
        favoriteCount.value = productList.count { it.isFavorite }
    }
}

fun addToCart(productList: SnapshotStateList<Product>, product: Product, cartCount: MutableState<Int>) {
    val index = productList.indexOf(product)
    if (index != -1) {
        val currentCartStatus = productList[index].isAddedToCart // Check current status
        val updatedProduct = product.copy(isAddedToCart = !currentCartStatus) // Toggle status

        productList[index] = updatedProduct // Apply the change

        // Sync cart count dynamically based on actual cart items
        cartCount.value = productList.count { it.isAddedToCart }
    }
}



