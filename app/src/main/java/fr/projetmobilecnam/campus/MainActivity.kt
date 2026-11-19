package fr.projetmobilecnam.campus

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigationevent.compose.rememberNavigationEventDispatcherOwner
import fr.projetmobilecnam.campus.ui.theme.CampusTheme


private const val TAG = "Campus"

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Scaffold(modifier = Modifier.fillMaxSize()) { //avec scaffold on a innerPadding qui tient compte de la barre detat avec enableEdgeToEdge() donc pas besoin de statusBarsPadding()
                    innerPadding ->
                Column(
                    modifier = Modifier.padding(innerPadding).padding(start = 24.dp, top = 8.dp)
                ) {
                    EventHeader("Event Title", "Event Category", null)
                    MyFirstRow()
                }
            }
        }
    }
}

@Composable
fun EventHeader(title: String, category: String, location: String?, modifier: Modifier = Modifier) {
    Column(modifier = modifier) { //padding, start : espace entre le bord gauche du texte
        Text(title)
        Text(category)
        if (location != null) {
            Text(location)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun EventHeaderPreview() {
    CampusTheme {
        EventHeader("Event Title", "Event Category", null)
    }
}

@Preview(showBackground = true)
@Composable
fun MyFirstRow(modifier: Modifier = Modifier) {
    // Text ------- Button

    Row(
        modifier = modifier,
        Arrangement.spacedBy(8.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text("FIP2")
        Button(onClick = {}) {
            Text("Click me")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun MyFirstRowPreview(){
    CampusTheme { //pour utiliser les mêmes couleurs et typo de l'app
        MyFirstRow()
    }
}
