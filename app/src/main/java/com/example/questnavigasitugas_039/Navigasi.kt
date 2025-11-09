// Nama File: Navigasi.kt
// (Pastikan package Anda sesuai)
package com.example.questnavigasitugas_039

import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.questnavigasitugas_039.view.DashboardScreen
import com.example.questnavigasitugas_039.view.FormulirScreen
import com.example.questnavigasitugas_039.view.TampilDataScreen

// --- KITA DEFINISIKAN DATA CLASS DI SINI ---
// (Agar bisa dipakai oleh TampilData.kt dan Formulir.kt)
data class FormData(
    val nama: String,
    val gender: String,
    val status: String,
    val alamat: String
)

// --- DATA AWAL KITA PINDAHKAN KE SINI ---
val initialDataList = listOf(
    FormData("Lamin yamal", "Laki - Laki", "Cerai", "Sleman"),
    FormData("Kasih rohimah", "Perempuan", "Lajang", "Bantul"),
    FormData("Hamdan abdullah", "Laki - Laki", "Kawin", "Jogja")
)
// ---------------------------------------------

object AppRoutes {
    const val DASHBOARD = "dashboard"
    const val TAMPIL_DATA = "tampil_data"
    const val FORMULIR = "formulir"
}

@Composable
fun AppNavigation() {
    val navController = rememberNavController()

    // --- STATE UTAMA UNTUK MENYIMPAN DATA ---
    val listPeserta = remember {
        mutableStateOf(initialDataList)
    }
    // ----------------------------------------

    NavHost(
        navController = navController,
        startDestination = AppRoutes.DASHBOARD
    ) {
        // Rute untuk Layar Dashboard
        composable(AppRoutes.DASHBOARD) {
            DashboardScreen(
                onNavigateToList = {
                    navController.navigate(AppRoutes.TAMPIL_DATA)
                }
            )
        }

        // Rute untuk Layar Tampil Data
        composable(AppRoutes.TAMPIL_DATA) {
            TampilDataScreen(
                // PERUBAHAN: Berikan daftar data saat ini ke layar
                listPeserta = listPeserta.value,
                onNavigateToDashboard = {
                    navController.navigate(AppRoutes.DASHBOARD) {
                        popUpTo(AppRoutes.DASHBOARD) { inclusive = true }
                    }
                },
                onNavigateToForm = {
                    navController.navigate(AppRoutes.FORMULIR)
                }
            )
        }

        // Rute untuk Layar Formulir
        composable(AppRoutes.FORMULIR) {
            FormulirScreen(
                onNavigateBack = {
                    navController.popBackStack() // Kembali ke layar sebelumnya
                },
                // PERUBAHAN: Berikan "fungsi" untuk menambah data
                onAddData = { newData ->
                    // Ini adalah logika untuk "menyimpan" data baru
                    listPeserta.value = listPeserta.value + newData
                }
            )
        }
    }
}