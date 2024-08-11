import java.util.HashSet;

public class RemoveDuplicateElement {
    //Sorted
    public int removeDuplicates(int[] nums) {
        int l1 = nums.length;
        if (l1 == 0) {
            return 0;
        }
        int k = 1; // Pointer for the position of unique elements
        for (int x = 1; x < l1; x++) {
            if (nums[x - 1] != nums[x]) {
                nums[k] = nums[x];
                k++;
            }
        }
        return k; // Return the count of unique elements
    }

    //Unsorted
    /*  
    public int removeDuplicates(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        int k = 0; // Pointer for the position of unique elements
        
        for (int num : nums) {
            if (set.add(num)) { // add returns false if the element already exists
                nums[k++] = num;
            }
        }
        return k; // Number of unique elements
    }
        */

        public static void main(String[] args) {
            RemoveDuplicateElement rm = new RemoveDuplicateElement();
            int nums[]={1,2,2,4,6,7,7,32,345};
            int k=rm.removeDuplicates(nums);
            System.out.println("Array");
            for(int x=0;x<k;x++){
               System.out.print(nums[x]+"  ");
            }
        }
}
