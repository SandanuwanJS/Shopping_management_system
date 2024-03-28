/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cw12;

/**
 *
 * @author USER
 */
public class Clothes extends Product{
    private String productSize;
    private String productColour;

    public Clothes(String productId, String productName, int productNumberOfAvailableItems, double productPrice, String productSize, String productColour) {
        super(productId, productName, productNumberOfAvailableItems, productPrice);
        this.productSize = productSize;
        this.productColour = productColour;
    }

    public String getProductSize() {
        return productSize;
    }

    public void setProductSize(String productSize) {
        this.productSize = productSize;
    }

    public String getProductColour() {
        return productColour;
    }

    public void setProductColour(String productColour) {
        this.productColour = productColour;
    }
}
