package com.techmaster.wlminus.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Customer {
    private Integer id;
    private String name;
    private String address;
    private String tel;
}
