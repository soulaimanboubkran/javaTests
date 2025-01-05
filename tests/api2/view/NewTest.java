package tests.api2.view;

public class NewTest {
    // Exercice 1
public class StringExercises {
    // Retourne la longueur d'une chaîne
    public static int longueur1(String chaine) {
        return chaine.length();
    }
    
    // Retourne la longueur d'une chaîne en la transformant en tableau
    public static int longueur2(String chaine) {
        char[] tableau = chaine.toCharArray();
        return tableau.length;
    }
    
    // Concatène deux chaînes selon l'ordre lexicographique
    public static String concat(String s1, String s2) {
        if (s1.compareTo(s2) < 0) {
            return s1 + s2;
        }
        return s2 + s1;
    }
    
    // Teste l'égalité de deux tableaux de caractères
    public static boolean estEgal(char[] TChar1, char[] TChar2) {
        if (TChar1.length != TChar2.length) {
            return false;
        }
        for (int i = 0; i < TChar1.length; i++) {
            if (TChar1[i] != TChar2[i]) {
                return false;
            }
        }
        return true;
    }
}

// Exercice 2
public class ConversionExercises {
    public static void main(String[] args) {
        // A. Conversion int vers String
        int nombre = 12345;
        String str1 = String.valueOf(nombre);
        // ou: String str1 = Integer.toString(nombre);
        
        // B. Conversion String vers int
        String strNombre = "12345";
        int num = Integer.parseInt(strNombre);
        
        // C. Conversion String vers float
        String strFloat = "0.12345e4";
        float f = Float.parseFloat(strFloat);
        
        // D. Comparaison des premiers caractères
        String s1 = "Hello";
        String s2 = "Help";
        boolean memeDebut = s1.charAt(0) == s2.charAt(0);
        
        // F(E). Comparaisons de chaînes
        s1 = "abcd";
        s2 = "AbcD";
        System.out.println("s1 == s2: " + (s1 == s2));
        System.out.println("s1.equals(s2): " + s1.equals(s2));
        System.out.println("s1.compareTo(s2): " + s1.compareTo(s2));
        System.out.println("s1.compareToIgnoreCase(s2): " + s1.compareToIgnoreCase(s2));
        
        // G. Tests de contenance
        boolean commencePar = s1.startsWith(s2);
        boolean finitPar = s1.endsWith(s2);
        boolean contient = s1.contains(s2);
        
        // H. Suppression d'une sous-chaîne
        String resultat = s1.contains(s2) ? s1.replace(s2, "") : s1;
    }
}

// Exercice 4
public class AlternateDisplay {
    public static void afficherAlterne(String chaine) {
        StringBuilder impairs = new StringBuilder();
        StringBuilder pairs = new StringBuilder();
        
        for (int i = 0; i < chaine.length(); i++) {
            if (i % 2 == 0) {
                impairs.append(chaine.charAt(i));
            } else {
                pairs.append(chaine.charAt(i));
            }
        }
        
        System.out.println(impairs);
        System.out.println(pairs);
    }
}

// Exercice 5
public class StringBuilderExercises {
    // Solution avec String
    public static String buildString(char c, int n) {
        if (n <= 0) return "";
        String result = "";
        for (int i = 0; i < n; i++) {
            result += c;
        }
        return result;
    }
    
    // Solution avec StringBuilder (plus efficace)
    public static String buildStringBuilder(char c, int n) {
        if (n <= 0) return "";
        StringBuilder sb = new StringBuilder(n);
        for (int i = 0; i < n; i++) {
            sb.append(c);
        }
        return sb.toString();
    }
    
    // Méthode combine avec String
    public static String combineString(char a, char b, int n, int p) {
        return buildString(a, n) + buildString(b, p) + buildString(a, n);
    }
    
    // Méthode combine avec StringBuilder (plus efficace)
    public static String combineStringBuilder(char a, char b, int n, int p) {
        StringBuilder sb = new StringBuilder(2*n + p);
        sb.append(buildStringBuilder(a, n))
          .append(buildStringBuilder(b, p))
          .append(buildStringBuilder(a, n));
        return sb.toString();
    }
}
}
