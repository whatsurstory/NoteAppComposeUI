package com.beva.noteappcomposeui.feature_note.presentation.note.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.width
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.beva.noteappcomposeui.ui.theme.LightBlue

@Composable
fun DefaultRadioButton(
    text: String,
    selected: Boolean,
    onChecked: () -> Unit,
    modifier: Modifier = Modifier
) {
    Row(
        modifier,
        verticalAlignment = Alignment.CenterVertically
    ) {
        RadioButton(
            selected = selected,
            onClick = {
                onChecked()
            },
            colors = RadioButtonDefaults.colors(
                selectedColor = MaterialTheme.colors.primary,
                unselectedColor = LightBlue
            )
        )
        Spacer(modifier = modifier.width(4.dp))
        Text(text = text, style = MaterialTheme.typography.body1)
    }
}