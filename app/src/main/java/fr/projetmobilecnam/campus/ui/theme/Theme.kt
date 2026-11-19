package fr.projetmobilecnam.campus.ui.theme

import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

private val LightColorScheme = lightColorScheme(
    primary = CampusBlue,
    secondary = CampusBlueDark,
    background = CampusBackground,
    surface = CampusWhite,
    onPrimary = Color.White,
    onSecondary = Color.White,
    onBackground = CampusBlack,
    onSurface = CampusBlack
)

private val DarkColorScheme = darkColorScheme(
    primary = CampusBlue,
    secondary = CampusBlueDark,
    background = Color(0xFF191B23),
    surface = Color(0xFF292B35),
    onPrimary = Color.White,
    onSecondary = Color.White,
    onBackground = Color.White,
    onSurface = Color.White
)

@Composable
fun CampusTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    dynamicColor: Boolean = false,
    content: @Composable () -> Unit
) {

    val colorScheme = when {
        darkTheme -> DarkColorScheme
        else -> LightColorScheme
    }

    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography,
        content = content
    )
}