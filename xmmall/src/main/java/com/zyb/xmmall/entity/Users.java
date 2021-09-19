package com.zyb.xmmall.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Users {
    private int id;
    private String phone;
    private String username;
    private String password;
    private String address;
}
