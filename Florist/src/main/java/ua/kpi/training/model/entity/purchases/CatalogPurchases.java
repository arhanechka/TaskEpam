package ua.kpi.training.model.entity.purchases;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by Anya on 31.05.2017.
 */
public class CatalogPurchases {
    public ArrayList<String[]> catalog;

    public CatalogPurchases(String fileName) {
        setCatalog(fileName);
    }

    public void setCatalog(String fileName) {
        try (Scanner scanner = new Scanner(new File(fileName))) {
            catalog = new ArrayList<String[]>();
            while (scanner.hasNextLine()) {
                String row = scanner.nextLine();
                String[] temp = row.split(" ");
                catalog.add(temp);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }

    public ArrayList<String[]> getCatalog() {
        return catalog;
    }
}
