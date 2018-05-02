package com.algorithms.lists;

import java.util.LinkedList;
import java.util.List;

public class AnimalShelter {
	static abstract class Animal {
		int srNo;

		@Override public String toString() {
			return this.getClass().getSimpleName() + " {" +
			       "srNo=" + srNo +
			       '}';
		}
	}

	static class Dog extends Animal {
		Dog(int srNo) {
			this.srNo = srNo;
		}
	}

	static class Cat extends Animal {
		Cat(int srNo) {
			this.srNo = srNo;
		}
	}


	public static void main(String[] args) {
		List<Animal> animals = new LinkedList<>();
		enqueue(animals, new Dog(1));
		enqueue(animals, new Dog(2));

		Animal animal = dequeue(animals);
		Cat cat = (Cat) dequeue(animals, Cat.class);

		enqueue(animals, new Cat(1));

		Dog dog = (Dog) dequeue(animals, Dog.class);
		dog = (Dog) dequeue(animals, Dog.class);

		enqueue(animals, new Cat(2));
		enqueue(animals, new Cat(3));
		enqueue(animals, new Dog(3));

		new LinkedList<Animal>().removeFirst();

		System.out.println(animals);
	}

	private static <T extends Animal> Animal dequeue(List<Animal> animals, Class<T> animalType) {


		Animal oldestAnimalOfType = null;

		for(Animal animal : animals) {
			if(animal.getClass().equals(animalType)) {
				oldestAnimalOfType = animal;
			}
		}

		animals.remove(oldestAnimalOfType);

		System.out.println("Wanted a " + animalType.getSimpleName() + ", Returning:" + oldestAnimalOfType);
		System.out.println("Current shelter:" + animals);
		return oldestAnimalOfType;
	}

	private static Animal dequeue(List<Animal> animals) {
		final Animal animal = animals.get(animals.size() - 1);
		if(animal != null) {
			animals.remove(animal);
		}
		System.out.println("Returning:" + animal);
		System.out.println("Current shelter:" + animals);
		return animal;
	}

	private static void enqueue(List<Animal> animals, Animal animal) {
		animals.add(0, animal);
		System.out.println("Added a " + animal);
		System.out.println("Current shelter:" + animals);
	}
}
