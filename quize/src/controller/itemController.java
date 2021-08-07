/**
 * @author Nipun Lakshitha <nipunlakshithasilva1999@gmail.com>
 * @since 8/07/21
 */

package controller;

import Db.DBConnetion;
import Model.Item;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class itemController {

    @FXML
    private TextField txtItemID;

    @FXML
    private TextField txtItemName;

    @FXML
    private TextField txtItemQTY;

    @FXML
    private TextField txtItemPrice;

    @FXML
    private TextField txtItemDiscount;

    @FXML
    private Button btnItemSubmit;

    @FXML
    void btnOnclick(ActionEvent event) {
        String itemID=txtItemID.getText();
        String itemName=txtItemName.getText();
        int QTY=Integer.parseInt(txtItemQTY.getText());
        double itemPrice=Double.parseDouble(txtItemPrice.getText());
        double itemDiscount=Double.parseDouble(txtItemDiscount.getText());

        boolean b=addItem(new Item(itemID,itemName,QTY,itemPrice,itemDiscount));
        if (b) {
            JOptionPane.showMessageDialog(null, "Item Added Successfully");
        } else {
            JOptionPane.showMessageDialog(null, "Item Added fail");
        }
    }

    private boolean addItem(Item item) {
        boolean isItemAdded = false;

        try {
            Connection connection = DBConnetion.getInstance().getConnection();
            String sql = "INSERT INTO item VALUES(?,?,?,?,?)";
            PreparedStatement pstm = connection.prepareStatement(sql);
            pstm.setObject(1, item.getItemID());
            pstm.setObject(2, item.getItemName());
            pstm.setObject(3, item.getItemQTY());
            pstm.setObject(4, item.getItemPrice());
            pstm.setObject(5, item.getItemDiscount());

            isItemAdded = pstm.executeUpdate() > 0;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.toString());

        }

        return isItemAdded;

    }
}
