package com.afebrii.gymstoriaapp.Screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.afebrii.gymstoriaapp.R
import com.afebrii.gymstoriaapp.ui.theme.ungu

sealed class ArtikelContent {
    data class MenuSehatContent(val items: List<MenuSehatItem>) : ArtikelContent()
    data class TipsContent(val items: List<TipsItem>) : ArtikelContent()
    data class ResepContent(val items: List<ResepItem>) : ArtikelContent()
    data class NutrisiContent(val items: List<NutrisiItem>) : ArtikelContent()
    data class SemuaContent(
        val menuSehatContent: List<MenuSehatItem>,
        val tipsContent: List<TipsItem>,
        val resepContent: List<ResepItem>,
        val nutrisiContent: List<NutrisiItem>
    ) : ArtikelContent()
}

data class MenuSehatItem(val imageId: Int, val text: String, val description: String)
data class TipsItem(val imageId: Int, val text: String, val description: String)
data class ResepItem(val imageId: Int, val text: String, val description: String)
data class NutrisiItem(val imageId: Int, val text: String, val description: String)


@Composable
fun ArtikelScreen() {
    var selectedTheme by remember { mutableStateOf("Semua") } // Deklarasi variabel selectedTheme di sini

    val menuSehatContent = listOf(
        MenuSehatItem(R.drawable.logos_facebook, "Menu Sehat 1", "Deskripsi tentang Menu Sehat 1"),
        MenuSehatItem(R.drawable.logos_facebook, "Menu Sehat 2", "Deskripsi tentang Menu Sehat 2"),
    )

    val tipsContent = listOf(
        TipsItem(R.drawable.logos_facebook, "Tips 1", "Deskripsi tentang Tips 1"),
        TipsItem(R.drawable.logos_facebook, "Tips 2", "Deskripsi tentang Tips 2"),
    )

    val resepContent = listOf(
        ResepItem(R.drawable.logos_facebook, "Resep 1", "Deskripsi tentang Resep 1"),
        ResepItem(R.drawable.logos_facebook, "Resep 2", "Deskripsi tentang Resep 2"),
    )

    val nutrisiContent = listOf(
        NutrisiItem(R.drawable.logos_facebook, "Nutrisi 1", "Deskripsi tentang Nutrisi 1"),
        NutrisiItem(R.drawable.logos_facebook, "Nutrisi 2", "Deskripsi tentang Nutrisi 2"),
    )

    Column(
        modifier = Modifier
            .fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .background(ungu)
                .padding(vertical = 16.dp)
        ) {
            Text(
                text = "Artikel",
                color = Color.White,
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp)
            )
        }

        LazyRow(
            modifier = Modifier.fillMaxWidth(),
            contentPadding = PaddingValues(horizontal = 16.dp, vertical = 8.dp)
        ) {
            items(5) { index ->
                val theme = when (index) {
                    0 -> "Semua"
                    1 -> "Menu Sehat"
                    2 -> "Tips"
                    3 -> "Resep"
                    4 -> "Nutrisi"
                    else -> "Semua"
                }
                val buttonColors = if (selectedTheme == theme) {
                    ButtonDefaults.buttonColors(ungu)
                } else {
                    ButtonDefaults.buttonColors(Color.Gray)
                }
                Button(
                    onClick = {
                        selectedTheme = theme
                    },
                    modifier = Modifier.padding(end = 8.dp),
                    shape = MaterialTheme.shapes.medium,
                    colors = buttonColors
                ) {
                    Text(
                        text = theme,
                        color = Color.White
                    )
                }
            }
        }


        // Spacer agar ada jarak antara LazyRow dan LazyColumn
        Spacer(modifier = Modifier.height(8.dp))

        // LazyColumn
        LazyColumn(
            modifier = Modifier.fillMaxWidth(),
            contentPadding = PaddingValues(horizontal = 16.dp, vertical = 8.dp)
        ) {
            val content = when (selectedTheme) {
                "Menu Sehat" -> ArtikelContent.MenuSehatContent(menuSehatContent)
                "Tips" -> ArtikelContent.TipsContent(tipsContent)
                "Resep" -> ArtikelContent.ResepContent(resepContent)
                "Nutrisi" -> ArtikelContent.NutrisiContent(nutrisiContent)
                "Semua" -> ArtikelContent.SemuaContent(
                    menuSehatContent,
                    tipsContent,
                    resepContent,
                    nutrisiContent
                ) // Tambahkan case untuk tema "Semua" di sini
                else -> ArtikelContent.MenuSehatContent(menuSehatContent)
            }

            when (content) {
                is ArtikelContent.MenuSehatContent -> {
                    itemsIndexed(content.items) { index, item ->
                        ListItem(index, item)
                    }
                }
                is ArtikelContent.TipsContent -> {
                    itemsIndexed(content.items) { index, item ->
                        ListItem(index, item)
                    }
                }
                is ArtikelContent.ResepContent -> {
                    itemsIndexed(content.items) { index, item ->
                        ListItem(index, item)
                    }
                }
                is ArtikelContent.NutrisiContent -> {
                    itemsIndexed(content.items) { index, item ->
                        ListItem(index, item)
                    }
                }
                is ArtikelContent.SemuaContent -> {
                    // Menampilkan semua item untuk setiap jenis konten
                    itemsIndexed(content.menuSehatContent) { index, item ->
                        ListItem(index, item)
                    }
                    itemsIndexed(content.tipsContent) { index, item ->
                        ListItem(index, item)
                    }
                    itemsIndexed(content.resepContent) { index, item ->
                        ListItem(index, item)
                    }
                    itemsIndexed(content.nutrisiContent) { index, item ->
                        ListItem(index, item)
                    }
                }
                else -> error("Unsupported content type: $content")
            }
        }
    }
}

@Composable
fun ListItem(index: Int, item: Any) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxWidth()
            .padding(bottom = 28.dp)
    ) {
        Image(
            painter = painterResource(id = (item as? MenuSehatItem)?.imageId ?: R.drawable.logos_facebook),
            contentDescription = "Image $index",
            modifier = Modifier
                .padding(end = 10.dp)
                .size(40.dp, 40.dp)
        )

        Column {
            Text(
                text = when (item) {
                    is MenuSehatItem -> item.text
                    is TipsItem -> item.text
                    is ResepItem -> item.text
                    is NutrisiItem -> item.text
                    else -> "Unknown"
                },
                color = Color.Black,
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(bottom = 4.dp)
            )

            Text(
                text = when (item) {
                    is MenuSehatItem -> item.description
                    is TipsItem -> item.description
                    is ResepItem -> item.description
                    is NutrisiItem -> item.description
                    else -> "Unknown Description"
                },
                color = Color.Gray,
                fontSize = 14.sp,
                modifier = Modifier.padding(bottom = 4.dp)
            )
        }
    }
}
