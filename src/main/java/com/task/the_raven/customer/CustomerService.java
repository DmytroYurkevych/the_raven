package com.task.the_raven.customer;

import com.task.the_raven.exception.CustomerNotFoundException;
import jakarta.transaction.Transactional;
import java.util.List;
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

    public Customer getCustomer(Long id) {
        return customerRepository.findById(id)
                .orElseThrow(() -> new CustomerNotFoundException(id));
    }

    @Transactional
    public Customer updateCustomer(Long id, Customer newCustomer) {
        Customer customer = customerRepository.findById(id)
                .orElseThrow(() -> new CustomerNotFoundException(id));

        customer.setFullName(newCustomer.getFullName());
        customer.setPhone(newCustomer.getPhone());

        return customerRepository.saveAndFlush(customer);
    }

    public void deleteCustomer(Long id) {
        customerRepository.findById(id)
                .orElseThrow(() -> new CustomerNotFoundException(id))
                .setIsActive(false);
    }

}
