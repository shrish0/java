public class RemoveDuplicateElementCond {
    public int removeDuplicateElementCond(int[] nums){
        int l1=nums.length;
        if(l1==0){
            return 0;
        }
        int k=0;
        for(int x=0;x<l1;x++){
            if(k<2 || nums[x]!=nums[k-2]){
                nums[k]=nums[x];
                k++;
            }
        }
        return k;
    }
    public static void main(String[] args) {
        RemoveDuplicateElementCond rm = new RemoveDuplicateElementCond();
        int nums[]={1,1,1,2,2,3};
        int k=rm.removeDuplicateElementCond(nums);
        System.out.println();
        for(int x=0;x<k;x++){
           System.out.print(nums[x]+"  ");
        }
    }
}
