
import java.util.*;

public class Car {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter model : ");
		String model = sc.next();
		int cost = 0;
		switch(model) {
		case "alpha":
			cost = 1200000;
			break;
		case "beta" :
			cost = 1000000;
			break;
		case "delta" :
			cost = 800000;
			break;
		}
		System.out.print("Enter paid : ");
		int paid = sc.nextInt();
		int loanAmount = cost - paid;
		System.out.print("Enter time : ");
		int time = sc.nextInt();
		System.out.print("Enter rate : ");
		int rate = sc.nextInt();
		SimpleInterest si = new SimpleInterest();
		si.calcSI(loanAmount,time ,rate);
		si.calcCI(loanAmount, time , rate);
	}

}
