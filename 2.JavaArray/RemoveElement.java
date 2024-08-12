public class RemoveElement {
        public static int removeElement(int[] nums, int val) {
        int k = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                nums[k] = nums[i];
                k++;
            }
        }
        return k;
        }

    
    public static void main(String[] args) {
        int[] nums={1,2,3,3,2,6};
        int count=removeElement(nums,3);
        System.out.println(count);
        System.out.println("Array");
        for(int i=0 ;i<count;i++){
            System.out.print(nums[i]+" ");
        }

    }
}


// class Solution {
//     public int removeElement(int[] nums, int val) {
//         int start = 0;
//         int last = nums.length - 1;
        
//         while (start <= last) {
//             if (nums[start] == val) {
//                 nums[start] = nums[last];
//                 last--;
//             } else {
//                 start++;
//             }
//         }
        
//         return start;
//     }
// }
