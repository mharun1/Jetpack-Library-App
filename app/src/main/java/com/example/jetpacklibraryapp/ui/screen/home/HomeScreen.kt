package com.example.jetpacklibraryapp.ui.screen.home

import android.content.res.Configuration
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.jetpacklibraryapp.ui.component.Banner
import com.example.jetpacklibraryapp.ui.theme.JetpackLibraryAppTheme

@Composable
fun HomeScreen(modifier: Modifier = Modifier) {
    Scaffold { innerPadding ->
        Column (
            modifier = modifier
                .padding(innerPadding)
                .fillMaxSize(),
        ) {
            Banner()
        }
    }
}

@Preview(showBackground = true)
@Composable
fun HomeScreenPreview() {
    JetpackLibraryAppTheme {
        HomeScreen()
    }
}