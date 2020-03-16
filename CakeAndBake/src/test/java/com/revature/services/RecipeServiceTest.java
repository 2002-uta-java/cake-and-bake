package com.revature.services;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.revature.cake_and_bake.models.Recipe;
import com.revature.cake_and_bake.services.RecipeService;

public class RecipeServiceTest {
	public static void main(String[] args) {
		final ApplicationContext ac = new ClassPathXmlApplicationContext("beans.xml");
		final RecipeService service = ac.getBean(RecipeService.class);

		for (final Recipe recipe : service.getAllRecipes())
			System.out.println(recipe);

		
		((ConfigurableApplicationContext) ac).close();
	}
}
