
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