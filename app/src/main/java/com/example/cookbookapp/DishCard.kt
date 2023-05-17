package com.example.cookbookapp

class DishCard(private val name: String, private val imageResourceId: Int) {
    companion object {
        val dishesPasta = arrayOf(
            DishCard("Spaghetti bolognese", R.drawable.spaghetti_bolognese),
            DishCard("Lasagna", R.drawable.lasagna),
            DishCard("Chow Mein", R.drawable.chow_mein),
            DishCard("Spaghetti Carbonara", R.drawable.spaghetti_carbonara)
        )
        val dishesNonPasta = arrayOf(
            DishCard("Shakshuka", R.drawable.shakshuka),
            DishCard("Greek Salad", R.drawable.greek_salad)
        )
    }
    fun getName(): String {
        return name
    }
    fun getImageResourceId(): Int {
        return imageResourceId
    }
}