/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package cw12;

/**
 *
 * @author USER
 */
public interface ShoppingManager {
    void addProduct(Product product);
    
    void deleteProduct(String productId);
    
    void printProductList();
    
    void saveInFile();
    
    void loadDataFromFile();
    
    void openGUI();
}
