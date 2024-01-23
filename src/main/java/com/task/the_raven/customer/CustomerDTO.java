package com.task.the_raven.customer;

public record CustomerDTO(Long id, String fullName, String email, String phone) {

    public static CustomerDTO of(Customer customer) {
        return new CustomerDTO(customer.getId(), customer.getFullName(), customer.getEmail(), customer.getPhone());
    }

}
