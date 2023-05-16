package com.example.cookbookapp

class Dish(private val name: String, private val recipe: String) {
    fun getRecipe(): String {
        return recipe
    }

    fun getName(): String {
        return name
    }

    override fun toString(): String {
        return name
    }

    companion object {
        val pastaDishes = arrayOf(
            Dish(
                "Spaghetti bolognese",
                "Ingredients:\n"+
                        "- 300g spaghetti\n"+
                        "- 500g ground beef\n"+
                        "- 1 onion, chopped\n"+
                        "- 2 garlic cloves, minced\n"+
                        "- 1 carrot, peeled and finely chopped\n"+
                        "- 1 celery stalk, finely chopped\n"+
                        "- 1 can (400g) chopped tomatoes\n"+
                        "- 1 tbsp tomato paste\n"+
                        "- 1 tsp dried oregano\n"+
                        "- Salt and pepper\n"+
                        "- Parmesan cheese, grated\n"+

                        "Instructions:\n"+
                        "1. Cook spaghetti in a large pot of boiling salted water until al dente.\n"+
                        "2. While spaghetti is cooking, heat a large skillet over medium-high heat. " +
                        "Add the ground beef and cook until browned, breaking it up into small pieces with a wooden spoon.\n"+
                        "3. Add the onion, garlic, carrot, and celery to the skillet. Cook until vegetables are soft, about 5 minutes.\n"+
                        "4. Stir in the chopped tomatoes, tomato paste, oregano, salt, and pepper. " +
                        "Bring to a simmer and reduce heat to low. Cover and simmer for 15 minutes.\n"+
                        "5. Drain the cooked spaghetti and serve with the bolognese sauce. Sprinkle with grated Parmesan cheese."

            ),
            Dish("Lasagna",
                "Ingredients:\n" +
                        "- 1 lb. ground beef\n" +
                        "- 1 onion, chopped\n" +
                        "- 3 cloves garlic, minced\n" +
                        "- 1 can (28 oz.) crushed tomatoes\n" +
                        "- 2 tbsp tomato paste\n" +
                        "- 1 tsp dried basil\n" +
                        "- 1 tsp dried oregano\n" +
                        "- Salt and pepper\n" +
                        "- 8 lasagna noodles\n" +
                        "- 1 cup ricotta cheese\n" +
                        "- 1/2 cup grated Parmesan cheese\n" +
                        "- 2 cups shredded mozzarella cheese\n\n" +
                        "Instructions:\n" +
                        "1. Preheat oven to 375°F.\n" +
                        "2. Cook ground beef in a skillet over medium heat until browned. Drain any excess fat.\n" +
                        "3. Add onion and garlic to skillet and cook until onion is soft.\n" +
                        "4. Stir in crushed tomatoes, tomato paste, basil, oregano, salt, and pepper. Simmer for 10 minutes.\n" +
                        "5. Cook lasagna noodles according to package instructions until al dente.\n" +
                        "6. In a small bowl, mix together ricotta cheese, Parmesan cheese, and salt and pepper.\n" +
                        "7. Spread a thin layer of the tomato sauce in a 9x13 inch baking dish. Arrange 4 lasagna noodles on top.\n" +
                        "8. Spread half of the ricotta cheese mixture over the noodles. Cover with a third of the shredded mozzarella cheese.\n" +
                        "9. Repeat with another layer of noodles, ricotta cheese mixture, and shredded mozzarella cheese.\n" +
                        "10. Top with the remaining noodles and tomato sauce. Cover with the remaining shredded mozzarella cheese.\n" +
                        "11. Cover the baking dish with aluminum foil and bake for 25 minutes.\n" +
                        "12. Remove the foil and bake for another 25 minutes or until the cheese is golden brown.\n" +
                        "13. Let the lasagna cool for 10 minutes before serving. Enjoy!"
            ),
            Dish("Chow Mein",
                "Ingredients:\n" +
                        "- 8 oz. chow mein noodles\n" +
                        "- 1 lb. boneless chicken breast, sliced\n" +
                        "- 1 onion, chopped\n" +
                        "- 1 red bell pepper, chopped\n" +
                        "- 2 cloves garlic, minced\n" +
                        "- 1 cup shredded carrots\n" +
                        "- 1 cup chopped celery\n" +
                        "- 1 tbsp vegetable oil\n" +
                        "- 2 tbsp soy sauce\n" +
                        "- 1 tbsp oyster sauce\n" +
                        "- 1 tsp sesame oil\n" +
                        "- Salt and pepper\n\n" +
                        "Instructions:\n" +
                        "1. Cook chow mein noodles according to package instructions until al dente. Drain and set aside.\n" +
                        "2. Heat a large skillet over high heat. Add vegetable oil and cook the chicken until browned. Remove from skillet and set aside.\n" +
                        "3. In the same skillet, cook onion, red bell pepper, and garlic until the vegetables are soft.\n" +
                        "4. Add shredded carrots and chopped celery to the skillet and cook for another 2 minutes.\n" +
                        "5. Add the cooked chicken and chow mein noodles to the skillet.\n" +
                        "6. In a small bowl, whisk together soy sauce, oyster sauce, sesame oil, salt, and pepper.\n" +
                        "7. Pour the sauce over the chicken and noodles in the skillet. Toss to combine.\n" +
                        "8. Cook for another 2-3 minutes or until the sauce has thickened.\n" +
                        "9. Serve immediately and enjoy!"
            ),
            Dish("Spaghetti Carbonara",
                "Ingredients:\n" +
                        "- 8 oz. spaghetti\n" +
                        "- 4 oz. pancetta, diced\n" +
                        "- 3 cloves garlic, minced\n" +
                        "- 2 eggs\n" +
                        "- 1/2 cup grated Parmesan cheese\n" +
                        "- Salt and pepper\n" +
                        "- Fresh parsley, chopped\n\n" +
                        "Instructions:\n" +
                        "1. Cook spaghetti in a large pot of boiling salted water until al dente. Reserve 1 cup of pasta water and drain the rest.\n" +
                        "2. While spaghetti is cooking, cook pancetta in a skillet over medium-high heat until crispy. Remove pancetta from skillet and set aside.\n" +
                        "3. In the same skillet, cook garlic until fragrant.\n" +
                        "4. In a small bowl, whisk together eggs, grated Parmesan cheese, salt, and pepper.\n" +
                        "5. Add spaghetti, cooked pancetta, and reserved pasta water to the skillet with the garlic. Toss to combine.\n" +
                        "6. Remove skillet from heat and quickly stir in the egg mixture. The heat from the pasta will cook the eggs and create a creamy sauce.\n" +
                        "7. Divide the spaghetti carbonara into bowls and sprinkle with chopped parsley.\n" +
                        "8. Serve immediately and enjoy!"
            )
        )
        val nonPasta = arrayOf(
            Dish( "Shakshuka",
            "Ingredients:\n"+
            "- 4 eggs\n"+
            "- 1 onion, chopped\n"+
            "- 2 garlic cloves, minced\n"+
            "- 1 red bell pepper, chopped\n"+
            "- 1 can (400g) chopped tomatoes\n"+
            "- 1 tbsp tomato paste\n"+
            "- 1 tsp cumin\n"+
            "- Salt and pepper\n"+
            "- Olive oil\n"+
            "- Fresh parsley, chopped\n"+

            "Instructions:\n"+
            "1. Heat a large skillet over medium heat. Add olive oil and sauté the onion until soft.\n" +
            "2. Add the garlic and red bell pepper to skillet and cook until the pepper is soft.\n" +
            "3. Stir in the chopped tomatoes, tomato paste, cumin, salt, and pepper. Simmer for 10 minutes.\n" +
            "4. Use a spoon to make 4 wells in the tomato mixture. Crack an egg into each well.\n" +
            "5. Cover skillet and simmer until eggs are cooked to your liking.\n" +
            "6. Sprinkle fresh parsley over dish and serve."
            ),
            Dish("Greek Salad",
            "Ingredients:\n" +
            "- 1 large cucumber, chopped\n" +
            "- 4 ripe tomatoes, chopped\n" +
            "- 1 red onion, thinly sliced\n" +
            "- 1 green bell pepper, chopped\n" +
            "- 1/2 cup kalamata olives\n" +
            "- 4 oz. feta cheese, crumbled\n" +
            "- 1/4 cup extra-virgin olive oil\n" +
            "- 2 tbsp red wine vinegar\n" +
            "- 1 tsp dried oregano\n" +
            "- Salt and pepper\n\n" +
            "Instructions:\n" +
            "1. In a large salad bowl, combine the chopped cucumber, tomatoes, red onion, green bell pepper, and kalamata olives.\n" +
            "2. In a small bowl, whisk together the extra-virgin olive oil, red wine vinegar, dried oregano, salt, and pepper.\n" +
            "3. Drizzle the dressing over the salad and toss to combine.\n" +
            "4. Sprinkle crumbled feta cheese over the top of the salad.\n" +
            "5. Serve immediately and enjoy!"
            )
        )
    }
}