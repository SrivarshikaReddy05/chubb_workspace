
import java.util.*;

public class Hyd {
	private Map<String, Integer> hotels;
	Scanner sc = new Scanner(System.in);
	String hotel;
	public Hyd() {
		// TODO Auto-generated constructor stub
		hotels = new HashMap<>();
		hotels.put("ABC", 30);
		hotels.put("DEF", 50);
		hotels.put("XYZ", 100);
		
		System.out.println("Hotels in Mumbai : ");
		for (String key : hotels.keySet()) {
            System.out.println(key);
        }
		
		
	}
	public void chooseHotel() {
		System.out.println("Choose the hotel in the above list 1-ABC 2-DEF 3-XYZ");
		int choice = sc.nextInt();
		switch(choice) {
		case 1:
			System.out.println("You choose Hotel ABC");
			hotel = "ABC";
			break;
		case 2:
			System.out.println("You choose Hotel DEF");
			hotel = "DEF";
			break;
		case 3:
			System.out.println("You choose Hotel XYZ");
			hotel = "XYZ";
			break;
		}
	}
	
	public int payment(int nrooms) {
		return nrooms*5000;
	}
	public int chooseRoom() {
		System.out.println("Total no.of rooms are " + hotels.get(hotel));
		int tot = hotels.get(hotel);
		int[] arr = new int[tot];//rooms 0 - not booked 1 - booked
		for(int i = 1;i<=tot;i++) {
			if( i%2 == 0) {
				arr[i-1] = 1;
			}
			else {
				arr[i-1] = 0;
			}
		}
		System.out.print("Enter a room number");
		int n = sc.nextInt();
		int nrooms = 0;
		int cost = 0;
		boolean payment = true;
		while(payment) {
			if(n>tot) {
				System.out.println("Enter valid room");
			}
			else {
				if(arr[n-1] == 0) {
					nrooms+=1;
					arr[n-1] = 1;
					System.out.println("You have booked the room and do you want another room");
					String req = sc.next();
					if(req.equalsIgnoreCase("yes")) {
						System.out.print("Enter the room number");
						n = sc.nextInt();
						
					}
					else {
						cost = payment(nrooms);
						payment=false;
					}
				}
				else {
					System.out.println("This room is already booked...Enter another number...");
					n = sc.nextInt();
				}
			}
		}
		return cost;
	}
	
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
