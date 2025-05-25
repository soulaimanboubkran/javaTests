package algos.LeetCode;

import java.lang.reflect.Array;
import java.util.*;

public class Arraysds {
     public int[][] merge(int[][] intervals) {
      if (intervals.length <= 1) return intervals;
         // Step 1: Sort by start time
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        List<int[]> merged = new ArrayList<>();
        // Step 2: Iterate and merge
        int[] current = intervals[0];
        merged.add(current);


        for(int[] interval : intervals){
            int currentEnd = current[1];
            int nextStart = interval[0];
            int nextEnd = interval[1];

            if (nextStart <= currentEnd) {
                // Overlapping: merge
                current[1] = Math.max(currentEnd, nextEnd);
            } else {
                // No overlap: add new interval
                current = interval;
                merged.add(current);
            }
        }
         return merged.toArray(new int[merged.size()][]);
    }
 public String longestCommonPrefix(String[] strs) {
        if(strs.length == 0 ) return "";
        String prefix = strs[0];

        for(int i = 1 ; i < strs.length ; i++){
            while(strs[i].indexOf(prefix) != 0){
                prefix = prefix.substring(0,prefix.length() - 1);
            }
        }
        return prefix;
    }
  public int missingNumber(int[] nums) {
        int n = nums.length;
        int expectedSum = n * (n + 1) / 2;
        int actualSum = 0;

        for (int num : nums) {
            actualSum += num;
        }

        return expectedSum - actualSum;
    }


    class Solution {
public void rotate(int[] nums, int k) {
        int n = nums.length;
        k %= n; // In case k > n

        // Step 1: Reverse the whole array
        reverse(nums, 0, n - 1);

        // Step 2: Reverse the first k elements
        reverse(nums, 0, k - 1);

        // Step 3: Reverse the remaining n-k elements
        reverse(nums, k, n - 1);
    }

    private void reverse(int[] nums, int left, int right) {
        while (left < right) {
            int temp = nums[left];
            nums[left] = nums[right];
            nums[right] = temp;
            left++;
            right--;
        }
    }
    
    public static int[] rotateRightExtraSpace(int[] arr, int k) {
        if (arr.length == 0) return arr;
        
        int n = arr.length;
        k = k % n; // Handle k > n
        
        int[] result = new int[n];
        
        // Copy elements to their new positions
        for (int i = 0; i < n; i++) {
            result[(i + k) % n] = arr[i];
        }
        
        return result;
    }
}
     
 /**
     * Basic approach to check if array is sorted in ascending order.
     * Time Complexity: O(n), Space Complexity: O(1)
     * 
     * @param arr Array of integers
     * @return true if sorted in ascending order, false otherwise
     */
    public static boolean isSortedAscending(int[] arr) {
        if (arr.length <= 1) {
            return true;
        }
        
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] < arr[i - 1]) {
                return false;
            }
        }
        return true;
    }
    
    /**
     * Check if array is sorted in descending order.
     * Time Complexity: O(n), Space Complexity: O(1)
     * 
     * @param arr Array of integers
     * @return true if sorted in descending order, false otherwise
     */
    public static boolean isSortedDescending(int[] arr) {
        if (arr.length <= 1) {
            return true;
        }
        
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > arr[i - 1]) {
                return false;
            }
        }
        return true;
    }
    
    public static Integer findSecondLargestOptimized(int[] arr) {
        if (arr.length < 2) {
            return null;
        }
        
        // Use HashSet to get unique elements
        HashSet<Integer> uniqueElements = new HashSet<>();
        for (int num : arr) {
            uniqueElements.add(num);
        }
        
        if (uniqueElements.size() < 2) {
            return null;
        }
        
        // Track largest and second largest
        int largest = Integer.MIN_VALUE;
        int secondLargest = Integer.MIN_VALUE;
        
        for (int num : uniqueElements) {
            if (num > largest) {
                secondLargest = largest;
                largest = num;
            } else if (num > secondLargest) {
                secondLargest = num;
            }
        }
        
        return secondLargest == Integer.MIN_VALUE ? null : secondLargest;
    }
