/**
 * @author Nipun Lakshitha <nipunlakshithasilva1999@gmail.com>
 * @since 8/07/21
 */

package controller;

import Db.DBConnetion;
import Model.Customer;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class customerController {

    @FXML
    private TextField txtCustomerID;

    @FXML
    private TextField txtCustomerName;

    @FXML
    private TextField txtCustomerAddress;

    @FXML
    private TextField txtCustomerContact;

    @FXML
    private Button btnCustomerSubmit;



    @FXML
    void onClick(ActionEvent event) {


        String id=txtCustomerID.getText().toString();
        String name=txtCustomerName.getText().toString();
        String address= txtCustomerAddress.getText().toString();
        int contact= Integer.parseInt(txtCustomerContact.getText());


        boolean b = addCustomer(new Customer(id, name, address, contact));
        if (b) {
            JOptionPane.showMessageDialog(null, "Customer Added Successfully");
        } else {
            JOptionPane.showMessageDialog(null, "Customer Added fail");
        }

    }


    private boolean addCustomer(Customer customer) {
        boolean isCustomerAdded = false;
        try {
            Connection connection = DBConnetion.getInstance( ).getConnection( );
            String sql = "INSERT INTO customer VALUES(?,?,?,?)";

            PreparedStatement pstm = connection.prepareStatement(sql);
            pstm.setString(1, customer.getCustomerID( ));
            pstm.setString(2,customer.getCustomerName());
            pstm.setString(3, customer.getCustomerAddress( ));
            pstm.setInt(4, customer.getCustomerContact());

            isCustomerAdded = pstm.executeUpdate( ) > 0;
        } catch (SQLException ex) {

        }

        return isCustomerAdded;
    }
}
