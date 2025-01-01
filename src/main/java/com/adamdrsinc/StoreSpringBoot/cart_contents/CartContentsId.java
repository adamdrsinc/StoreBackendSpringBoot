package com.adamdrsinc.StoreSpringBoot.cart_contents;

import com.adamdrsinc.StoreSpringBoot.cart.Cart;

import java.io.Serializable;
import java.util.Objects;

public class CartContentsId implements Serializable{
     Integer productID;
     Integer customerID;

     public CartContentsId(){

     }

     public CartContentsId(Integer product_ID, Integer customer_ID, Integer quantity){
          this.productID = product_ID;
          this.customerID = customer_ID;
     }

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


     @Override
     public boolean equals(Object o) {
          if (this == o) return true;
          if (o == null || getClass() != o.getClass()) return false;
          CartContentsId that = (CartContentsId) o;
          return Objects.equals(productID, that.productID) && Objects.equals(customerID, that.customerID);
     }

     @Override
     public int hashCode() {
          return Objects.hash(productID, customerID);
     }
}
