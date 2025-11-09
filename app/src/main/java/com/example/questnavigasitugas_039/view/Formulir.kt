// Nama File: Formulir.kt
package com.example.questnavigasitugas_039.view

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.selection.selectable
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
// PERUBAHAN: Import FormData dari package utama
import com.example.questnavigasitugas_039.FormData

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FormulirScreen(
    onNavigateBack: () -> Unit,
    onAddData: (FormData) -> Unit // PERUBAHAN: Parameter baru untuk "menyimpan"
) {
    // State untuk input form
    var namaLengkap by remember { mutableStateOf("") }
    val jenisKelaminOptions = listOf("Laki-laki", "Perempuan")
    var selectedJenisKelamin by remember { mutableStateOf("") }
    val statusOptions = listOf("Pilih status kawin", "Kawin", "Belum Kawin", "Cerai", "Lajang")
    var selectedStatus by remember { mutableStateOf(statusOptions[0]) }
    var statusDropdownExpanded by remember { mutableStateOf(false) }
    var alamat by remember { mutableStateOf("") }

    // --- STATE BARU UNTUK DIALOG ---
    var showSuccessDialog by remember { mutableStateOf(false) }
    var submittedData by remember { mutableStateOf<FormData?>(null) }
    // --------------------------------

    Scaffold(
        containerColor = Color(0xFF1A1A2E)
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .systemBarsPadding()
                .padding(24.dp)
                .verticalScroll(rememberScrollState())
        ) {
            Text(
                text = "Formulir Pendaftaran",
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold,
                color = Color(0xFF9D4EDD),
                modifier = Modifier.padding(bottom = 24.dp)
            )

