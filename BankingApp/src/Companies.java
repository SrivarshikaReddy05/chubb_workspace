
import java.util.*;

public class Companies {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Map<String, List<String>> cmp = new HashMap<>();
		cmp.put("Chubb", Arrays.asList("Ram", "Rohit", "Sita"));
		cmp.put("Google", Arrays.asList("James", "Roy", "Rohan"));
		cmp.put("Amazon", Arrays.asList("Sakshi", "Virat", "Mahi"));
		cmp.put("Microsoft", Arrays.asList("Lucky", "Arjun", "Anand"));
		cmp.put("Oracle", Arrays.asList("Vishnu", "Rohit", "Sita"));
		for (String c : cmp.keySet()) {
	        System.out.print(c + " ");
	    }
		if(cmp.containsKey("Cognizant")) {
			System.out.println("Found");
		}
		else {
			cmp.put("Cognizant", Arrays.asList("Ram", "Jessy", "Surya"));
		}
		List<String> emp = cmp.get("Cognizant");
		if(emp.contains("Ram")) {
			System.out.println("\nFound");
		}else {
			System.out.println("Not Found");
		}
	}
	

}
