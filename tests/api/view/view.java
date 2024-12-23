package tests.api.view;

import java.util.Scanner;
import tests.api.controller.service;

public class view {
    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        try {
            System.out.print("Enter directory name: ");
            String namePath = keyboard.nextLine();
            System.out.print("Enter directory newName: ");
            String newNamePath = keyboard.nextLine();

            // Base path
            String basePath = "C:\\Users\\soula\\OneDrive\\Desktop\\java\\tests\\";
            String fullPath = basePath + namePath;
            String newFullPath = basePath + newNamePath;
            // Call the service to create the directory
          // new service().createDir(fullPath);
     
          // System.out.println("Directory created at: " + fullPath);
          //  new service().properties(fullPath);
          //  new service().deleteDir(fullPath);
          new service().renameDir(fullPath,newFullPath);
        } catch (Exception e) {
            System.err.println("An error occurred: " + e.getMessage());
        } finally {
            keyboard.close();
        }
    }
}
