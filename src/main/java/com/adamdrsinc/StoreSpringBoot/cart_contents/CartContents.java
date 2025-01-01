package com.adamdrsinc.StoreSpringBoot.cart_contents;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.Table;

@Entity
@IdClass(CartContentsId.class)
public class CartContents {
    @Id
    private Integer productID;
    @Id
    private Integer customerID;

    private Integer quantity;




    public Integer getProductID() {
        return productID;
    }

    public void setProductID(Integer productID) {
        this.productID = productID;
    }

    public Integer getCustomerID() {
        return customerID;
    }

    public void setCustomerID(Integer customerID) {
        this.customerID = customerID;
    }

    public Integer getQuantity() {return quantity;}

    public void setQuantity(Integer quantity){
        this.quantity = quantity;
    }
}
