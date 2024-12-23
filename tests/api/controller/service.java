package tests.api.controller;
import java.io.*;
public class service {
    public void createFile(String name){
        try {
            File f = new File(name);
            if (f.exists() == false){
                f.createNewFile();
            }
        } catch (Exception e) {
            // TODO: handle exception
        }
    }
    public void createDir(String name){
        try {
            File f = new File(name);
            if (f.exists() == false){
                f.mkdirs();
            }
        } catch (Exception e) {
            // TODO: handle exception
        }
    }
    public void properties(String name){
        try {
            File f = new File(name);
            if(f.exists() == true){
               System.out.println("name: "+f.getName());
               System.out.println("parent: "+f.getParent());
            }
        } catch (Exception e) {
            // TODO: handle exception
        }
    }
    public void deleteDir(String name){
        try {
            File f = new File(name);
            if(f.exists() == true){
               f.delete();
               System.out.println("deleted");
            }
        } catch (Exception e) {
            // TODO: handle exception
        }
    }
    public boolean renameDir(String name, String newName) {
        try {
            File f1 = new File(name);
            File f2 = new File(newName);
            if (f1.exists()) {
                if (f1.renameTo(f2)) {
                    return true;
                } else {
                    System.out.println("Failed to rename directory. Check permissions or if the destination exists.");
                }
            } else {
                System.out.println("Source directory does not exist: " + name);
            }
        } catch (Exception e) {
            System.out.println("Error while renaming directory: " + e.getMessage());
        }
        return false;
    }
}
