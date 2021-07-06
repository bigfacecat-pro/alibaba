package binarySearch0623;

public class mian10_03 {
    public static void main(String[] args) {
        for(int i=0;i<10;++i) {
            System.out.print(i+" ");
            int res = search(new int[]{21, 21, -21, -20, -17, -8, -6, -2, -2, -1, 0, 2, 3, 4, 4, 6, 11, 13, 14, 16, 17, 18, 20}, 4);
            if(res!=-1)
            System.out.println(res);
        }
    }
    public static int search(int[] arr, int target) {
        if(arr[0]==target)  return 0;
        int left=0,right=arr.length-1,mid=0;
        while (left<right&&arr[left]==arr[right])
            left++;
        while (left<right){
            mid=left+(right-left)/2;
            if(arr[mid]<arr[right])    right=mid;
            else if(arr[mid]==arr[right])    right=mid;
            else if(arr[mid]>arr[right])    left=mid+1;
        }
        int startIndex=left;
        left=target>arr[arr.length-1]?0:startIndex;
        right=target>arr[arr.length-1]?startIndex:arr.length;
        while (left<right){
            mid=left+(right-left)/2;
            if(arr[mid]>=target)    right=mid;
            else if(arr[mid]<target)    left=mid+1;
        }
        return arr[left]==target?left:-1;
    }
}
