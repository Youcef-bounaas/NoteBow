package com.youcef_bounaas.notebow.feature_note.domain.util



sealed class OrderType {
    object Ascending: OrderType()
    object Descending: OrderType()
}