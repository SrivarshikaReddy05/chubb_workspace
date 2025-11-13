
public class SimpleInterest {

	public void calcSI(int p,int t,int r) {
		int res = p*t*r;
		double ans = res/100;
		System.out.println("Simple Interest is "+ans);
		double emi = calculateEMI(p+ans,r,t*12);
		System.out.println("EMI : "+emi);
	}
	
	public void calcCI(int p, int t, int r) {
		double amt = p * Math.pow((1 + (r / 100.0)), t);
	    double ci = amt - p;
	    System.out.println("Compound Interest = " + ci);
	}
	
	public static double calculateEMI(double amt, double annualRate, int months) {
	    return (amt/months);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	}

}
