package fr.projetmobilecnam.campus.ui.theme

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.pluralStringResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import fr.projetmobilecnam.campus.R
import fr.projetmobilecnam.campus.model.Event
import fr.projetmobilecnam.campus.model.sampleEvents
import fr.projetmobilecnam.campus.ui.theme.CampusTheme


/*contient le composable qui dessine un seul evenement sous forme de carte,
la liste affichera une EventCard par evenement.*/
@Composable
fun EventCard(
    event: Event,
    onClick: () -> Unit, //si on clique sur la carte le parent qui va decider
    onBook: () -> Unit,
    modifier: Modifier = Modifier //taille et marge decidé par lappelant
) {
    val isFull = event.capacity == 0

    Card(onClick = onClick, modifier = modifier.fillMaxWidth()) {
        Column(
            modifier = Modifier.padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(4.dp)
        ) {
            Text( //le titre
                text = event.title,
                style = MaterialTheme.typography.titleMedium,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )
            Text( //la categorie
                text = event.category,
                style = MaterialTheme.typography.labelMedium,
                color = MaterialTheme.colorScheme.primary
            )
            //le lieu
            Text(event.location ?: stringResource(R.string.location_tbd))

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text( //nb de place avec complet si la capactie dispo est 0
                    text = if (isFull) stringResource(R.string.event_full)
                    else pluralStringResource(R.plurals.available_seats, event.capacity, event.capacity),
                    modifier = Modifier.weight(1f)
                )
                Button(onClick = onBook, enabled = !isFull) {
                    Text(stringResource(R.string.book))
                }
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

@Preview(showBackground = true)
@Composable
private fun EventCardNoLocationPreview() {
    CampusTheme {
        EventCard(sampleEvents.first { it.location == null }, onClick = {}, onBook = {})
    }
}

/*leventCard ne decide pas de ce qui se passe au clic
* il le signale à son parent via onClick et onBook
* et c'est EventListScreen qui va ecrire les Log.d */
