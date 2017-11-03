
public class complexityAnalysis {

	public static boolean contains (double[] arr, double d1, double eps) {
		for (int i = 0; i < arr.length; i++) {
			if (Math.abs(d1 - arr[i]) < eps) {
				return true;
			}
			System.out.println(i);
		}
		return false;
	}

	
	public static double fastExp(int x, int y) {
		double exp = 0;
		if (y == 0) {
			return 1;
		}
		if (y % 2 == 0) {
			exp = fastExp((x*x), (y/2));
			return exp;
		}
		else  {
			exp = x*fastExp((x*x),(y-1)/2);
			return exp;
		}
	}

	
	public static Pair[] allPairs(int[] arr) throws IllegalArgumentException { 
		Pair[] arr1 = new Pair[(arr.length*arr.length)];
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr.length; j++) {
				arr1[((arr.length)*i + j)] = new Pair(arr[i], arr[j]);  
			}
		}
		return arr1;
	}

	
	public static String concatAndReplicateAll (String[] arr, int n){ 
		String str = "";
		for (int i = 0; i < arr.length; i ++) { 
			for (int j = 0; j < n; j ++){ 
				str = str + arr[i];
			}
		}
		return str; 
	}

	
	public static int[] interleave (int[] arr1, int[] arr2){ 
		int[] arr3 = new int [arr1.length + arr2.length]; 
		for (int i = 0; i < arr3.length; i++) {
			if (i > arr1.length*2 -1  && i < arr2.length*2 ){ 
				arr3[i] = arr2 [i - arr1.length];
			}
			else if (i < arr1.length*2  && i > arr2.length*2 -1){ 
				arr3[i] = arr1 [i - arr2.length];
			}
			else {
				if (i % 2 == 0){
					arr3[i] = arr1[i/2]; 
				}
				else { 
					arr3[i]= arr2[(i-1)/2];
				}
			}
		}
		return arr3;

	}

}
