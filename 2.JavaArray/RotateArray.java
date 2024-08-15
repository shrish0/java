public class RotateArray{
    public void arrayRotate1(int[] nums,int k){
        int len = nums.length,x;
        int nums2[]=new int[len];
        for(x=0;x<len;x++){
            nums2[(x+k)%len]=nums[x];
        }
        for(x=0;x<len;x++){
            nums[x]=nums2[x];
        }
    }
    public static void printArray(int nums[]){
        for(int x:nums){
            System.out.print(x+"  ");
        }
        System.out.println();
       
    }
    public static void main(String args[]){
        int[] nums1 = {1, 2, 3, 4, 5, 6, 7};
        int k1 = 3;
        int[] nums2 = {-1, -100, 3, 99};
        int k2 = 2;
        
        // Creating solution objects
        RotateArray inPlaceSolution = new RotateArray();
        
        // Running the efficient in-place solution
        System.out.println("Efficient In-Place Solution:");
        System.out.println("Before rotation: ");
        printArray(nums1);
        inPlaceSolution.arrayRotate1(nums1, k1);
        System.out.println("After rotation by " +k1+" : ");
        printArray(nums1);
    }
}