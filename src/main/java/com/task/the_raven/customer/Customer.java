package com.task.the_raven.customer;

import com.task.the_raven.customer.validation.constraint.ContainsChar;
import com.task.the_raven.customer.validation.constraint.LengthBetween;
import com.task.the_raven.customer.validation.constraint.PhoneNumber;
import com.task.the_raven.customer.validation.group.CreateGroup;
import com.task.the_raven.customer.validation.group.UpdateGroup;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

@Entity
@Data
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long created;

    private Long updated;

    @LengthBetween(min = 2, max = 50, groups = {UpdateGroup.class, CreateGroup.class})
    private String fullName;

    @LengthBetween(min = 2, max = 100, groups = CreateGroup.class)
    @ContainsChar(ch = '@', groups = CreateGroup.class)
    @Column(unique = true)
    private String email;

    @LengthBetween(min = 6, max = 14, groups = {UpdateGroup.class, CreateGroup.class})
    @PhoneNumber(groups = {UpdateGroup.class, CreateGroup.class})
    @NotEmpty(groups = UpdateGroup.class)
    private String phone;

    private Boolean isActive;

    public Customer() {
        this.isActive = true;
    }

}
