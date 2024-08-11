public class RemoveDuplicateElementCond {
    public int removeDuplicateElementCond(int[] nums){
        if(nums.length==0){
            return 0;
        }
        int k=0;
        for(int x=0;x<nums.length;x++){
            if(k<2||nums[x]!=nums[x-2]){
                nums[k]=nums[x];
                k++;
            }
        }
        return k;
    }
    public static void main(String[] args) {
        RemoveDuplicateElementCond rm = new RemoveDuplicateElementCond();
        int nums[]={1,2,2,2,4,6,6,7,7,7,32,345};
        int k=rm.removeDuplicateElementCond(nums);
        System.out.println();
        for(int x=0;x<k;x++){
           System.out.print(nums[x]+"  ");
        }
    }
}
