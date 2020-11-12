/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nhap;

/**
 *
 * @author ASUS
 */
public class Product implements Comparable<Product>{
    private String id;
    private String name;
    protected String price;

    public Product() {
        this.id = "No ID";
        this.name = "No name";
        this.price = "0";
    }

    public Product(String id, String name, String price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Xe{ " + "Id : " + id + "; Dòng xe: " + name + "; Giá= " + price + " }";
    }

    @Override
    public int compareTo(Product o) {
        return this.getId().compareTo(o.getId());
    }
}
