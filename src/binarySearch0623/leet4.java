package binarySearch0623;

public class leet4 {
    public static void main(String[] args) {
        double res=findMedianSortedArrays(new int[]{1,3},new int[]{2});
        System.out.println(res);
    }
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int midIndex=(nums1.length+ nums2.length)>>1;
        int left=0,right= nums1.length-1;
        while (left<right){
            int mid=left+(right-left)/2;
            if(midIndex-mid>nums1.length||nums1[mid]<nums2[midIndex-mid])   left=mid+1;
            else if(nums1[mid]==nums2[midIndex-mid])   return nums1[mid];
            else if(nums1[mid]>nums2[midIndex-mid])   right=mid-1;
        }
        return 0;
    }

}
