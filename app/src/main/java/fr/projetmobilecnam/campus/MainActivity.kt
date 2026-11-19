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
import fr.projetmobilecnam.campus.model.sampleEvents
import fr.projetmobilecnam.campus.ui.theme.CampusTheme
import fr.projetmobilecnam.campus.ui.theme.EventCard
import fr.projetmobilecnam.campus.ui.theme.EventListScreen


private const val TAG = "Campus"

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            CampusTheme {
                //tout ce qui a en-dessous va passer dans EventListScreen
                EventListScreen(events=sampleEvents)
            }
        }
    }
}

//exo en classe seance precedente
/*@Composable
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
}*/
