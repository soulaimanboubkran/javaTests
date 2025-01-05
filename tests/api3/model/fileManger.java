package tests.api3.model;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class fileManger {
    private static final String DIRECTORY_PATH = "C:\\data";
    private static final String FILE_NAME = "fichier.txt";
    private static final String[] NAMES = {
        "Hamdaoui Adil",
        "Salimi Hicham",
        "Zeroul Hasna",
        "Hakim Redouane"
    };


public boolean createDirectory(){
    File directory = new File(DIRECTORY_PATH);
    if(!directory.exists()){
        return directory.mkdir();
    }
    return false;
}

public boolean createFile(){
    File dir = new File(DIRECTORY_PATH);
    File[] contents = dir.listFiles();
    boolean fileExist = false;

    if (contents != null) {
        for(File file : contents){
            if(file.getName().equalsIgnoreCase(FILE_NAME)){
                fileExist = true;
                break;
            }
        }
    }

    if(!fileExist){
        File file = new File(DIRECTORY_PATH + "\\" + FILE_NAME);
        try {
            return file.createNewFile();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    return false;
}

public void writeFile() throws IOException{
    File file = new File(DIRECTORY_PATH + "\\" + FILE_NAME);
    if (file.exists()) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
            for (String name : NAMES) {
                writer.write(name);
                writer.newLine();
            }
        }
    }
}

    

}
