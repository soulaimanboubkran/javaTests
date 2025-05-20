
import java.util.*;
public class HashMap {


      public static int birthdayCakeCandles(List<Integer> candles) {
    // Write your code here
    Map<Integer,Integer> frequencyMap = new HashMap<>();
    int maxHeight = 0;
    
    for(int height : candles){
        frequencyMap.put(height, frequencyMap.getOrDefault(height, 0)+1);
    
    maxHeight = height > maxHeight ? height : maxHeight;
    }

    return frequencyMap.get(maxHeight);
    }
}


public static String angryProfessor(int k, List<Integer> a) {
    // Write your code here
    int onTimeCount = 0;
    for(int arrivalTime : a){
        if(arrivalTime <= 0){
            onTimeCount++;
            if(onTimeCount >= k){
                return "NO";
            }
        }
    }
    return "YES";

    }


       public static List<Integer> breakingRecords(List<Integer> scores) {
    // Write your code here
            if (scores.isEmpty()) {
            return Arrays.asList(0, 0);
        }

    int highestScoreCount = 0, lowestScoreCount = 0;
      int highestScore = scores.get(0);
        int lowestScore = scores.get(0);
    for(int score : scores){
  
        if(score > highestScore){
           
            highestScoreCount++;
            highestScore = score;
        }else if(score < lowestScore){
            lowestScoreCount++;
            lowestScore = score;
        }
    }
     return Arrays.asList(highestScoreCount, lowestScoreCount);
    }

 public static List<Integer> breakingRecords2(List<Integer> scores) {
        if (scores == null || scores.isEmpty()) {
            return Arrays.asList(0, 0);
        }
        
        // Use primitive array for better performance
        int[] result = new int[2]; // [highestScoreCount, lowestScoreCount]
        int highestScore = scores.get(0);
        int lowestScore = scores.get(0);
        
        // Use iterator for more efficient list traversal
       c // Skip the first score which we already processed
        
        while (iterator.hasNext()) {
            int currentScore = iterator.next();
            
            // Use direct comparison without nested conditions for better branching
            if (currentScore > highestScore) {
                highestScore = currentScore;
                result[0]++;
            }
            // Separate comparison to avoid unnecessary else branch
            if (currentScore < lowestScore) {
                lowestScore = currentScore;
                result[1]++;
            }
        }
        
        // Convert primitive array to List
        return Arrays.asList(result[0], result[1]);
    }


    public static int diagonalDifference(List<List<Integer>> arr) {
    int n = arr.size();
    int primaryDiagonal = 0;
    int secondaryDiagonal = 0;
    
    for (int i = 0; i < n; i++) {
        primaryDiagonal += arr.get(i).get(i);
        //from the last item reduce by one every itiration
        secondaryDiagonal += arr.get(i).get(n - 1 - i);
    }
    
    return Math.abs(primaryDiagonal - secondaryDiagonal);
}

}

public static int birthday(List<Integer> s, int d, int m) {
    // Write your code here
    
        int count = 0;
           if (s.size() < m) {
        return 0;
    }
        for(int i= 0 ; i <= s.size() - m;i++){
        int sum = 0;

        //make sum in a range of m with initial index i
        for (int j = i; j < i + m; j++) {
            sum += s.get(j);
        }
        if(sum == d){
            count++;
        }
       }
      return count;
    }

}

public static int divisibleSumPairs(int n, int k, List<Integer> ar) {
    // This map will keep track of remainders we've seen so far
    Map<Integer, Integer> remainderCounts = new HashMap<>();
    int pairCount = 0;
    
    // Process each number in the array one by one
    for (int num : ar) {
        // Calculate the remainder when this number is divided by k
        int remainder = num % k;
        
        // Calculate what remainder we need to find to make a sum divisible by k
        // If current number gives remainder 'r', we need numbers with remainder 'k-r'
        int complementRemainder = (k - remainder) % k;
        
        // Check if we've seen numbers with the complement remainder before
        // If yes, they can form pairs with our current number
        if (remainderCounts.containsKey(complementRemainder)) {
            pairCount += remainderCounts.get(complementRemainder);
        }
        
        // Add the current remainder to our map
        remainderCounts.put(remainder, remainderCounts.getOrDefault(remainder, 0) + 1);
    }
    
    return pairCount;
}

public static int migratoryBirds(List<Integer> arr) {
    // Create an array to count the occurrences (frequency) of each bird type.
    // Since bird types are only between 1 and 5, we create an array of size 6.
    // Index 0 is unused so that the bird type number matches the index directly.
    int[] birdCounts = new int[6]; // birdCounts[1] to birdCounts[5] will be used.

    // Count the frequency of each bird type from the input list
    for (int birdType : arr) {
        // Increment the count of this bird type
        birdCounts[birdType]++;
    }

    // Variable to keep track of the highest frequency we've seen
    int maxFrequency = 0;

    // Variable to store the bird type with the highest frequency
    int mostFrequentBirdType = 0;

    // Loop through bird types from 1 to 5
    // This order ensures that in case of a tie, the smallest ID is chosen
    for (int type = 1; type <= 5; type++) {
        // If the current type has a higher frequency than what we’ve seen so far
        if (birdCounts[type] > maxFrequency) {
            // Update max frequency
            maxFrequency = birdCounts[type];
            // Update the most frequent bird type to the current one
            mostFrequentBirdType = type;
        }
        // NOTE: If the frequency is equal (==), we do nothing.
        // Since we're looping from smallest to largest type ID,
        // the first type with that max frequency is kept (smallest one).
    }

    // Return the bird type with the highest frequency
    return mostFrequentBirdType;
}
