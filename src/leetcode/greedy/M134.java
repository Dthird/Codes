package leetcode.greedy;

/**
 * Created by jason on 3/17/17.
 */

/**
 * Gas Station
 */
public class M134 {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int sum = 0, strat = 0, all = 0;
        for (int i = 0; i < gas.length; i++) {
            int tmp = gas[i] - cost[i];
            sum += tmp;
            if (all + tmp < 0){
                all = 0;
                strat = i + 1; // i + 1
            } else {
                all += tmp;
            }

        }
        return sum < 0 ? -1 : strat;
    }
}
