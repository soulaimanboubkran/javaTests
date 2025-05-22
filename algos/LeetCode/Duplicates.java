package algos.LeetCode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;

public class Duplicates {
     public List<Integer> removeDuplicates(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        List<Integer> result = new ArrayList<>();
        
        for (int i = 0; i < nums.length; i++) {
            // Si l'élément n'est pas déjà dans le set, on l'ajoute
            if (!set.contains(nums[i])) {
                set.add(nums[i]);
                result.add(nums[i]); // Préserve l'ordre d'apparition
            }
        }
        
        return result;
    }
    
    // Méthode 2: Version alternative avec LinkedHashSet (préserve l'ordre)
    public List<Integer> removeDuplicatesV2(int[] nums) {
        LinkedHashSet<Integer> set = new LinkedHashSet<>();
        
        for (int num : nums) {
            set.add(num);
        }
        
        return new ArrayList<>(set);
    }
    
}
