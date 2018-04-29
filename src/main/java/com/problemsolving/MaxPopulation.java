package com.problemsolving;

import java.util.ArrayList;
import java.util.List;

import com.problemsolving.model.Person;

public class MaxPopulation {

	private static final int SIZE = 10000;

	public static void main(String[] args) {

		List<Person> people = getPeople();
		int maxDeathYear = getMaxDeathYear(people);
		int[] populationByYear = new int[maxDeathYear];

		for(Person person : people) {
			for(int i = person.getBirthYear(); i < person.getDeathYear(); i++) {
				populationByYear[i]++;
			}
		}

		int maxPopulationYear = 0;

		for(int i = 0; i < populationByYear.length; i++) {
			if(populationByYear[i] > populationByYear[maxPopulationYear]) {
				maxPopulationYear = i;
			}
		}

		System.out.println("MaxPopulation was in Year:" + maxPopulationYear + ", Population:" + populationByYear[maxPopulationYear]);
	}

	private static int getMaxDeathYear(List<Person> people) {
		int maxDeathYear = 0;
		for(Person person : people) {
			if(person.getDeathYear() > maxDeathYear) {
				maxDeathYear = person.getDeathYear();
			}
		}
		return maxDeathYear;
	}

	private static List<Person> getPeople() {
		List<Person> people = new ArrayList<>();

		for(int i = 0; i < SIZE; i++) {
			Person p = new Person();

			final double random = Math.random();
			int randomBirthDelta = (int) (random * 10);
			int randomDeathDelta = (int) (random * 100);


			final int birthYear = getRandomYear(randomBirthDelta);
			final int deathYear = getRandomYear(randomDeathDelta);

			p.setBirthYear(birthYear);
			p.setDeathYear(deathYear);
			people.add(p);
		}
		return people;
	}

	private static int getRandomYear(int random) {
		return 1900 + random;
	}

}
