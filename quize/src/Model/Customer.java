package Model;

public class Customer {
    private String CustomerID;
    private String CustomerName;
    private String CustomerAddress;
    private int CustomerContact;

    public Customer(String id, String name, String address, int contact) {
    }

    public String getCustomerID() {
        return CustomerID;
    }

    public void setCustomerID(String customerID) {
        CustomerID = customerID;
    }

    public String getCustomerName() {
        return CustomerName;
    }

    public void setCustomerName(String customerName) {
        CustomerName = customerName;
    }

    public String getCustomerAddress() {
        return CustomerAddress;
    }

    public void setCustomerAddress(String customerAddress) {
        CustomerAddress = customerAddress;
    }

    public int getCustomerContact() {
        return CustomerContact;
    }

    public void setCustomerContact(int customerContact) {
        CustomerContact = customerContact;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "CustomerID='" + CustomerID + '\'' +
                ", CustomerName='" + CustomerName + '\'' +
                ", CustomerAddress='" + CustomerAddress + '\'' +
                ", CustomerContact=" + CustomerContact +
                '}';
    }
}
