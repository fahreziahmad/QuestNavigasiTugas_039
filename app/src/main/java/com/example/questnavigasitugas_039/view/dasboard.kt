// Nama File: Dasboard.kt
package com.example.questnavigasitugas_039.view // Pastikan package Anda sesuai

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.questnavigasitugas_039.R // Pastikan import R ini ada

@Composable
fun DashboardScreen(
    onNavigateToList: () -> Unit // Parameter untuk navigasi
) {
    // WARNA BARU: Tema gelap (ungu-hitam) agar serasi dengan logo
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = Color(0xFF1A1A2E)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(32.dp) // Jarak aman dari tepi layar
                .systemBarsPadding(), // Jarak aman dari tombol navigasi sistem
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

