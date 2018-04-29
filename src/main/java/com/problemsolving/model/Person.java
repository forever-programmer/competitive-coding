package com.problemsolving.model;

public class Person {

	private int birthYear;

	private int deathYear;

	public int getBirthYear() {
		return birthYear;
	}

	public void setBirthYear(int birthYear) {
		this.birthYear = birthYear;
	}

	public int getDeathYear() {
		return deathYear;
	}

	public void setDeathYear(int deathYear) {
		this.deathYear = deathYear;
	}

	@Override public String toString() {
		return "Person{" +
		       "birthYear=" + birthYear +
		       ", deathYear=" + deathYear +
		       '}';
	}
}
