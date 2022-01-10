package Main.Service;

import Main.Models.Offer;

import java.util.List;
import java.util.stream.Collectors;

public class Service {
    public List<Offer> sortOfferListByPrice(List<Offer> liste) {
        return liste.stream()
                .sorted((offer, otherOffer) -> {
                    if((offer.getPrice()+offer.getPrice()*offer.getVat())<(otherOffer.getPrice()+otherOffer.getPrice()*otherOffer.getVat()))
                        return 1;
                    else
                        return 0;
                }).toList();
    }
}
