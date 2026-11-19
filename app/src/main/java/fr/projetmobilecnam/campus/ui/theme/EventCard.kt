package fr.projetmobilecnam.campus.ui.theme

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import fr.projetmobilecnam.campus.model.Event
import fr.projetmobilecnam.campus.model.sampleEvents


/*contient le composable qui dessine un seul evenement sous forme de carte,
la liste affichera une EventCard par evenement.*/
@Composable
fun EventCard(
    event: Event,
    onClick: () -> Unit, //si on clique sur la carte le parent qui va decider
    onBook: () -> Unit,
    modifier: Modifier = Modifier //taille et marge decidé par lappelant
) {

    Card(onClick = onClick, modifier = modifier.fillMaxWidth()) {

        Column(modifier = Modifier.padding(16.dp)) {

            Text(event.title)

            Text(event.category)

            Text(event.location ?: "Lieu à confirmer")

            Text(if (event.capacity == 0) "Complet" else "${event.capacity} places")

            Button(onClick = onBook, enabled = event.capacity > 0) {
                Text("Réserver")
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun EventCardFullPreview() {
    CampusTheme {
        EventCard(sampleEvents.first { it.capacity == 0 }, onClick = {}, onBook = {})
    }
}

/*leventCard ne decide pas de ce qui se passe au clic
* il le signale à son parent via onClick et onBook
* et c'est EventListScreen qui va ecrire les Log.d */
