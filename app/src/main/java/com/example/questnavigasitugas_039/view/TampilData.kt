// Nama File: TampilData.kt
package com.example.questnavigasitugas_039.view

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
// PERUBAHAN: Import FormData dari package utama
import com.example.questnavigasitugas_039.FormData

// --- HAPUS 'data class FormData' DARI SINI ---
// --- HAPUS 'val dataList' DARI SINI ---

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TampilDataScreen(
    listPeserta: List<FormData>, // PERUBAHAN: Menerima data dari luar
    onNavigateToDashboard: () -> Unit,
    onNavigateToForm: () -> Unit
) {
    Scaffold(
        containerColor = Color(0xFF1A1A2E),
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        "List Daftar Peserta",
                        fontWeight = FontWeight.Bold,
                        color = Color(0xFF9D4EDD)
                    )
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = Color.Transparent
                )
            )
        },
        bottomBar = {
            BottomNavigation(
                onNavigateToDashboard = onNavigateToDashboard,
                onNavigateToForm = onNavigateToForm
            )
        }
    ) { paddingValues ->
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .padding(horizontal = 16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            // PERUBAHAN: Gunakan 'listPeserta' yang diterima
            items(listPeserta) { data ->
                ParticipantCard(data = data)
            }
        }
    }
}

// Sisa kode (ParticipantCard, InfoItem, BottomNavigation) tidak berubah
@Composable
fun ParticipantCard(data: FormData) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(
            containerColor = Color(0xFF2C2C4E)
        ),
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
    ) {
        Column(
            modifier = Modifier.padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                InfoItem(label = "NAMA LENGKKAP", value = data.nama)
                InfoItem(label = "JENIS KELAMIN", value = data.gender)
            }
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                InfoItem(label = "STATUS PERKAWINAN", value = data.status)
                InfoItem(label = "ALAMAT", value = data.alamat)
            }
        }
    }
}

@Composable
fun InfoItem(label: String, value: String) {
    Column {
        Text(
            text = label,
            fontSize = 12.sp,
            color = Color(0xFF9D4EDD),
            fontWeight = FontWeight.Bold
        )
        Text(
            text = value,
            fontSize = 16.sp,
            color = Color.White,
            fontWeight = FontWeight.Medium
        )
    }
}

@Composable
fun BottomNavigation(
    onNavigateToDashboard: () -> Unit,
    onNavigateToForm: () -> Unit
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .navigationBarsPadding()
            .padding(horizontal = 16.dp, vertical = 12.dp),
        horizontalArrangement = Arrangement.SpaceEvenly
    ) {
        Button(
            onClick = { onNavigateToDashboard() },
            modifier = Modifier.weight(1f),
            shape = RoundedCornerShape(12.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = Color(0xFF2C2C4E)
            )
        ) {
            Text(text = "Beranda", color = Color.LightGray)
        }
        Spacer(modifier = Modifier.width(16.dp))
        Button(
            onClick = { onNavigateToForm() },
            modifier = Modifier.weight(1f),
            shape = RoundedCornerShape(12.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = Color(0xFF2C2C4E)
            )
        ) {
            Text(text = "Formulir", color = Color.LightGray)
        }
    }
}