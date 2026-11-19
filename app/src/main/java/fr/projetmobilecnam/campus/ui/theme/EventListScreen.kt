package fr.projetmobilecnam.campus.ui.theme

import android.util.Log
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FilterChip
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import fr.projetmobilecnam.campus.model.Event
import fr.projetmobilecnam.campus.model.sampleEvents

private const val TAG = "Campus" //pour filtrer logcat avec tag:Campus

@OptIn(ExperimentalMaterial3Api::class) //pour TopAppBar souligne en rouge
@Composable
fun EventListScreen(events: List<Event>, modifier: Modifier = Modifier) {
    Scaffold(
        modifier = modifier,
        topBar = { TopAppBar(title = { Text("Campus") }) }
    ) { innerPadding ->
        LazyColumn(contentPadding = innerPadding) {
            item{
                LazyRow(contentPadding = PaddingValues(horizontal = 16.dp), horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                    items(events.map { it.category }.distinct()) { category ->
                        FilterChip(
                            selected = false,
                            onClick = { },
                            label = { Text(category) }
                        )
                    }
                }
            }
            items(events, key = { it.id }) { event ->
                EventCard(
                    event = event,
                    onClick = { Log.d(TAG, "Ouvrir ${event.id}") },
                    onBook = { Log.d(TAG, "Réserver ${event.id}") }
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun EventListScreenPreview() {
    CampusTheme {
        EventListScreen(sampleEvents)
    }
}