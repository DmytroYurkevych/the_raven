package com.task.the_raven.customer;

import jakarta.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CustomerService {

    private final CustomerRepository customerRepository;

    public Customer saveCustomer(Customer customer) {
        return customerRepository.save(customer);
    }

    public List<Customer> getCustomers() {
        return customerRepository.findAll();
    }

    public Optional<Customer> getCustomer(Long id) {
        return customerRepository.findById(id);
    }

    @Transactional
    public Customer updateCustomer(Long id, Customer customer) {
        Customer customer1 = customerRepository.findById(id).orElse(new Customer());

        customer1.setFullName(customer.getFullName());
        customer1.setPhone(customer.getPhone());

        customerRepository.save(customer1);

        return customer1;
    }

    public void deleteCustomer(Long id) {
        customerRepository.findById(id).ifPresent(customer1 -> customer1.setIsActive(false));
    }

}
