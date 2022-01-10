package Main;

import Main.Models.Offer;
import Main.Repo.FileRepo;
import Main.Service.Service;

import java.io.IOException;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        FileRepo fileRepo = new FileRepo();

        Service service = new Service();

        List<Offer> offers;
        List<Offer> sortedOffers;

        {
            try {
                offers = fileRepo.readFromFile("offern.txt", "&");
                for(Offer offer:offers){
                    System.out.println(offer.toString());
                }
                sortedOffers=service.sortOfferListByPrice(offers);
                for(Offer offer:sortedOffers){
                    System.out.println(offer.toStringOut());
                }

                System.out.println(service.topPlacesByIncome(offers));
                fileRepo.writeToFile("kundensortiert.txt",sortedOffers, "&");
                fileRepo.writeToFileStatistics("statistik.txt",service.topPlacesByIncome(offers), ":");

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }



}
