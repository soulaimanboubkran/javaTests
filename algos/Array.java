package algos;
class Array {
    public static int[] reverse(int[] nums) {
        int start = 0;
        int end = nums.length - 1;

        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
        return nums;
    }

    public static int min(int[] nums){
        int min = nums[0];
        for(int i =1;i<nums.length;i++ ){
            if(nums[i]<min){
                min = nums[i];
            }

        }
        return min;
    }
    public static int  secondMax(int[] nums){
        int Max = Integer.MIN_VALUE;
        int secondMax = Integer.MIN_VALUE;

        for(int i =1;i<nums.length;i++ ){
           if(nums[i]>Max){
            secondMax = Max;
            Max = nums[i];
           
           }else if(nums[i] > secondMax && nums[i] != Max){
            secondMax = nums[i];
           }

        }
        return secondMax;
    }
    public static void main(String[] args) {
        int[] reversedArray = reverse(new int[]{2, 1, 3, 4, 5, 6, 7}); // Call reverse using the class name
        System.out.println(min(reversedArray));

        System.out.println(secondMax(new int[]{7, 1, 3, 4, 5, 6, 7}));
       for (int num : reversedArray) {
            System.out.print(num + " ");
        }
       
    }
}

