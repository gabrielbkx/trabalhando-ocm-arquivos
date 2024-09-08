package application;

import entities.Product;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);

        try (Scanner sc = new Scanner(System.in)) {

            List<Product> list = new ArrayList<>();
            System.out.println("Enter file path: ");
            String sourceFilestr = sc.nextLine();

            File file = new File(sourceFilestr);

            String sourceFolderstr = file.getParent(); // O método getParent() pertence à classe File.
            // Ele ignora o nome do arquivo nos mostrando o caminho dele apenas

            boolean success = new File(sourceFolderstr + "\\out").mkdir(); // Método mkdir() é o que usamos
            // para criar um novo diretório (pasta)
            String targetFilestr = sourceFolderstr + "\\out\\summary.csv";

            try (BufferedReader br = new BufferedReader(new FileReader(sourceFilestr))) {

                String itemCsv = br.readLine();
                while (itemCsv != null) {
                    String [] fields = itemCsv.split(",");
                    String name = fields[0];
                    double price = Double.parseDouble(fields[1]);
                    int quantity = Integer.parseInt(fields[2]);
                    list.add(new Product(name,quantity,price));
                    itemCsv = br.readLine();
                }

                try(BufferedWriter bw = new BufferedWriter(new FileWriter(targetFilestr))) {
                    for (Product item: list){
                        bw.write(item.getName() + ", " + String.format("%.2f",item.totalValue()));
                        bw.newLine();
                    }
                    System.out.println(targetFilestr + "Created");
                }catch (IOException e){
                    System.out.println("error: " + e.getMessage());
                }

            } catch (IOException e) {
                System.out.println("Error reading file: " + e.getMessage());
            }
        }
    }
}
