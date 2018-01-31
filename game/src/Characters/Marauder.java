package Characters;

public class Marauder extends Character{
String name, race, age, sex, height, weight, mainWeapon, offWeapon, bodyArmor, headArmor, legArmor, feetArmor, ring1,
ring2, amulet;
	public Marauder(String name, String race, String age, String sex, String height, String weight, String mainWeapon,
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
		this.legArmor = legArmor;
		this.feetArmor = feetArmor;
		this.ring1 = ring1;
		this.ring2 = ring2;
		this.amulet = amulet;
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		
		return "Marauder \nName: " + name + "\nRace: " + race + "\nAge: " + age + "\nSex: " + sex + "\nHeight: " + height
				+ "\nWeight: " + weight + "\nMain Weapon: " + mainWeapon + "\nOff-Hand: " + offWeapon + "\nBody Armor: "
				+ bodyArmor + "\nHead Armor: " + headArmor + "\nLeg Armor: " + legArmor + "\nFeet Armor: " + feetArmor
				+ "\nLeft-Hand Ring: " + ring1 + "\nRight-Hand Ring: " + ring2 + "\nAmulet: " + amulet;
	}




	}



