import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

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
		List<List<Integer>> tmp = new ArrayList<>();
		tmp.add(Arrays.asList(1,2,3));
		System.out.println(tmp);
	}
}
