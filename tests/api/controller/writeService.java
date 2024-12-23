package tests.api.controller;
import java.io.*;

import tests.api.model.Carnet;
public class writeService {
    public void append(String name,Carnet carnet){
        try {
            File file= new File(name);
            Writer fw = new FileWriter(file,true);
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write(String.join(",", carnet.getNom(),carnet.getAge(),carnet.getVille()));
            bw.newLine();

            bw.close();
            fw.close();
        } catch (Exception e) {
            // TODO: handle exception
        }
    }
}
