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

            // --- Form Input (Tidak ada perubahan di sini) ---
            FormTextField(
                label = "NAMA LENGKAP",
                value = namaLengkap,
                onValueChange = { namaLengkap = it },
                placeholder = "Isikan nama lengkap"
            )
            Spacer(modifier = Modifier.height(16.dp))
            Text("JENIS KELAMIN", style = MaterialTheme.typography.labelMedium, color = Color.LightGray)
            Row(modifier = Modifier.fillMaxWidth()) {
                jenisKelaminOptions.forEach { option ->
                    Row(
                        Modifier
                            .selectable(
                                selected = (selectedJenisKelamin == option),
                                onClick = { selectedJenisKelamin = option }
                            )
                            .padding(end = 16.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        RadioButton(
                            selected = (selectedJenisKelamin == option),
                            onClick = { selectedJenisKelamin = option },
                            colors = RadioButtonDefaults.colors(
                                selectedColor = Color(0xFF9D4EDD),
                                unselectedColor = Color.LightGray
                            )
                        )
                        Text(text = option, color = Color.White)
                    }
                }
            }
            Spacer(modifier = Modifier.height(16.dp))
            Text("STATUS PERKAWINAN", style = MaterialTheme.typography.labelMedium, color = Color.LightGray)
            ExposedDropdownMenuBox(
                expanded = statusDropdownExpanded,
                onExpandedChange = { statusDropdownExpanded = !statusDropdownExpanded }
            ) {
                OutlinedTextField(
                    value = selectedStatus,
                    onValueChange = {},
                    readOnly = true,
                    trailingIcon = {
                        ExposedDropdownMenuDefaults.TrailingIcon(expanded = statusDropdownExpanded)
                    },
                    modifier = Modifier
                        .fillMaxWidth()
                        .menuAnchor(),
                    colors = OutlinedTextFieldDefaults.colors(
                        focusedBorderColor = Color(0xFF9D4EDD),
                        unfocusedBorderColor = Color.LightGray,
                        focusedContainerColor = Color(0xFF2C2C4E),
                        unfocusedContainerColor = Color(0xFF2C2C4E),
                        focusedTextColor = Color.White,
                        unfocusedTextColor = Color.White,
                        disabledTrailingIconColor = Color.LightGray,
                        focusedTrailingIconColor = Color.LightGray,
                        unfocusedTrailingIconColor = Color.LightGray
                    )
                )
                ExposedDropdownMenu(
                    expanded = statusDropdownExpanded,
                    onDismissRequest = { statusDropdownExpanded = false },
                    modifier = Modifier.background(Color(0xFF2C2C4E))
                ) {
                    statusOptions.forEach { option ->
                        DropdownMenuItem(
                            text = { Text(option, color = Color.White) },
                            onClick = {
                                selectedStatus = option
                                statusDropdownExpanded = false
                            }
                        )
                    }
                }
            }
            Spacer(modifier = Modifier.height(16.dp))
            FormTextField(
                label = "ALAMAT",
                value = alamat,
                onValueChange = { alamat = it },
                placeholder = "Isikan alamat"
            )
            // --- Akhir Form Input ---

            Spacer(modifier = Modifier.weight(1f))

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 32.dp),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Button(
                    onClick = { onNavigateBack() },
                    modifier = Modifier.weight(1f),
                    shape = RoundedCornerShape(12.dp),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color(0xFF2C2C4E)
                    )
                ) {
                    Text(text = "Kembali", color = Color.LightGray, fontSize = 16.sp)
                }

