package application;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ManipulandoPastas {
    public static void main(String[] args) {

        try (Scanner sc = new Scanner(System.in)) {

            System.out.println("Digite um caminho: ");
            String pasta = sc.nextLine();
            File caminho = new File(pasta);
            File[] folders = caminho.listFiles(File::isFile);
            System.out.println("Folders");

            for (File folder : folders) {
                System.out.println(folder);
            }
            boolean sucess = new File(pasta + "\\pastaNova").mkdir();
            System.out.println("Pasta criada com sucesso " + sucess);

        }
    }
}
