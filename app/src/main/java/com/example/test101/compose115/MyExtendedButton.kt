package com.example.test101.compose115

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.unit.dp

@Composable
fun MyExtendedButton(onClick: () -> Unit,
                     modifier: Modifier = Modifier,
                     enabled: Boolean = true,
                     interactionSource: MutableInteractionSource = remember { MutableInteractionSource() },
                     elevation: ButtonElevation? = ButtonDefaults.elevation(),
                     shape: Shape = MaterialTheme.shapes.small,
                     border: BorderStroke? = null,
                     colors: ButtonColors? = null,
                     contentPadding: PaddingValues = ButtonDefaults.ContentPadding,
                     content: @Composable RowScope.() -> Unit) {


    Button(
        onClick = onClick,
        modifier = modifier.padding(4.dp),
        enabled = enabled,
        interactionSource = interactionSource,
        elevation = elevation,
        shape = shape,
        border = border,
        colors = ButtonDefaults.buttonColors(
            backgroundColor = Color.Cyan,
            contentColor = Color.Blue,
            disabledBackgroundColor = Color.Cyan.copy(alpha = 0.5f),
            disabledContentColor = Color.Blue.copy(alpha = ContentAlpha.disabled)
            /* Other colors use values from MaterialTheme */
        ),
        contentPadding = contentPadding,
        content = content
    )

}