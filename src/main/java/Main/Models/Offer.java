package Main.Models;

import Main.Place;

import java.util.Objects;

public class Offer {
    private int id;
    private String name;
    private double price;
    private double vat;
    private String address;
    private Place place;

    /**
     * Constructor for offer objects
     * @param id
     * @param name
     * @param price
     * @param vat
     * @param address
     * @param place
     */
    public Offer(int id, String name, double price, double vat, String address, Place place) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.vat = vat;
        this.address = address;
        this.place = place;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getVat() {
        return vat;
    }

    public void setVat(double vat) {
        this.vat = vat;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Place getPlace() {
        return place;
    }

    public void setPlace(Place place) {
        this.place = place;
    }

    public double getCost(){
        return price+vat*price/100;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Offer)) return false;
        Offer offer = (Offer) o;
        return id == offer.id && Double.compare(offer.price, price) == 0 && Double.compare(offer.vat, vat) == 0 && Objects.equals(name, offer.name) && Objects.equals(address, offer.address) && place == offer.place;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, price, vat, address, place);
    }

    @Override
    public String toString() {
        return "Offer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", vat=" + vat +
                ", address='" + address + '\'' +
                ", place=" + place +
                '}';
    }

    /**
     * String conversion with cost value
     * @return
     */
    public String toStringOut() {
        return "Offer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", cost=" + (price+vat*price/100) +
                ", vat=" + vat +
                ", address='" + address + '\'' +
                ", place=" + place +
                '}';
    }
}
