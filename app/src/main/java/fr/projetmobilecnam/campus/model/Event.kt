package fr.projetmobilecnam.campus.model

data class Event(
    val id: Int,
    val title: String,
    val category: String,
    val location: String?,
    val capacity: Int
)

val sampleEvents = listOf(
    Event(1, "Conférence Kotlin", "TECH", "Salle 204", 40),
    Event(2, "Atelier Compose", "TECH", "Amphi B", 1),
    Event(3, "Tournoi de football", "SPORT", "Gymnase Nord", 22),
    Event(4, "Soirée jeux de société", "SOCIAL", null, 15),
    Event(5, "Forum des entreprises", "CARRIÈRE", "Hall principal", 0)
)