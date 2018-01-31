package Characters;

public class Druid extends Character{
	String name, race, age, sex, height, weight, mainWeapon, offWeapon, bodyArmor, headArmor, legArmor, feetArmor, ring1,
	ring2, amulet,druSkill, level;
	public Druid(String name, String race, String age, String sex, String height, String weight, String mainWeapon,
			String offWeapon, String bodyArmor, String headArmor, String legArmor, String feetArmor, String ring1,
			String ring2, String amulet) {
		super(name, race, age, sex, height, weight, mainWeapon, offWeapon, bodyArmor, headArmor, legArmor, feetArmor, ring1,
				ring2, amulet);
		this.name = name;
		this.race = race;
		this.age = age;
		this.sex = sex;
		this.height = height;
		this.weight = weight;
		this.mainWeapon = mainWeapon;
		this.offWeapon = offWeapon;
		this.bodyArmor = bodyArmor;
		this.headArmor = headArmor;
		this.feetArmor = feetArmor;
		this.ring1 = ring1;
		this.ring2 = ring2;
	    this.amulet = amulet;	
	    this.druSkill= druSkill;
	}
	@Override
	public String toString() {
		return " level :"+ level +"\nDruid name: " + name + "\n race: " + race + "\nage: " + age + "\nsex: " + sex + "\nheight: " + height
				+ "\nweight: " + weight + "\nmainWeapon: " + mainWeapon + "\noffWeapon: " + offWeapon + "\nbodyArmor: "
				+ bodyArmor + "\nheadArmor: " + headArmor + "\nlegArmor: " + legArmor + "\nfeetArmor: " + feetArmor
				+ "\nring1: " + ring1 + "\nring2: " + ring2 + "\namulet: " + amulet;
	}




	}
