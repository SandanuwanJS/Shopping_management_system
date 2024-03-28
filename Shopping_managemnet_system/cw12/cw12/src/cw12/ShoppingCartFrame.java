package cw12;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.text.DecimalFormat;
import java.util.Map;

public class ShoppingCartFrame extends JFrame {
    private JTable cartTable;
    private JLabel totalLabel;
    private JLabel discountALabel;
    private JLabel discountBLabel;
    private JLabel finalTotalLabel;

    ShoppingCart shoppingCart;
    private int isExistingUser;

    public ShoppingCartFrame(ShoppingCart shoppingCart, int isExistingUser) {
        this.isExistingUser = isExistingUser;
        this.shoppingCart = shoppingCart;
        setTitle("Shopping Cart");
        setSize(600, 600);

        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("Product");
        model.addColumn("Quantity");
        model.addColumn("Price");

        cartTable = new JTable(model);

        JScrollPane scrollPane = new JScrollPane(cartTable);

        totalLabel = new JLabel("Total: ");
        discountALabel = new JLabel("Discount A: ");
        discountBLabel = new JLabel("Discount B: ");
        finalTotalLabel = new JLabel("Final Total: ");

        JPanel labelsPanel = new JPanel();
        labelsPanel.setLayout(new BoxLayout(labelsPanel, BoxLayout.Y_AXIS));
        labelsPanel.add(totalLabel);
        labelsPanel.add(discountALabel);
        labelsPanel.add(discountBLabel);
        labelsPanel.add(finalTotalLabel);

        JPanel mainPanel = new JPanel(new BorderLayout());
        mainPanel.add(scrollPane, BorderLayout.CENTER);
        mainPanel.add(labelsPanel, BorderLayout.SOUTH);

        add(mainPanel);

        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        updateShoppingCartTable(shoppingCart);
    }

    private Clothes getClothesById(String productId) {
        for (Map.Entry<Product, Integer> entry : shoppingCart.getCartItems().entrySet()) {
            Product product = entry.getKey();

            if (product instanceof Clothes && product.getProductId().equals(productId)) {
                return (Clothes) product;
            }
        }
        return null;
    }

    private Electronic getElectronicById(String productId) {
        for (Map.Entry<Product, Integer> entry : shoppingCart.getCartItems().entrySet()) {
            Product product = entry.getKey();

            if (product instanceof Electronic && product.getProductId().equals(productId)) {
                return (Electronic) product;
            }
        }
        return null;
    }

    public void updateShoppingCartTable(ShoppingCart shoppingCart) {
        DefaultTableModel model = (DefaultTableModel) cartTable.getModel();
        model.setRowCount(0);

        double total = 0;

        for (Map.Entry<Product, Integer> entry : shoppingCart.getCartItems().entrySet()) {
            Product product = entry.getKey();
            int quantity = entry.getValue();
            double price = product.getProductPrice();
            String productVals = "";
            if (product instanceof Electronic) {
                Electronic electronic = getElectronicById(product.getProductId());
                productVals = electronic.getProductId() + " " + electronic.getProductName() + " " + electronic.getProductBrand() + " " + electronic.getProductWarrantyPeriod();
            } else if (product instanceof Clothes) {
                Clothes clothes = getClothesById(product.getProductId());
                productVals = clothes.getProductId() + " " + clothes.getProductName() + " " + clothes.getProductSize() + " " + clothes.getProductColour();
            }

            model.addRow(new Object[]{productVals, quantity, price * quantity});
            total += price * quantity;
        }

        double discountA = calculateDiscountA(total);
        double discountB = calculateDiscountB(shoppingCart, total);
        double finalTotal = total - discountA - discountB;

        DecimalFormat decimalFormat = new DecimalFormat("#.##"); // Pattern for two decimal places

        totalLabel.setText("Total: " + decimalFormat.format(total));
        discountALabel.setText("First Purchase Discount (10%): " + decimalFormat.format(discountA));
        discountBLabel.setText("Three Items in the Same Category Discount (20%): " + decimalFormat.format(discountB));
        finalTotalLabel.setText("Final Total: " + decimalFormat.format(finalTotal));
    }

    private double calculateDiscountA(double total) {
        if (isExistingUser == 1){
            return 0;
        }
        return total * 0.1;
    }

    private double calculateDiscountB(ShoppingCart shoppingCart, double total) {
        int itemCountOnElectronics = 0;
        int itemCountOnClothes = 0;

        for (Map.Entry<Product, Integer> entry : shoppingCart.getCartItems().entrySet()) {
            Product product = entry.getKey();

            if (product instanceof Electronic) {
                itemCountOnElectronics += entry.getValue();
            } else if (product instanceof Clothes) {
                itemCountOnClothes += entry.getValue();
            }
        }

        if(itemCountOnElectronics > 2 || itemCountOnClothes > 2){
            return total*0.2;
        }
        return 0;
    }
}
