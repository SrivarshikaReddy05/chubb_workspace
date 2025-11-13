import java.util.Arrays;

public class payment {

	public void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("This is my 1st program");
		int ar[] = { 1002,110,23445,6789,9807,6455,75432};
//		ls(ar,8);
//		bs(ar,8);
		insertionSort(ar);
//		fib(8);
//		prime(500);
//		print();
//		multiply(5,6);
	}
	
	public void insertionSort(int[] ar) {
	    int n = ar.length;
	    for (int i = 1; i < n; i++) {
	        int curr = ar[i];
	        int j = i - 1;
	        while (j >= 0 && ar[j] > curr) {
	            ar[j + 1] = ar[j];
	            j--;
	        }
	        ar[j + 1] = curr;
	    }
	    for (int num : ar) {
            System.out.print(num + " ");
        }
	}

	
//	public static void ls(int ar[] , int sEle) {
//		int flag = 0;
//		for(int i = 0; i<ar.length ; i++) {
//			if(sEle == ar[i]) {
//				flag = 1;
//				break;
//			}
//		}
//		if( flag == 0 )System.out.println("Not Found");
//		else System.out.println("Found");
//	}
//	
//	public static void bs(int ar[] , int sEle) {
//		int low = 0;
//		int high = ar.length - 1;
//		Arrays.sort(ar);
//		int flag = 0;
//		while( low <= high ) {
//			int mid = (low+high)/2;
//			if(ar[mid] == sEle) {
//				flag = 1;
//				break;
//			}
//			else if(ar[mid] < sEle) {
//				low = mid+1;
//			}
//			else high = mid - 1;
//		}
//		if( flag == 0 )System.out.println("Not Found");
//		else System.out.println("Found");
//	}
//	
//	
	
	
//		public static void fib(int n) {
//			if(n < 0) return;
//
//	        int a = 0, b = 1;
//
//	        if(n >= 0) System.out.print(a + " ");
//	        if(n >= 1) System.out.print(b + " ");
//
//	        for(int i = 2; i <= n; i++) {
//	            int c = a + b;
//	            System.out.print(c + " ");
//	            a = b;
//	            b = c;
//	        }
//		}
//		
//	
//		public static void prime(int n) {
//			for(int i = 1; i < n; i++) {
//				if(isPrime(i) == 1) {
//					System.out.print(i+" ");
//				}
//			}
//		}
//		public static int isPrime(int n) {
//			
//			for(int i = 2; i<n;i++) {
//				if(n%i == 0) return 0;
//			}
//			return 1;
//		}
//	public static void print() {
//		System.out.println("This is print function");
//		int i = 0;
//		int ar[] = {1,2,3,4,5};
//		for(int j = 0;j<ar.length;j++) {
//			System.out.print(ar[j]+" ");
//		}
//		for(i=0;i< 5 ; i++) {
//			System.out.println("Value of i "+i);
//		}
//		System.out.println("Value of i "+i);
//		while(i < 10 && i>5) {
//			System.out.println("Value of i "+i);
//			i+=1;
//		}
//	}
	public void print() {
		System.out.println("hivchn");
	}
//	
//	public static void multiply(int a, int b) {
//		int ans = a*b;
//		System.out.println("Value of ans "+ans);
//	}
}

