package nordicwh.basiccommerce.controller;

import nordicwh.basiccommerce.model.Product;

import java.util.ArrayList;
import java.util.List;

public class Products {

    private List<Product> listProduct = new ArrayList<>();

    public Products(Product product) {
        insertProduct(product);
    }

    public Products(Products listProduct) {
        this.listProduct = (List<Product>) listProduct;
    }

    public boolean insertProduct (Product product){
        return listProduct.add(product);
    }

    public boolean removeProduct (Product product){
        return listProduct.remove(product);
    }

    public double totalValue (){
        double totalValue = 0;
        for(int i = 0; i == listProduct.size(); i++){
            totalValue =+ listProduct.get(i).getPrice();
        }
        return totalValue;
    }

}
