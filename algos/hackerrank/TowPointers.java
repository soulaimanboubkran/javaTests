package algos.hackerrank;
import java.util.*;
public class TowPointers {
    

    public static boolean isPalindrome(String s) {
        // Remove non-alphanumeric characters and convert to lowercase
        s = s.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
        int left = 0, right = s.length() - 1;

        while(left < right){
            if(s.charAt(left) != s.charAt(right)){
                return false;
            }else{
                left++;
                right--;
            }
        
        }
        return true;
        
    }
    //it must be sorted 
    public static int[] twoSum(int[] numbers, int target) {
        int left = 0;
        int right=numbers.length -1;
       
        while(left < right){ 
            int sum = numbers[left] + numbers[right];
            if(sum == target){
                return new int[]{left+1,right + 1};
                //cause it's sorted we can do this 
            }else if(sum < target){
                left++;
            }else{
               
                right--;
            }
        }
        return new int[]{-1, -1}; // Should never reach here
    }

    public static List<List<Integer>> threeSum(int[] nums) {
      Arrays.sort(nums);
      List<List<Integer>> result = new ArrayList<>();

      for(int i =0 ; i < nums.length -2 ; i++){
        if(i > 0 && nums[i] == nums[i-1]) continue;
        int left = i +1 ;
        int right = nums.length -1;
        while(left < right){
            int sum = nums[i] + nums[left] + nums[right];
            if(sum == 0){
                result.add(Arrays.asList(nums[i] , nums[left] , nums[right]));

                while(left < right && nums[left] == nums[left+1]) left++;
                while(left < right && nums[right] == nums[right-1]) right--;


                left++;
                right--;
            }else if(sum < 0){
                left++;
            }else{
                right--;
            }
        }
      }
      return result;


    }

    public static int maxArea(int[] height) {
        int max = 0;
        int left = 0;
        int right = height.length -1;
        while(left < right){
            //we calculate based on the min height 
            if(height[left] < height[right]){
                
                max = Math.max(max,height[left]*(right-left));
                left++;
            }else{
                max = Math.max(max,height[right]*(right-left));
                right--;
            }

        }
        return max;
    }
}