public int countWords(String sentence) {
        if (sentence == null || sentence.trim().isEmpty()) {
            return 0;
        }

        String cleanSentence = sentence.replaceAll("[^a-zA-Z0-9\\s]", " ");
        String[] words = cleanSentence.trim().split("\\s+");

        int count = 0;
        for (String word : words) {
            if (!word.trim().isEmpty()) {
                count++;
            }
        }
        
        return count;
    }
    public static List<Integer> reverseArray(List<Integer> a) {

        // sow this one iterates only half the array and swaps the elements from the
        // front and back of the array
        for (int i = 0; i < a.size() / 2; i++) {
            int temp = a.get(i);
            a.set(i, a.get(a.size() - 1 - i));
            a.set(a.size() - 1 - i, temp);
        }
        return a;
    }

    public static int hourglassSum(List<List<Integer>> arr) {
        if (arr.size() < 6 || arr.get(0).size() < 6) {
            throw new IllegalArgumentException("The matrix must be 6x6.");
        }
        // Write your code here
        int maxSum = Integer.MIN_VALUE;
        for (int i = 0; i <= arr.size() - 3; i++) { // Fixed iteration limit
            for (int j = 0; j <= arr.get(i).size() - 3; j++) { // Fixed iteration limit
                int sum = arr.get(i).get(j) + arr.get(i).get(j + 1) + arr.get(i).get(j + 2)
                        + arr.get(i + 1).get(j + 1)
                        + arr.get(i + 2).get(j) + arr.get(i + 2).get(j + 1) + arr.get(i + 2).get(j + 2);

                maxSum = Math.max(maxSum, sum);
            }
        }
        return maxSum;
    }

    // O(n*d)
    public static List<Integer> rotateLeft(int d, List<Integer> arr) {
        List<Integer> mutableList = new ArrayList<>(arr); // Convert to mutable list

        // normaly when we peak the first element the array shifts to the left
        for (int i = 0; i < d; i++) {
            int temp = mutableList.remove(0); // Remove first element
            mutableList.add(temp); // Add it to the end
        }

        return mutableList;
    }

    // O(n)
    public static List<Integer> rotateLeft2(int d, List<Integer> arr) {
        int n = arr.size();
        List<Integer> rotated = new ArrayList<>(n);

        // Iterate through the array and shift indices
        for (int i = 0; i < n; i++) {
            rotated.add(arr.get((i + d) % n));
        }

        return rotated;
    }

    public static List<Integer> rotateLeft3(int d, List<Integer> arr) {
        int n = arr.size();
        List<Integer> rotated = new ArrayList<>(n);

        // Start from index 'd' and go to the end
        for (int i = d; i < n; i++) {
            rotated.add(arr.get(i));
        }

        // Add the first 'd' elements to the end
        for (int i = 0; i < d; i++) {
            rotated.add(arr.get(i));
        }

        return rotated;
    }

    public static List<Integer> matchingStrings(List<String> stringList, List<String> queries) {
       // Step 1: Store frequencies in a HashMap
         HashMap<String,Integer> map = new HashMap<>();
        for(String s:stringList){
            map.put(s,map.getOrDefault(s, 0)+1);

        }
         // Step 2: Process each query using the map
        List<Integer> result = new ArrayList<>();
        for(String q : queries){
            result.add(map.getOrDefault(q,0));
        }
        
 public static int Max(List<Integer> list) {
        if (list == null || list.isEmpty()) {
            return;
        }
        int max = list.get(0);
        for (int i = 1; i < list.size(); i++) {
            if (list.get(i) > max) {
                max = list.get(i);
            }
        }
        
        return max;
    }
        return result;
        }

        public static long arrayManipulation(int n, List<List<Integer>> queries) {
            long[] arr = new long[n + 1]; // Using long to avoid integer overflow

            // it adds the value of k to the element at index a and subtracts k from the element at index b + 1 ,
            //sow after then when we do sum we know the value of k is added to all the elements from a to b
            for(List<Integer> query : queries) {
                int a = query.get(0);
                int b = query.get(1);
                int k = query.get(2);

                arr[a] += k;
                if(b + 1 <= n) {
                    arr[b + 1] -= k;
                }

                
            }
              // Compute prefix sum and track max value
            long max = 0, sum = 0;
            for(int i = 1; i <= n; i++) {
                sum += arr[i];
                max = Math.max(max, sum);
            }
        
            return max;
        }    
        //Contiguous Array 
        public int findMaxLength(int[] nums){
            HashMap<Integer, Integer> map = new HashMap<>();
            map.put(0, -1);//initialize the map with 0 at index -1
            int max_length = 0, count = 0;

            for(int i = 0; i< nums.length ; i++){
                count  += (nums[i] == 0) ? -1 :1;
                if(map.containsKey(count)){
                    max_length = Math.max(max_length, i - map.get(count));
                    // i - map.get(count) is the length of the subarray map.get(count) is the index of the first occurence of count

                }else{
                    map.put(count, i);
                }
            }
            return max_length;

        }
        //Array Partition max sum of min of pairs
    public int arrayPairSum(int[] nums) {
        Arrays.sort(nums);
        int sum = 0;
        for(int i = 0 ; i < nums.length; i+=2){
            sum += nums[i];
        }
        return sum;
    }

    
    // Array Nesting: Find the longest length of a nested set.
    // We loop through the array and explore cycles by following the indices.
    // To avoid revisiting elements, we mark them as -1 once processed.
    // If we encounter a visited element (-1), we skip it.
    // After processing a cycle, we update maxLen if the current cycle is longer.
    public int arrayNested(int[] nums){
        int maxLen = 0;
        for(int i = 0 ; i<nums.length ; i++){
            if (nums[i] == -1) continue; // Skip visited elements

          int start = nums[i], count = 0;   
          while(nums[start] != -1){
            int temp = start;
            start = nums[start];
            nums[temp] = -1;
            count++;
          }
            maxLen = Math.max(maxLen, count);
        }
        return maxLen;
    }


    public static boolean containsDuplicate(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for(int i = 0 ; i < nums.length ; i++){
            if(set.contains(nums[i])){
                return true;
            }
            set.add(nums[i]);
            
        }
        return false;
    }

    // Anagram: Check if two strings are anagrams of each other
    // We use a HashMap to store the frequency of characters in the first string.
    // Then we reduce the frequency of characters using the second string.
    // If the frequency of a character becomes zero, we remove it from the map.so if the map is empty then the strings are anagrams
    public static boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        HashMap<Character, Integer> map = new HashMap<>();

        // Count frequency of characters in s
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);  // Use charAt instead of substring
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        // Reduce frequency of characters using t
        for (int i = 0; i < t.length(); i++) {
            char c = t.charAt(i);  // Use charAt instead of substring
            if (!map.containsKey(c)) {
                return false;
            }
            map.put(c, map.get(c) - 1);
            if (map.get(c) == 0) {
                map.remove(c);
            }
        }

        return true;
    }
    public static boolean isAnagram2(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        char[] sChars = s.toCharArray();
        char[] tChars = t.toCharArray();
         Arrays.sort(sChars);
        Arrays.sort(tChars);
        return Arrays.equals(sChars, tChars);
    }

    // Group Anagrams: Group anagrams together
    // We sort each string and use the sorted string as a key in a HashMap.
    // The value is a list of anagrams that match the key.

    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> result  = new ArrayList<>();
        HashMap<String,List<String>> map = new HashMap<>();

        for(String s : strs){
            char[] chars = s.toCharArray();
            Arrays.sort(chars);
            String key = new String(chars);
            if(map.containsKey(key)){
                map.get(key).add(s);
            }else{
                List<String> strList = new ArrayList<>();
                strList.add(s);
                map.put(key, strList);
            }
        }
        result.addAll(map.values());
        return result;
    }

    // we use the complement of the current element to find the other element that sums up to the target
    // in math we have a + b = c, we can rewrite it as b = c - a
    public static int[] twoSum(int[] nums, int target) {

        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < nums.length ; i++){
            int complement = target - nums[i];
            if(map.containsKey(complement)){
                return new int[]{
                    map.get(complement),i
                };
            }

            map.put(nums[i], i);
        }


        return new int[0];
    }

    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int num :nums){
            map.put(num,map.getOrDefault(num,0 )+1);
        }
        
        Map<Integer,List<Integer>> freqMap = new HashMap<>();
        for(Integer num : map.keySet()){
            Integer freq = map.get(num);
            if(!freqMap.containsKey(freq)){
                freqMap.put(freq, new ArrayList<>());
            }
            freqMap.get(freq).add(num);
        }
        int[] result = new int[k];
        for(Integer n = nums.length; n >= 0; n--){
            if(freqMap.containsKey(n)){
                List<Integer> list = freqMap.get(n);
                for(int num : list){
                    if(k == 0){ 
                        return result;
                    }
                    result[k-1] = num;
                    k--;
                }
            }
        }
        return result;

    }

    public static  String encode(List<String> strs){
        StringBuilder encoded = new StringBuilder();
        for(String s : strs){
            encoded.append(s.length()).append('/').append(s);
        }
        return encoded.toString();
    }

    public static List<String> decode(String s) {
        List<String> result = new ArrayList<>();
        int i = 0;

        while (i < s.length()) {
            // Find the '/' separator
            int j = i;
            while (s.charAt(j) != '/') {
                j++;
            }

            // Extract the length of the next string
            int length = Integer.parseInt(s.substring(i, j));
            i = j + 1; // Move past '/'

            // Extract the actual string
            result.add(s.substring(i, i + length));
            i += length; // Move to the next encoded string
        }

        return result;
    }

    public static int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] output = new int[n];

        output[0] = 1;
        // Calculate the product of all elements to the left of i  Compute prefix product
        for(int i =1;i < n; i++){
            output[i] = output[i-1] * nums[i-1];
        }
        // Calculate the product of all elements to the right of i  Compute suffix product and multiply with prefix product 
        int right = 1;
        for(int i= n-1 ; i>=0 ; i--){
            output[i] *= right;
            right = right * nums[i];
        }
        return output;
    }

    public static boolean isValidSudoku(char[][] board) {
        HashSet<Integer> seen = new HashSet<>();
        for(int i = 0; i < 9 ; i++){
            for(int j = 0; j < 9 ; j++){
                if(board[i][j]  != '.'){
                    int current = board[i][j] - '0';
// we add the current element to the set with the row, column and box it belongs to
// sow if we find the same element in the same row, column or box we return false , the set will not add the element if it already exists it w
// will return false
                   // Unique encoding using bit shifts ,sinc we do not use string concatenation that was been ensuring the uniqueness of the key
                   int rowKey = (current * 100) + i;      // Encodes (current, row)
                   int colKey = (current * 1000) + j;     // Encodes (current, column)
                   int boxKey = (current * 10000) + (i / 3) * 10 + (j / 3); // Encodes (current, box)

                   // If any value already exists, return false
                   if (!seen.add(rowKey) || !seen.add(colKey) || !seen.add(boxKey)) {
                       return false;
                   }

                }
            }}
            return true;
    }
    public static  int longestConsecutive(int[] nums) {
        if(nums.length == 0) return 0;
        HashSet<Integer> set = new HashSet<>();
        for(int num : nums){
            set.add(num);
        }

        int max = 0;
        for(int num : set){
            // if the set does not contain the number - 1 then we know that the number is the start of the sequence
            // it does not need to be sorted cause it looks for every number in the set
            if(!set.contains(num - 1) ){
                int current = num;
                // set this one to 1 every time we find a sequence  sow it can be compared to the max 
                int currentSequence = 1;
                while(set.contains(current + 1)){
                    current++;
                    currentSequence++;
                }
                max = Math.max(max, currentSequence);
            }


        }
        return max;
    }

    public static int findLengthOfLCIS(int[] nums) {
        if (nums.length == 0) return 0; // Edge case
    
        int max = 1;  // At least one number exists, so the sequence length is at least 1
        int currentSequence = 1;
    
        for (int i = 0; i < nums.length - 1; i++) {  // Loop up to second-last element
            if (nums[i] < nums[i + 1]) {  // Increasing sequence
                currentSequence++;
            } else {  // Sequence breaks
                max = Math.max(max, currentSequence);
                currentSequence = 1;  // Reset counter for the new sequence
            }
        }
    
        return Math.max(max, currentSequence); // Ensure we account for the last sequence
    }

   public static int  numberOfArithmeticSlices(int[] A) {

    if(A.length < 3) return 0;
    int count = 0, sum = 0;
    for(int i = 2 ; i < A.length ; i++){
        // check if the difference between the current element and the previous element is the same as the difference between the previous element and the element before it
        //for the first 3 elements of every sequence we add 1 to the count and add the count to the sum
        if(A[i]- A[i-1] == A[i-1] - A[i-2]){
            count++;
            sum += count;
    }else{
        count = 0;
    }
    }
    return sum;
   }

    public static void main(String[] args) {
        List<Integer> testArray = Arrays.asList(1, 2, 3, 4, 5);
        List<Integer> reversedArray = reverseArray(new ArrayList<>(testArray));

        System.out.println("Original: " + testArray);
        System.out.println("Reversed: " + reversedArray);

        // Hourglass Sum Test
        List<List<Integer>> testMatrix = Arrays.asList(
                Arrays.asList(1, 1, 1, 0, 0, 0),
                Arrays.asList(0, 1, 0, 0, 0, 0),
                Arrays.asList(1, 1, 1, 0, 0, 0),
                Arrays.asList(0, 0, 2, 4, 4, 0),
                Arrays.asList(0, 0, 0, 2, 0, 0),
                Arrays.asList(0, 0, 1, 2, 4, 0));

        int out = hourglassSum(testMatrix);
        System.out.println("Max Hourglass Sum: " + out);

        List<Integer> arr = Arrays.asList(1, 2, 3, 4, 5);
        int d = 2;
        System.out.println(rotateLeft(d, arr));


         // Sample Input with duplicates
         List<String> stringList = Arrays.asList("abc", "abc", "xyz", "abc", "xyz", "def");
         List<String> queries = Arrays.asList("abc", "xyz", "def", "ghi");
 
         // Call function
         List<Integer> output = matchingStrings(stringList, queries);
         
         // Print result
         for (int count : output) {
             System.out.println(count);
         }

         int n = 5;
         List<List<Integer>> queries2 = new ArrayList<>();
         queries2.add(Arrays.asList(1, 2, 100));
         queries2.add(Arrays.asList(2, 5, 100));
         queries2.add(Arrays.asList(3, 4, 100));
 
         System.out.println(arrayManipulation(n, queries2)); // Output: 200

  
         System.out.println(containsDuplicate(new int[]{1,2,3,1}));

         List<String> testStrings = Arrays.asList("hello", "world", "this/is/a/test", "123");

         // Encoding
         String encoded = encode(testStrings);
         System.out.println("Encoded: " + encoded);
 
         // Decoding
         List<String> decoded = decode(encoded);
         System.out.println("Decoded: " + decoded);
 
         // Verify correctness
         System.out.println("Test Passed: " + testStrings.equals(decoded));

System.out.println(findLengthOfLCIS(new int[]{1, 3, 5, 4, 7})); // Output: 3  (1,3,5)
System.out.println(findLengthOfLCIS(new int[]{2, 2, 2, 2, 2})); // Output: 1  (single elements are valid)
System.out.println(findLengthOfLCIS(new int[]{1, 2, 3, 4, 5})); // Output: 5  (entire array is increasing)
System.out.println(findLengthOfLCIS(new int[]{}));              // Output: 0  (empty array)
System.out.println(numberOfArithmeticSlices(new int[]{1, 2, 3, 4})); // Output: 3
System.out.println(numberOfArithmeticSlices(new int[]{1, 2, 3, 5, 7})); // Output: 2
System.out.println(numberOfArithmeticSlices(new int[]{1, 3, 5, 7, 9})); // Output: 6

    }
}
