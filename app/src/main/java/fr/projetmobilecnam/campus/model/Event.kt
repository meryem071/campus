package fr.projetmobilecnam.campus.model

data class Event(
    val id: Int,
    val title: String,
    val category: String,
    val location: String?,
    val capacity: Int,
    val description:String
)

val sampleEvents = listOf(
    Event(1, "Dev mobile", "UE", "31.1.71", 28, "Cours de developpemnt mobile sur android studio avec jetpack compose"),
    Event(2, "Anglais", "UE", "20.-1.22", 15, "Bientôt l'Angleterre! Important"),
    Event(3, "Tournoi de football", "SPORT", "Gymnase Nord", 22, "Venez voir la rencontre entre les 2 champions"),
    Event(4, "Soirée jeux de société", "SOCIAL", null, 15, "Teambuilding"),
    Event(5, "Forum des entreprises", "CARRIÈRE", "Hall principal", 0, "En recherche d'emploi?"),
    Event(6, "Tournoi de football", "SPORT", "Gymnase Sud", 32,"Tournoi pour les grands et petits, équipes de 7"),
)