package com.techmaster.wlminus.springboot1.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "Todo")
public class Todo {
    @Id
    private Integer id;
    private String title;
    private Boolean status;

    @JoinColumn(name = "customer_id")
    @OneToMany(fetch = FetchType.EAGER)
    private Customer customer;
}
