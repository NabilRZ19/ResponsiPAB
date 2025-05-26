package com.example.responsipab

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Place
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Menu
import androidx.compose.material.icons.outlined.Notifications
import androidx.compose.material.icons.outlined.ShoppingCart
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableDoubleStateOf
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.responsipab.ui.theme.ResponsiPABTheme
import com.example.responsipab.ui.theme.myBlue
import com.example.responsipab.ui.theme.myRed
import com.example.responsipab.ui.theme.myYellow

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ResponsiPABTheme(darkTheme = false) {
                Scaffold(
                    modifier = Modifier.fillMaxSize(),
                    bottomBar = { BottomNavBar() }
                ) { innerPadding ->
                    MainScreen(modifier = Modifier.padding(innerPadding))
                }
            }
        }
    }
}

@Composable
fun MainScreen(modifier: Modifier) {
 LazyColumn (
     modifier = Modifier
         .systemBarsPadding()
 ){
     item { HomeScreen() }

 }

}

@Composable
fun HomeScreen(){
    Column(
        modifier = Modifier
            .background(Color.White)
            .fillMaxSize()
            .padding(
                start = 16.dp,
                end = 16.dp,
                bottom = 16.dp)
    ) {
        TopBarSection()
        Spacer(modifier = Modifier.height(12.dp))

        SearchSection()
        Spacer(modifier = Modifier.height(12.dp))

        AddressSection()
        Spacer(modifier = Modifier.height(16.dp))

        RecommendedDishRow()
        Spacer(modifier = Modifier.height(16.dp))

        CategoryOption()
        Spacer(modifier = Modifier.height(16.dp))

        MenuGrid()
        Spacer(modifier = Modifier.height(12.dp))

    }
}

@Composable
fun TopBarSection() {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Box(
            modifier = Modifier
                .size(40.dp)
                .clip(CircleShape)
                .background(Color.LightGray)
                .clickable {  }
        )
        Icon(
            Icons.Outlined.Notifications,
            contentDescription = "Notification",
            modifier = Modifier .size(30.dp).clickable {  }
        )
    }
}

@Composable
fun SearchSection() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(16.dp))
            .background(myRed)
            .padding(16.dp)
    ) {
        Text("Good Afternoon, User!",
            color = Color.Black,
            fontSize = 21.sp,
            fontWeight = FontWeight.Bold
        )
        Spacer(modifier = Modifier.height(8.dp))
        OutlinedTextField(
            value = "",
            onValueChange = {},
            leadingIcon = {
                Icon(Icons.Default.Search,
                    contentDescription = "Search",
                    //modifier = Modifier.size(18.dp)
                )
                          },
            placeholder = {
                Text(
                    "Search Menu",
                    //fontSize = 12.sp
                )
                          },
            shape = RoundedCornerShape(16.dp),
            colors = OutlinedTextFieldDefaults.colors(
                unfocusedContainerColor = Color.White,
                focusedContainerColor = Color.White
            ),
            modifier = Modifier.fillMaxWidth()//.height(35.dp)
        )
    }
}

@Composable
fun AddressSection() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(75.dp)
            .clip(RoundedCornerShape(16.dp))
            .background(myYellow)
            .padding(16.dp),
        verticalAlignment = Alignment.CenterVertically
//        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Icon(
            Icons.Filled.Place,
            contentDescription = "Pin Point",
            modifier = Modifier
                .size(31.dp)
        )
        Spacer(Modifier.width(12.dp))

        Column(
            modifier = Modifier
                .fillMaxHeight(),
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            Text("Nama Penerima",
                style = MaterialTheme.typography.labelMedium,
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold
            )
            Text("Jl. Surakarta no.xx",
                fontWeight = FontWeight.SemiBold,
                fontSize = 14.sp

            )
        }
        Spacer(Modifier.weight(1f))

        Button(
            colors = ButtonDefaults.buttonColors(
                containerColor = myBlue,   // Warna background button
                contentColor = Color.Black        // Warna teks button
            ),
            onClick = {},
            shape = RoundedCornerShape(36.dp),
            modifier = Modifier
                .border(3.dp, Color.Black, shape = RoundedCornerShape(36.dp))
        ) {
            Text("Ganti Alamat")
        }
    }
}

