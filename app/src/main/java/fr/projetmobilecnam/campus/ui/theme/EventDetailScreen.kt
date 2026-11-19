package fr.projetmobilecnam.campus.ui.theme

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import fr.projetmobilecnam.campus.R
import fr.projetmobilecnam.campus.model.Event
import fr.projetmobilecnam.campus.model.sampleEvents

@Composable
fun EventDetailScreen(
    event: Event, //same
    onBook: () -> Unit, //le parent décide
    modifier: Modifier = Modifier
){
    Column(modifier = modifier.verticalScroll(rememberScrollState())){
        Image(
            painter = painterResource(R.drawable.event_banner),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier.fillMaxWidth().height(180.dp)
        )
        Column(modifier = Modifier.padding(16.dp)){

            Text(event.title)
            Text(event.category)
            Text(event.location ?: "Lieu à confirmer")
            Text(event.description)

            Button(onClick = onBook, enabled = event.capacity > 0){
                Text("Réserver")
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun EventDetailScreenPreview() {
    CampusTheme {
        EventDetailScreen(sampleEvents.first(), onBook = {})
    }
}