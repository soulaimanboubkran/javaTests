package tests.api.view;



import tests.api.controller.dataService;


public class dataView {
    public static void main(String[] args) {
        
        try {
            
            String basePath = "C:\\Users\\soula\\OneDrive\\Desktop\\java\\algos\\tree\\diff.txt";
           
          new dataService().readFile(basePath);
        } catch (Exception e) {
            System.err.println("An error occurred: " + e.getMessage());
        } finally {
       
        }
    }
}
