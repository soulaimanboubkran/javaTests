package algos.list;
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
    public static int[] moveZeros(int[] nums) {
        int j = 0; // Pointer for the next zero position

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                // Swap only if `i` is not equal to `j`
                if (i != j) {
                    int temp = nums[i];
                    nums[i] = nums[j];
                    nums[j] = temp;
                }
                j++; // Move `j` to the next position
            }
        }
        return nums;
    }

    public static boolean isPalindrome(String word){
        char[] charArray = word.toCharArray();
        int start = 0;
        int end = word.length() -1;
        while (start < end) {
            if(charArray[start] != charArray[end]){
                return  false;
            }
            start++;
            end--;
        }
        return true;
    }
    public static void main(String[] args) {
      //  int[] reversedArray = reverse(new int[]{2, 1, 3, 0, 0, 6, 7}); // Call reverse using the class name
       
      //  System.out.println(min(reversedArray));

      //  System.out.println(secondMax(new int[]{7, 1, 3, 4, 5, 6, 7}));
      
    //  for (int num : moveZeros(new int[]{2, 1, 3, 0, 0, 6, 7})) {
    //        System.out.print(num + " ");
    //    }
     // System.out.println(isPalindrome("")); 
    }
}

