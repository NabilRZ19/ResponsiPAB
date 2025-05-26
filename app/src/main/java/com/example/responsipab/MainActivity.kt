package com.example.responsipab

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.responsipab.ui.theme.ResponsiPABTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ResponsiPABTheme(darkTheme = false) {
                Scaffold(
                    modifier = Modifier.fillMaxSize(),
                    bottomBar = { BottomNavigationBar() }
                ) { innerPadding ->
                    MainScreen(modifier = Modifier.padding(innerPadding))
                }
            }
        }
    }
}

@Composable
fun MainScreen(modifier: Modifier = Modifier) {
    LazyColumn(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        item {
            TopBarSection()
            Spacer(modifier = Modifier.height(8.dp))
            SearchSection()
            Spacer(modifier = Modifier.height(8.dp))
            AddressSection()
            Spacer(modifier = Modifier.height(16.dp))
            Text("Recommendation Menu", style = MaterialTheme.typography.titleMedium)
            Spacer(modifier = Modifier.height(8.dp))
            RecommendedDishRow()
            Spacer(modifier = Modifier.height(16.dp))
            CategoryChips()
            Spacer(modifier = Modifier.height(16.dp))
        }

        // Daftar menu makanan
        items(6) {
            MenuItemCard()
            Spacer(modifier = Modifier.height(12.dp))
        }
    }
}

@Composable
fun TopBarSection() {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Box(
            modifier = Modifier
                .size(40.dp)
                .clip(CircleShape)
                .background(Color.LightGray)
        )
        Icon(Icons.Default.Notifications, contentDescription = "Notification")
    }
}

@Composable
fun SearchSection() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(12.dp))
            .background(Color(0xFFFF5F5F))
            .padding(16.dp)
    ) {
        Text("Good Afternoon, User!", style = MaterialTheme.typography.titleMedium, color = Color.Black)
        Spacer(modifier = Modifier.height(8.dp))
        OutlinedTextField(
            value = "",
            onValueChange = {},
            leadingIcon = { Icon(Icons.Default.Search, contentDescription = "Search") },
            placeholder = { Text("Search Menu") },
            shape = RoundedCornerShape(10.dp),
            colors = OutlinedTextFieldDefaults.colors(
                unfocusedContainerColor = Color.White,
                focusedContainerColor = Color.White
            ),
            modifier = Modifier.fillMaxWidth()
        )
    }
}

@Composable
fun AddressSection() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(16.dp))
            .background(Color(0xFFFFDE59))
            .padding(16.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Column {
            Text("Nama Penerima", style = MaterialTheme.typography.labelMedium)
            Text("Jl. Surakarta no.xx", style = MaterialTheme.typography.bodySmall)
        }
        Button(
            onClick = {},
            shape = RoundedCornerShape(12.dp)
        ) {
            Text("Ganti Alamat")
        }
    }
}

@Composable
fun RecommendedDishRow() {
    LazyRow {
        items(2) {
            Column(modifier = Modifier.padding(end = 8.dp)) {
                Box(
                    modifier = Modifier
                        .size(120.dp)
                        .background(Color.LightGray)
                )
                Text("Dish ${it + 1}")
                Text("Rp ${if (it == 0) "15.000" else "20.000"}")
            }
        }
    }
}

@Composable
fun CategoryChips() {
    val categories = listOf("Kategori 1", "kategori 2", "kategori 3")
    LazyRow {
        items(categories.size) {
            val color = when (it) {
                0 -> Color.Red
                1 -> Color.Cyan
                2 -> Color(0xFFFFDE59)
                else -> Color.Gray
            }
            Box(
                modifier = Modifier
                    .padding(end = 8.dp)
                    .border(2.dp, color, RoundedCornerShape(20.dp))
                    .padding(horizontal = 16.dp, vertical = 8.dp)
            ) {
                Text(categories[it])
            }
        }
    }
}

@Composable
fun MenuItemCard() {
    Row(modifier = Modifier.fillMaxWidth()) {
        Box(
            modifier = Modifier
                .size(120.dp)
                .background(Color.LightGray)
        )
        Spacer(modifier = Modifier.width(8.dp))
        Column {
            Text("Nama Menu")
            Text("Rp 10.000")
        }
    }
}



@Composable
fun BottomNavigationBar() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(56.dp)
            .background(Color.White),
        horizontalArrangement = Arrangement.SpaceEvenly,
        verticalAlignment = Alignment.CenterVertically
    ) {
        IconButton(onClick = { /* TODO: handle Home */ }) {
            Icon(
                imageVector = Icons.Default.Home,
                contentDescription = "Home",
                tint = Color.Black
            )
        }
        IconButton(onClick = { /* TODO: handle Cart */ }) {
            Icon(
                imageVector = Icons.Default.ShoppingCart,
                contentDescription = "Cart",
                tint = Color.Black
            )
        }
        IconButton(onClick = { /* TODO: handle Menu */ }) {
            Icon(
                imageVector = Icons.Default.Menu,
                contentDescription = "Menu",
                tint = Color.Black
            )
        }
    }
}


