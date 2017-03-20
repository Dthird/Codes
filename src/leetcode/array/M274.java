package leetcode.array;

/**
 * Created by jason on 3/20/17.
 */

import java.util.Arrays;

/**
 * H-Index
 */
public class M274 {
    public int hIndex(int[] citations) {
        Arrays.sort(citations);
        int low = 0, high = citations.length - 1;
        while(low <= high){
            int tmp = citations[low];
            citations[low] = citations[high];
            citations[high] = tmp;
            low++;
            high--;
        }

        int hIndex = 0;
        for (int i = 0; i < citations.length; i++) {
            hIndex = Math.max(hIndex, Math.min(i + 1, citations[i]));
        }

        return hIndex;
    }



}
