package Main.Repo;

import Main.Models.Offer;
import Main.Place;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileRepo {
    public List<Offer> readFromFile(String fileName, String character) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName));
        String line = bufferedReader.readLine();
        String[] attributes;
        Offer offer;
        List<Offer> listeTiere = new ArrayList<>();
        while (line != null) {
            attributes = line.split(character);
            offer = new Offer(Integer.parseInt(attributes[0]), attributes[1],Double.parseDouble(attributes[2]), Double.parseDouble(attributes[3]),attributes[4],Place.valueOf(attributes[5]));
            listeTiere.add(offer);

            line = bufferedReader.readLine();
        }

        return listeTiere;
    }
}
