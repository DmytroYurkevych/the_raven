package com.task.the_raven.customer;

import com.task.the_raven.customer.validation.group.CreateGroup;
import com.task.the_raven.customer.validation.group.UpdateGroup;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/customers")
@RequiredArgsConstructor
public class CustomerController {

    private final CustomerService customerService;

    @PostMapping
    public ResponseEntity<CustomerDTO> postCustomer(@RequestBody @Validated(CreateGroup.class) Customer customer) {
        CustomerDTO customerDTO = CustomerDTO.of(customerService.saveCustomer(customer));
        return new ResponseEntity<>(customerDTO, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<CustomerDTO>> getCustomers() {
        List<CustomerDTO> customerDTOs = customerService.getCustomers().stream()
                .map(CustomerDTO::of)
                .toList();

        return ResponseEntity.ok(customerDTOs);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CustomerDTO> getCustomer(@PathVariable Long id) {
        return ResponseEntity.ok(CustomerDTO.of(customerService.getCustomer(id)));
    }

    @PutMapping("/{id}")
    public ResponseEntity<CustomerDTO> updateCustomer(@PathVariable Long id,
                                                      @RequestBody @Validated(UpdateGroup.class) Customer customer) {
        CustomerDTO customerDTO = CustomerDTO.of(customerService.updateCustomer(id, customer));
        return ResponseEntity.ok(customerDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deleteCustomer(@RequestParam Long id) {
        customerService.deleteCustomer(id);
        return ResponseEntity.ok(HttpStatus.NO_CONTENT);
    }

}
