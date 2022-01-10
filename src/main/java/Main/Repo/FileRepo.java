package Main.Repo;

import Main.Models.Offer;
import Main.Place;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class FileRepo {
    /**
     * reads Offer objects from file with character separator
     * @param fileName
     * @param character
     * @return
     * @throws IOException
     */
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

    /**
     * writes offer objects to file with total cost instead of price, with separator
     * @param fileName
     * @param liste
     * @param character
     * @throws IOException
     */
    public void writeToFile(String fileName, List<Offer> liste, String character) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(fileName));
        for (Offer offer : liste) {
            String line = offer.getId() + character + offer.getName() + character + offer.getCost() + character + offer.getVat() + character + offer.getAddress() + character + offer.getPlace();
            bufferedWriter.write(line);
            bufferedWriter.newLine();
        }

        bufferedWriter.close();
    }

    /**
     * writes statistic type objects (Map) to file with separator
     * @param fileName
     * @param liste
     * @param character
     * @throws IOException
     */
    public void writeToFileStatistics(String fileName, Map<Place,Double> liste, String character) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(fileName));
        for (Map.Entry<Place, Double> entry : liste.entrySet()) {
            String line = entry.getKey() + character + entry.getValue();
            bufferedWriter.write(line);
            bufferedWriter.newLine();
        }

        bufferedWriter.close();
    }


}
