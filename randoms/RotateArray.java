import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RotateArray {

    public static void main(String[] argv) {
        int[] arr1 = {4,9,5}; int[] arr2={9,4,9,8,4};
        RotateArray ra = new RotateArray();
        //ra.rotate(arr, 3);
        //boolean x = ra.binarySearch(arr, 11);
        //ra.quickSort(arr, 0, arr.length -1);
        //ra.singleNumber(arr);
        int[] arr = ra.intersect(arr1, arr2);
        System.out.println(Arrays.toString(arr));
    }


    public int[] intersect(int[] nums1, int[] nums2) {
        
        quickSort(nums1, 0, nums1.length-1);
        quickSort(nums2, 0, nums2.length-1);
        
        int[] ret = new int[nums1.length];
        
        int num1=0;
        int num2=0;
        int r=0;
        while(num1 < nums1.length && num2<nums2.length) {
            if(nums1[num1] == nums2[num2]) {
                ret[r++] = nums1[num1];
                num1++;
                num2++;
                
            } else if(nums1[num1] < nums2[num2]) {
                num1++;
            } else {
                num2++;
            }
        }
        int[] x = new int[r];
        for(int i=0;i<r;i++) {
            x[i] = ret[i];
        }
        return x;
    }

    public void rotate(int[] nums, int k) {
        int[] a =new int[nums.length];
        
        for(int i=0;i<nums.length;i++) {
            a[(i+k) % nums.length] = nums[i];
        }
        
        for(int i=0;i<nums.length;i++) {
            nums[i] = a[i];
        }
    }


    public int singleNumber(int[] nums) {
        List<Integer> a = new ArrayList<>();
        for(int i=0;i<nums.length;i++) {
            if(!a.contains(nums[i])) {
                a.add(nums[i]);
            } else {
                a.remove(new Integer(nums[i]));
            }
        }
        return a.get(0);
    }


    public boolean binarySearch(int[] arr, int val) {
        
        int left = 0, right = arr.length -1;
        int mid = 0;
        while(left <= right) {
            mid = (left+right)/2;
            if(arr[mid] == val) {
                return true;
            } else if(val > arr[mid]) {
                left = mid+1;        
            } else {
                right = mid-1;
            }
        }
        return false;
    }


    public void quickSort(int[] arr, int start, int end) {
        if(start >= end) {
            return;
        }
        int pivot = end;
        int pindex = start;
        for(int i=start; i<pivot;i++) {
            if(arr[i] <= arr[pivot]) {
                int tmp = arr[i];
                arr[i] = arr[pindex];
                arr[pindex] = tmp;
                pindex += 1;
            }
        }
        int tmp = arr[end];
        arr[end] = arr[pindex];
        arr[pindex] = tmp;

        quickSort(arr, start, pindex-1);
        quickSort(arr, pindex+1, end);
                
    }
}