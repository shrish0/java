public class MergeSortedArrayInSingleArray{

    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int p = m - 1; // Pointer for nums1
        int q = n - 1; // Pointer for nums2
        int index = m + n - 1; // Pointer for the end of nums1
        while(p>=0 & q>=0){
            if(nums1[p]>nums2[q]){
                nums1[index--]=nums1[p--];
            }
            else{
                nums1[index--]=nums2[q--];
            }
        }
        while(q>=0){
            nums1[index--]=nums2[q--];
        }
    }
    public static void main(String[] args) {
        int[] nums1 = {1,4,7,9,12,0,0,0};
        int[] nums2 = {2,4,21};
        merge(nums1, 5, nums2, 3);
        System.out.println("Merged Array:");
        for(int x : nums1){
            System.out.print(x+" ");
        }
    }
}