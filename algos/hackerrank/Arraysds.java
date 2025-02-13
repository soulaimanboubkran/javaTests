package algos.hackerrank;

import java.util.*;

public class Arraysds {

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
    }
}
