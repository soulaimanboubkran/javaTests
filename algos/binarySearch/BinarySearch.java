package algos.binarySearch;

public class BinarySearch {
    public int search(int[] nums,int key){
        int low = 0;
        int high = nums.length -1;

        while (low < high) {
            int mid  = (high + low) / 2;
            if(nums[mid] == key) return mid;
            if(key < nums[mid]){
                high = mid -1;
            }else{
                low = mid +1;
            }


        }
        return -1;
    }

    public int searchInsert(int[] nums,int target){
        int low = 0;
        int high = nums.length -1;
        while(low < high){
            int mid = low + (high + low) /2;
            if(nums[mid] == target) return mid;
            if(target < mid){
                high = mid -1;
            }else{
                low = mid +1;
            }

        }
        return low;
    }
    public static void main(String[] args) {
        BinarySearch bs = new BinarySearch();

        int[] nums = {1, 3, 5, 7, 9, 11, 13};
        int key = 7;

        int result = bs.search(nums, key);
        if (result != -1) {
            System.out.println("Key " + key + " found at index " + result);
        } else {
            System.out.println("Key " + key + " not found in the array.");
        }

        // Test with a key not in the array
        key = 6;
        result = bs.search(nums, key);
        if (result != -1) {
            System.out.println("Key " + key + " found at index " + result);
        } else {
            System.out.println("Key " + key + " not found in the array.");
        }
    }
}