@Composable
fun RecommendedDishRow() {
    Text(
        "Recommended For You",
        fontSize = 20.sp,
        fontWeight = FontWeight.Bold
        )
    Spacer(modifier = Modifier.height(8.dp))

    LazyRow {
        items(3) {
            Button(
                onClick = {},
                shape = RectangleShape,
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color.Transparent,
                    contentColor = Color.Black,
                )
            ) {
                RecommendedDishItem()
            }

        }
    }
}

@Composable
fun RecommendedDishItem(){
    Column(modifier = Modifier.padding(end = 8.dp)) {
        Box(
            modifier = Modifier
                .width(240.dp)
                .height(120.dp)
                .clip(RoundedCornerShape(16.dp))
                .background(Color.LightGray)
        )
        Text("Dish ")
        Text("Rp 10.000")
    }
}

@Composable
fun CategoryOption() {
    val categories = listOf("Kategori 1", "kategori 2", "kategori 3", "Minuman")
    Text(
        "Our Menu",
        fontSize = 20.sp,
        fontWeight = FontWeight.Bold

    )
    LazyRow(
        modifier = Modifier
            .padding(vertical = 16.dp)
    ) {
        items(categories.size) {
            val color = when (it) {
                0 -> myRed
                1 -> myYellow
                2 -> myRed
                4 -> myBlue
                else -> Color.Gray
            }
            Box(
                modifier = Modifier
                    .padding(end = 8.dp)
                    .border(2.dp, color, RoundedCornerShape(20.dp))
                    .padding(horizontal = 16.dp, vertical = 8.dp)
                    .clickable {  }
            ) {
                Text(categories[it])
            }
        }
    }
}

@Composable
fun MenuGrid(){
    Column {
        LazyVerticalGrid(
            columns = GridCells.Fixed(2), // Menentukan 2 kolom per baris
            modifier = Modifier
                .fillMaxWidth()
                .height(500.dp)
        ){
            items(4){
                    MenuItemCard()
            }
        }

    }

}

@Composable
fun MenuItemCard() {
    Column (
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.Green)
            .clickable {  },
        horizontalAlignment = Alignment.CenterHorizontally

    ) {
        Column(){
            Box(
                modifier = Modifier
                    .size(130.dp)
                    .background(Color.LightGray)
            )
            Spacer(modifier = Modifier.width(8.dp))
            Column {
                Text("Nama Menu")
                Text("Rp 10.000")
            }
        }

    }
}

@Composable
fun BottomNavBar() {
    Row(
        modifier = Modifier
            .systemBarsPadding()
            .fillMaxWidth()
            .height(50.dp)
            .background(Color.White)
            .drawBehind {
                // Gambar garis di bagian atas
                drawLine(
                    color = Color.Gray,
                    start = Offset(0f, 0f),
                    end = Offset(size.width, 0f),
                    strokeWidth = 2f
                )
            },
        horizontalArrangement = Arrangement.SpaceEvenly,
        verticalAlignment = Alignment.CenterVertically
    ) {
        IconButton(
            onClick = { /* TODO: handle Home */ },
            modifier = Modifier
                .size(30.dp)
        ) {
            Icon(
                imageVector = Icons.Filled.Home,
                contentDescription = "Home",
                tint = Color.Black
            )
        }
        IconButton(
            onClick = { /* TODO: handle Cart */ },
            modifier = Modifier
                .size(30.dp)
            ) {
            Icon(
                imageVector = Icons.Outlined.ShoppingCart,
                contentDescription = "Cart",
                tint = Color.Black
            )
        }
        IconButton(
            onClick = { /* TODO: handle Menu */ },
            modifier = Modifier
                .size(30.dp)
            ) {
            Icon(
                imageVector = Icons.Outlined.Menu,
                contentDescription = "Menu",
                tint = Color.Black
            )
        }
    }
}


