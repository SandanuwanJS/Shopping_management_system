/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cw12;

//import java.io.Serializable;
//import java.util.Iterator;

/**
   private String brand;
 *
 * @author USER
 */
public class Electronic extends Product {
    
    private String productBrand;
    private String productWarrantyPeriod;

    public Electronic(String productId, String productName, int productNumberOfAvailableItems, double productPrice, String productBrand, String productWarrantyPeriod) {
        super(productId, productName, productNumberOfAvailableItems, productPrice);
        this.productBrand = productBrand;
        this.productWarrantyPeriod = productWarrantyPeriod;
    }

    public String getProductBrand() {
        return productBrand;
    }

    public void setProductBrand(String productBrand) {
        this.productBrand = productBrand;
    }

    public String getProductWarrantyPeriod() {
        return productWarrantyPeriod;
    }

    public void setProductWarrantyPeriod(String productWarrantyPeriod) {
        this.productWarrantyPeriod = productWarrantyPeriod;
    }
}
