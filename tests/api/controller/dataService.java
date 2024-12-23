package tests.api.controller;
import java.io.*;
public class dataService {
     
    public void readFile(String name){
        try {
            String line;
            System.out.println("Contents of the file: " + name);
            File file = new File(name);

            if(file.exists()){
              Reader  fr = new FileReader(file);
              BufferedReader br = new BufferedReader(fr);
      
       
              while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
            }else{
                System.out.println(
                    "file does not exist!"
                );
            }
        } catch (Exception e) {
            // TODO: handle exception
        }
    }

    public void readFileByWord(String filePath) {
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            System.out.println("Reading file word by word:");
            while ((line = br.readLine()) != null) {
                // Split the line into words
                String[] words = line.split("\\s+");
                for (String word : words) {
                    System.out.println(word);
                }
            }
        } catch (IOException e) {
            System.err.println("Error reading the file word by word: " + e.getMessage());
        }
    }

    // Read file using a delimiter
    public void readFileByDelimiter(String filePath, String delimiter) {
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            System.out.println("Reading file by delimiter (" + delimiter + "):");
            while ((line = br.readLine()) != null) {
                // Split the line by the delimiter
                String[] parts = line.split(delimiter);
                for (String part : parts) {
                    System.out.println(part);
                }
            }
        } catch (IOException e) {
            System.err.println("Error reading the file by delimiter: " + e.getMessage());
        }
    }

    public void filterByCity(String filePath, String city) {
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            System.out.println("Filtering records by city: " + city);
            while ((line = br.readLine()) != null) {
                // Split the line by delimiter (comma in this case)
                String[] parts = line.split(",");
                if (parts.length == 5) {
                    String recordCity = parts[4].trim(); // Assuming city is the 5th column
                    if (recordCity.equalsIgnoreCase(city)) {
                        System.out.println(line);
                    }
                } else {
                    System.err.println("Invalid record format: " + line);
                }
            }
        } catch (IOException e) {
            System.err.println("Error reading the file: " + e.getMessage());
        }
    }
}
