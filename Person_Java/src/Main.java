package _a11709076.Statev;


import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

public class Main {

	public static void main(String[] args) {
	
		Set<Skill> s1 = new LinkedHashSet<Skill>();
		s1.add(Skill.MATH);
		s1.add(Skill.FRENCH);
		Person lucia = new Person("Lucia","Sommer",20,170,65,s1);
		Set<Skill> s2 = new LinkedHashSet<Skill>();
		s2.add(Skill.MATH);
		s2.add(Skill.HISTORY);
		Person philipp = new Person("Philipp", "Brett", 33, 195, 75, s2);
		Set<Skill> s3 = new LinkedHashSet<Skill>();
		s3.add(Skill.ENGLISH);
		s3.add(Skill.MATH);
		Set<Skill> s4 = new LinkedHashSet<Skill>();
		s4.add(Skill.FRENCH);
		Person susanne = new Expert("Susanne", "Wasser", 45, 187, 90, s3, s4);
		
		try {
			System.out.println(lucia.practise(Skill.MATH));
			System.out.println(philipp.practise(Skill.SPORTS));
			System.out.println(lucia.learn(philipp,Skill.MATH));
			System.out.println(susanne.practise(Skill.FRENCH));
			System.out.println(susanne.learn(lucia,Skill.FRENCH));
			System.out.println(susanne.practise(Skill.FRENCH));
			System.out.println(philipp.learn(lucia,Skill.ENGLISH));

			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		TreeSet<Person> ts = new TreeSet<Person>();
		ts.add(lucia);
		ts.add(philipp);
		ts.add(susanne);	
		System.out.println(ts);
		
		System.out.println("Aufgabe 3");
		
		MoneyMaker[] al = null;
		System.out.println(PersonUtils.allAbove(al, 1250));
		MoneyMaker[] al2 = {susanne,philipp,lucia};
		System.out.println(PersonUtils.allAbove(al2,1250));
		System.out.println(PersonUtils.allAbove(al2, null));
 
}
}
