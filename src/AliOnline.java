

public class AliOnline {
	boolean resolve(int[] A) {
		int sum = 0, count = 0;
		for (int i=0 ; i<A.length ; i++){
			sum += A[i];
			if(helper(A, sum, i , count) == true){
				return true;
			}
		}
		return false;
	}
	
	boolean helper(int[] A, int sum, int index, int count){
		if (count == 3){
			return true;
		}
		count++;
		int res = 0;
		for(int i=index+1; i<A.length ;i++){
			res += A[i];
			if (res == sum){
				if (helper(A, sum, i, count) == true){
				    return true;
				}
			}
		}
		return false;
	}
	
	public static void main(String[] args){
		AliOnline a = new AliOnline();
		int[] A = {2, 5, 1, 1, 1, 1, 4, 1, 7, 3, 7};
		System.out.println(a.resolve(A));
	}
}
