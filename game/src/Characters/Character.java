package Characters;

import javafx.beans.property.SimpleStringProperty;

public class Character {

	private String chName;
	private String chRace;
	private String chAge;
	private String chSex;
	private String chHeight;
	private String chWeight;
	private String chMainWeapon;
	private String  chOffWeapon;
	private String  chBodyArmor;
	private String chHeadArmor;
	private String chLegArmor;
	private String  chFeetArmor;
	private String  chRing1;
	private String  chRing2;
	private String  chAmulet;
	float hitPoints = 100.00f;
	public static int level = 1;
	
	
	
	public void setChName(String chName) {
		this.chName = chName;
	}



	public void setChRace(String chRace) {
		this.chRace = chRace;
	}



	public void setChAge(String chAge) {
		this.chAge = chAge;
	}



	public void setChSex(String chSex) {
		this.chSex = chSex;
	}



	public void setChHeight(String chHeight) {
		this.chHeight = chHeight;
	}



	public void setChWeight(String chWeight) {
		this.chWeight = chWeight;
	}



	public void setChMainWeapon(String chMainWeapon) {
		this.chMainWeapon = chMainWeapon;
	}



	public void setChOffWeapon(String chOffWeapon) {
		this.chOffWeapon = chOffWeapon;
	}



	public void setChBodyArmor(String chBodyArmor) {
		this.chBodyArmor = chBodyArmor;
	}



	public void setChHeadArmor(String chHeadArmor) {
		this.chHeadArmor = chHeadArmor;
	}



	public void setChLegArmor(String chLegArmor) {
		this.chLegArmor = chLegArmor;
	}



	public void setChFeetArmor(String chFeetArmor) {
		this.chFeetArmor = chFeetArmor;
	}



	public void setChRing1(String chRing1) {
		this.chRing1 = chRing1;
	}



	public void setChRing2(String chRing2) {
		this.chRing2 = chRing2;
	}



	public void setChAmulet(String chAmulet) {
		this.chAmulet = chAmulet;
	}



	protected Character(String name, String race, String age, String sex, String height, String weight, String mainWeapon, String offWeapon, String bodyArmor,
			String headArmor, String legArmor, String feetArmor, String ring1, String ring2, String amulet) {
		this.chName = name;
		this.chRace = race;
		this.chAge = age;
		this.chSex = sex;
		this.chHeight = height;
		this.chWeight = weight;
		this.chMainWeapon = mainWeapon;
		this.chOffWeapon = offWeapon;
		this.chBodyArmor = bodyArmor;
		this.chHeadArmor = headArmor;
		this.chLegArmor = legArmor;
		this.chFeetArmor = feetArmor;
		this.chRing1 = ring1;
		this.chRing2 = ring2;
		this.chAmulet = amulet;
	}



	public float getHitPoints() {
		return hitPoints;
	}



	public void setHitPoints(float hitPoints) {
		this.hitPoints = hitPoints;
	}


	public String getChName() {
		return chName;
	}



	public String getChRace() {
		return chRace;
	}



	public String getChAge() {
		return chAge;
	}



	public String getChSex() {
		return chSex;
	}



	public String getChHeight() {
		return chHeight;
	}



	public String getChWeight() {
		return chWeight;
	}



	public String getChMainWeapon() {
		return chMainWeapon;
	}



	public String getChOffWeapon() {
		return chOffWeapon;
	}



	public String getChBodyArmor() {
		return chBodyArmor;
	}



	public String getChHeadArmor() {
		return chHeadArmor;
	}



	public String getChLegArmor() {
		return chLegArmor;
	}



	public String getChFeetArmor() {
		return chFeetArmor;
	}



	public String getChRing1() {
		return chRing1;
	}



	public String getChRing2() {
		return chRing2;
	}



	public String getChAmulet() {
		return chAmulet;
	}
	
	
}