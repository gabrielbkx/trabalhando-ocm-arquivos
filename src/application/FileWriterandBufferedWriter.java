package application;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class FileWriterandBufferedWriter {
    public static void main(String[] args) {
        String [] lines = new String[] {"good morning","good afternoon","good night"};
        String caminho = "C:\\temp\\out.txt";
        try(BufferedWriter bw = new BufferedWriter(new FileWriter(caminho,true))){
            for (String line : lines) {
                bw.write(line);
                bw.newLine();
            }
        }catch (IOException e){
            e.printStackTrace();        }

    }
}
