package guis;

public class roomLocator {
	
String[][] room = new String[18][18];
public String roomLoc(int num) {
int x;
x = num;
//Room 1
room[0][0] = "1";
room[0][1] = "2";
//Room 2
room[1][0] = "2";
room[1][1] = "3";
//Room 3
room[2][0] = "3";
room[2][1] = "4";
//Room 4
room[3][0] = "4";
room[3][1] = "5";
//Room 5
room[4][0] = "5";
room[4][1] = "6";
//Room 6
room[4][0] = "5";
room[4][1] = "6";
//Room 7
room[4][0] = "5";
room[4][1] = "6";
//Room 8
room[4][0] = "5";
room[4][1] = "6";
//Room 9
room[4][0] = "5";
room[4][1] = "6";
//Room 10
room[4][0] = "5";
room[4][1] = "6";
//Room 11
room[4][0] = "5";
room[4][1] = "6";
//Room 12
room[4][0] = "5";
room[4][1] = "6";
//Room 13
room[4][0] = "5";
room[4][1] = "6";
//Room 14
room[4][0] = "5";
room[4][1] = "6";
//Room 15
room[4][0] = "5";
room[4][1] = "6";
//Room 16
room[4][0] = "5";
room[4][1] = "6";
//Room 17
room[4][0] = "5";
room[4][0] = "6";
//Room 18
room[4][0] = "5";
room[4][1] = "6";
switch(x) {
case 1:
return room[0][1];

case 2:
return room[1][1];

case 3:
return room[2][1];

case 4:
return room[3][1];
case 5:
return room[4][1];
case 6:
return room[5][1];
case 7:
return room[6][1];
case 8:
return room[7][1];
case 9:
return room[8][1];
case 10:
return room[9][1];
case 11:
return room[10][1];
case 12:
return room[11][1];
case 13:
return room[12][1];
case 14:
return room[13][1];
case 15:
return room[14][1];
case 16:
return room[15][1];
case 17:
return room[16][1];
case 18:
return room[17][1];
}
return room[3][1];
}

public String roomNum(int num) {
int x;
x = num;

	switch(x) {
	case 1:
	return room[0][0];

	case 2:
	return room[1][0];

	case 3:
	return room[2][0];

	case 4:
	return room[3][0];
	
	case 5:
	return room[4][0];
	
	case 6:
	return room[5][0];

	case 7:
	return room[6][0];

	case 8:
	return room[7][0];

	case 9:
	return room[8][0];
	
	case 10:
	return room[9][0];
	
	case 11:
	return room[10][0];

	case 12:
	return room[11][0];

	case 13:
	return room[12][0];

	case 14:
	return room[13][0];
	
	case 15:
	return room[14][0];
	
	case 16:
	return room[15][0];

	case 17:
	return room[16][0];

	case 18:
	return room[17][0];
	}
	return null;
	}

}


