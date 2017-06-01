package ua.kpi.training.model.entity.flowers;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by Anya on 31.05.2017.
 */
public class CatalogFlowers {
    private static CatalogFlowers instance;
    public static ArrayList<String[]> catalogFlowers;

    private CatalogFlowers() {
    }

    public static CatalogFlowers getInstance() {
        setCatalogFlowers();
        if (instance == null) {
            return new CatalogFlowers();
        }

        return instance;
    }

    public static void setCatalogFlowers() {
        try  {
            catalogFlowers=new ArrayList<>();
            File file = new File("src/main/resources/catalog.txt");
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                String row = scanner.nextLine();
                String []temp = row.split(" ");
                catalogFlowers.add(temp);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }

    public ArrayList<String[]> getCatalogFlowers() {
        return catalogFlowers;
    }
}
