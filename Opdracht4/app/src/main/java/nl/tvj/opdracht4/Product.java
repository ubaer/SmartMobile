package nl.tvj.opdracht4;

/**
 * Created by Kevin on 24-9-2015.
 */
public class Product {
   private String Naam;
   private String Prijs;
    public Product(String naam, String prijs){
        Naam = naam;
        Prijs = prijs;
    }
    public String toString(){
        return Naam + " Prijs: " + Prijs;
    }
    public String toOutput(){
        return Naam + "!" + Prijs;
    }
}
