package Main.Service;

import Main.Models.Offer;
import Main.Place;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Service {
    public List<Offer> sortOfferListByPrice(List<Offer> liste) {
        return liste.stream()
                .sorted(( otherOffer,offer) -> compareVat(offer.getPrice()+offer.getPrice()*offer.getVat()/100,otherOffer.getPrice()+otherOffer.getPrice()*otherOffer.getVat()/100)

                ).toList();
    }

    public String topPlacesByIncome(List<Offer> liste) {
        Map.Entry<Place, Double> maxIncome = liste.stream()
                .collect(Collectors.groupingBy(Offer::getPlace, Collectors.summingDouble(Offer::getCost)))
                .entrySet().stream()
                .max(Map.Entry.comparingByValue())
                .orElseThrow(NullPointerException::new);

        return maxIncome.getKey() + ": " + maxIncome.getValue();
    }
    private int compareVat(double v, double v1) {
        if(v>v1)
            return 1;
        else
            if(v==v1)
                return 0;
            else
                return -1;

    }
}