package _a11709076.Statev;

public enum Skill {
	MATH(30), GEOGRAPHY(10), HISTORY(), ENGLISH(), FRENCH, LITERATURE, SPORTS(10), PROGRAMMING(40) {
		@Override 
		public int getBonus(int level) {return getBase() + level * 100;}
	}, JAPANESE(40);
	
	private final int base;
	
	Skill (int base) {
		if(base < 0) throw new IllegalArgumentException();
		this.base = base;
	}
	
	Skill(){
		this(20);
	}
	int getBase() {return base;}
	public int getBonus(int level) {return getBase() * level;}
}