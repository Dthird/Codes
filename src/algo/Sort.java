package algo;

import java.util.Arrays;

/**
 * Created by jason on 4/2/17.
 */
public class Sort {
    public static void main (String[] args){
        int[] a = {9,6,5,8,0,1,4,3,2,7};
        //InsertionSort.insertionSort(a);
        QuickSort.quickSort(a, 0, a.length - 1);
        System.out.println(Arrays.toString(a));
    }

}

class SleepSort extends Thread{
    int ms = 0;
    public SleepSort(int ms){
        this.ms = ms;
    }
    public void run(){
        try {
            //sleep(ms*10+10);
            sleep(ms);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        System.out.println(ms);
    }

    public static void main(String[] args) {
        int[] ints = {1,4,7,3,8,9,2,0,6,5, 3647};
        SleepSort[] sortThreads = new SleepSort[ints.length];
        for (int i = 0; i < sortThreads.length; i++) {
            sortThreads[i] = new SleepSort(ints[i]);
        }
        for (int i = 0; i < sortThreads.length; i++) {
            sortThreads[i].start();
        }
    }
}


class QuickSort{
    public static void quickSort(int[] nums, int low, int high){
        if (low >= high)
            return;
        int p = partition(nums, low, high);
        quickSort(nums, low, p - 1);
        quickSort(nums, p + 1, high);
    }

    private static int partition(int[] nums, int low, int high){
        int pivot = nums[high];
        int index = low - 1;
        for (int i = low; i < high; i++) {
            if (nums[i] <= pivot){
                index++;

                int temp = nums[index];
                nums[index] = nums[i];
                nums[i] = temp;
            }
        }
        nums[high] = nums[index + 1];
        nums[index + 1] = pivot;
        return index + 1;
    }
}

class InsertionSort {
    public static void insertionSort(int[] nums){
        if (nums.length == 0)
            return;
        for (int i = 1; i < nums.length; i++) {
            int j = i - 1;
            int num = nums[i];
            while (j >= 0 && nums[j] > num){
                nums[j + 1] = nums[j];
                j--;
            }
            nums[j + 1] = num;
        }
    }
}
