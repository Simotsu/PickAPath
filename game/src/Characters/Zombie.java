package Characters;

public class Zombie extends Enemy{
int level;
float hitPoints;
String name;
String appearence;
String mainAttack;
String subAttack;
String monHeight;
String monWeight;
String ZomAttack;
static String exp;	
	
	protected Zombie(int level, 
			float hitPoints, 
			String name,
			String appearence, 
			String mainAttack, 
			String subAttack,
			String monHeight, 
			String monWeight,
			String ZomAttack) {
		super(level, hitPoints,name, appearence, mainAttack, subAttack, monHeight, monWeight, exp);
		 
	}


}
