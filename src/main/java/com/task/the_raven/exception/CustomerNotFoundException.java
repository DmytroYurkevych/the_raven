package com.task.the_raven.exception;

public class CustomerNotFoundException extends RuntimeException {

    public CustomerNotFoundException(Long id) {
        super("The customer with id '" + id + "' does not exist in our records");
    }

}
