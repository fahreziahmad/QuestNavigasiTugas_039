package com.example.questnavigasitugas_039 // Pastikan package ini sesuai

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import com.example.questnavigasitugas_039.ui.theme.QuestNavigasiTugas_039Theme

// Import Navigasi.kt yang sudah kita buat
import com.example.questnavigasitugas_039.AppNavigation

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            QuestNavigasiTugas_039Theme {
                // Gunakan Surface untuk latar belakang
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    // Hapus kode template 'Greeting' dan panggil AppNavigation()
                    AppNavigation()
                }
            }
        }
    }
}

// Fungsi Greeting dan GreetingPreview bawaan template sudah tidak diperlukan lagi,
// Anda bisa menghapusnya.