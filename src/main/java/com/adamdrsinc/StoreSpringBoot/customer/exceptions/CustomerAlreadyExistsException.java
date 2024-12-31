package com.adamdrsinc.StoreSpringBoot.customer.exceptions;

public class CustomerAlreadyExistsException extends RuntimeException {
  public CustomerAlreadyExistsException(String message) {
    super(message);
  }
}
