class Solution {
    public int[] pivotArray(int[] nums, int pivot) {
        int n = nums.length;
        List<Integer> less = new ArrayList<>();  
        List<Integer> equal = new ArrayList<>();  
        List<Integer> greater = new ArrayList<>();      
        for(int num : nums){
            if(num < pivot) less.add(num);
            if(num == pivot) equal.add(num);
            if(num > pivot) greater.add(num);
        }
        int[] ans = new int[n];
        int i = 0;
        
        for(int num : less) ans[i++] = num;
        for(int num : equal) ans[i++] = num;
        for(int num : greater) ans[i++] = num;

        return ans;
    }
}