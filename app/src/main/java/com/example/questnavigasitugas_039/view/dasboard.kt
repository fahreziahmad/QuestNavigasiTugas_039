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

            Text(
                text = "Selamat Datang",
                fontSize = 28.sp,
                fontWeight = FontWeight.Bold,
                // WARNA TEKS DIUBAH: Menjadi ungu terang agar terlihat di latar gelap
                color = Color(0xFF9D4EDD)
            )

            Spacer(modifier = Modifier.height(64.dp)) // Jarak di atas logo

            // UKURAN LOGO BARU: Diperbesar
            Image(
                // Ganti 'logoq' jika nama file Anda berbeda
                painter = painterResource(id = R.drawable.logoq),
                contentDescription = "Logo Aplikasi",
                modifier = Modifier.size(220.dp) // Ukuran logo diubah di sini
            )

            // Spacer ini mendorong nama & tombol ke bawah
            Spacer(modifier = Modifier.weight(1f))

            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Text(
                    text = "Fahrezi Ahmad Syahyana",
                    fontSize = 16.sp,
                    // WARNA TEKS DIUBAH: Menjadi putih
                    color = Color.White
                )
                Text(
                    text = "20230140039",
                    fontSize = 14.sp,
                    // WARNA TEKS DIUBAH: Menjadi abu-abu terang
                    color = Color.LightGray
                )
            }

