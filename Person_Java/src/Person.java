package _a11709076.Statev;

import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

public class Person implements Comparable<Person>, MoneyMaker{
	private static final int MIN_AGE = 10;
	private static final int MAX_AGE = 100;
	
	private static final int MIN_WEIGHT = 20;
	private static final int MAX_WEIGHT = 200;
	
	private static final int MIN_HEIGHT = 100;
	private static final int MAX_HEIGHT = 250;

	private String firstname;
	private String lastname;
	private int age; //default: 20
	private int heightCm; // default:180
	private double weightKg; //default: 70
	private Map<Skill, Integer> skillLevel = new LinkedHashMap<Skill, Integer>();
	

	
	public Person(String firstname, String lastname, int age, int heightCm, double weightKg, Set<Skill> skills) {
		setFirstname(firstname);
		setLastname(lastname);
		setAge(age);
		setHeightCm(heightCm);
		setWeightKg(weightKg);
		setSkillLevel(skills);
	}
	
	public Person(String firstname, String lastname, Set<Skill> skills) {
	 this(firstname,lastname, 20, 180, 70,skills);
	}
	
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		if(firstname == null || firstname.isEmpty() ) throw new IllegalArgumentException();
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		if(lastname == null || lastname.isEmpty()) throw new IllegalArgumentException();
		this.lastname = lastname;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		if(age < MIN_AGE || age > MAX_AGE) throw new IllegalArgumentException();
		this.age = age;
	}
	public int getHeightCm() {
		return heightCm;
	}
	public void setHeightCm(int heightCm) {
		if(heightCm < MIN_HEIGHT || heightCm > MAX_HEIGHT) throw new IllegalArgumentException();
		this.heightCm = heightCm;
	}
	public double getWeightKg() {
		return weightKg;
	}
	public void setWeightKg(double weightKg) {
		if(weightKg < MIN_WEIGHT || weightKg > MAX_WEIGHT) throw new IllegalArgumentException();
		this.weightKg = weightKg;
	}
	
	public Map<Skill, Integer> getSkillLevel () { 
		return skillLevel;
	}
	
	public void setSkillLevel(Set<Skill> skills) {
		if(skills == null) throw new IllegalArgumentException();
		for (Skill value : skills)
			skillLevel.put(value,0);
	}
	
	public boolean olderThan (Person other) {return getAge() > other.getAge();}
	
	public boolean greaterThan (Person other) {return getHeightCm() > other.getHeightCm();}
	
	public boolean heavierThan (Person other) {return getWeightKg() > other.getWeightKg();}
	
	public boolean learn(Person other, Skill skill) { 
		
		if(other.getSkillLevel().get(skill) == null) return false; // if other doesnt have the skill false
		if(getSkillLevel().get(skill) != null) return false; // if this knows the skill false
		for(Skill value: this.getSkillLevel().keySet()) { // loop through map of this to check if there is a skill this knows that other doesnt
			if(other.getSkillLevel().get(value) == null) { 
        getSkillLevel().put(skill, 0); //this learns skill
				other.getSkillLevel().put(value, 0); // other.learns skill from other
				return true; //if both learned return true
			}
		}
		return false; // if both dont learn return false
	 }
	
	public boolean practise(Skill skill) {
		if (getSkillLevel().get(skill) != null) {
			getSkillLevel().replace(skill, getSkillLevel().get(skill)+1);
			return true;
		}
		return false;
	}
	@Override 
	public String toString() {
		int i = 0;
		String s = getFirstname() + ", " + getLastname() + " (" + String.valueOf(getAge()) + " yrs, " + String.valueOf(getHeightCm()) + " cm, " + String.valueOf(getWeightKg()) + " kg) {" ;
		for (Skill value: getSkillLevel().keySet()) {
			s += value + " = " + getSkillLevel().get(value);
			++i;
			if(i != getSkillLevel().size()) 
				s += ", ";
		}
		s += "}-";
		s += makeMoney();
		s += " EUR ]";
		return s;
	}

	@Override
	public int compareTo(Person person) {
		return this.getAge() < person.getAge() ? -1 : this.getAge() == person.getAge()? 0 : 1;
	}

	public static Comparator<Person> compareByWeight() {
		return (Person p1, Person p2) -> {return p1.getWeightKg() < p2.getWeightKg() ? -1 : p1.getWeightKg() == p2.getWeightKg()? 0 : 1;};
		
	}
	
	public static Comparator<Person> compareByHeight(){
		return (Person p1, Person p2) -> {return p1.getHeightCm() < p2.getHeightCm() ? -1 : p1.getHeightCm() == p2.getHeightCm()? 0 : 1;};

	}
	
	private int getBonus() {
		int all = 0;
		for(Skill s : getSkillLevel().keySet())
			all += s.getBonus(getSkillLevel().get(s));
		return all;
	}
	
	public static Comparator<Person> compareByBonus(){
		return (Person p1, Person p2) -> {return p1.getBonus() < p2.getBonus() ? -1 : p1.getBonus() == p2.getBonus()? 0 : 1;};
	}
	
	@Override
	public int makeMoney() {
		return 1200 + (getBonus() * 3);
	}
}
