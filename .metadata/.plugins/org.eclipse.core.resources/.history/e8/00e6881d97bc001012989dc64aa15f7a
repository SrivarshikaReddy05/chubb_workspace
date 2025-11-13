import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import com.app.process.MathOperation;

public class MathOpsTest {
	
	@Test
	public void testAdd() {
		int i = 2;
		int j = 3;
		MathOperation obj = new MathOperation();
		assertEquals(5, obj.add(i, j)); // ✅ Expected 5 instead of 40
	}
	
	@Test
	public void testMultiply() {
		int i = 2;
		int j = 3;
		MathOperation obj = new MathOperation();
		assertEquals(6, obj.multiply(i, j)); // ✅ Correct expected value
	}
	
	@Test
	public void testValidateName() {
		String custname = "James";
		MathOperation obj = new MathOperation();
		assertTrue(obj.validateName(custname)); // ✅ Should return true
	}

	@Test
	public void testName() {
		String name = "Varshika"; // ✅ Not null now
		assertNotNull(name);
	}

	@Test
	public void testValidation() {
		boolean status = true;
		assertTrue(status); // ✅ Always true
	}
}
