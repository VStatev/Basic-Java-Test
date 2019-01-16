package _a11709076.Statev;

import java.util.LinkedHashSet;
import java.util.Set;

public class Expert extends Person {
	
	private Set<Skill> specialisedSkills = new LinkedHashSet<Skill>();
	
	public Expert (String firstname, String lastname, int age, int heightCm, double weightKg, Set<Skill> skills, Set<Skill> specialisedSkils) {
		super(firstname,lastname,age,heightCm,weightKg,skills);
		setSpecialisedSkills(specialisedSkils);
	}

	public Set<Skill> getSpecialisedSkills() {
		return specialisedSkills;
	}

	public void setSpecialisedSkills(Set<Skill> specialisedSkills) {
		if(specialisedSkills == null) throw new IllegalArgumentException();
		for (Skill value : specialisedSkills)
			this.specialisedSkills.add(value);
	}
	
	@Override
	public boolean practise (Skill skill) {
		if (getSkillLevel().get(skill) != null) {
			if(getSpecialisedSkills().contains(skill))
				getSkillLevel().replace(skill, getSkillLevel().get(skill)+3);
			else 
				getSkillLevel().replace(skill, getSkillLevel().get(skill)+1);
			return true;
		}
		return false;
	}
	
	@Override
	public String toString() {
		String s = super.toString();
		int i = 0;
		s += " Specialised Skills: {";
		for(Skill value : getSpecialisedSkills()) {
			s += value;
			++i;
			if(i != getSpecialisedSkills().size())
				s += ", ";
		}
		s += '}';
		return s;
		
	}
	@Override 
	public int makeMoney() {
		return super.makeMoney() + 200;
	}
}
