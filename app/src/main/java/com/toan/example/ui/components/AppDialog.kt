package com.toan.example.ui.components

import androidx.compose.material3.AlertDialog
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable

@Composable
fun AppDialog(
    onDismiss: () -> Unit,
    onConfirm: () -> Unit
) {
    AlertDialog(
        onDismissRequest = onDismiss,
        title = { AppText("Xác nhận xóa") },
        text = { AppText("Bạn có chắc chắn muốn xóa không?") },
        confirmButton = {
            TextButton(onClick = onConfirm) {
                AppText("Xóa")
            }
        },
        dismissButton = {
            TextButton(onClick = onDismiss) {
                AppText("Hủy")
            }
        }
    )
}