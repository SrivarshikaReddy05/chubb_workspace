
import java.util.*;
public class Booking {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter your name : ");
		String name = sc.next();
		System.out.print("Enter your destination : ");
		String dst = sc.next();
		int cost = 0;
		switch(dst) {
		case "Mumbai" :
			Mumbai obj1 = new Mumbai();
			obj1.chooseHotel();
			cost = obj1.chooseRoom();
			break;
		case "Banglore" :
			Banglore obj2 = new Banglore();
			obj2.chooseHotel();
			cost = obj2.chooseRoom();
			break;
		case "Hyd" :
			Hyd obj3 = new Hyd();
			obj3.chooseHotel();
			cost = obj3.chooseRoom();
			break;
		}
		
		System.out.println("The Payment details : ");
		System.out.println("Name : "+ name);
		System.out.println("Destination : "+ dst);
		System.out.println("Cost : "+ cost);
		
		
	}

}
