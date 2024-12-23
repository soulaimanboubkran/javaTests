package tests.api.view;

import tests.api.controller.dataService;
import tests.api.controller.writeService;
import tests.api.model.Carnet;

public class writeView {
   public static void main(String[] args) {
        
        try {
            
            String basePath = "C:\\Users\\soula\\OneDrive\\Desktop\\java\\tests\\api\\data.txt";
           Carnet carnet = new Carnet();
          new writeService().append(basePath, carnet);

          carnet.toString();
        } catch (Exception e) {
            System.err.println("An error occurred: " + e.getMessage());
        } finally {
       
        }
    }
}
