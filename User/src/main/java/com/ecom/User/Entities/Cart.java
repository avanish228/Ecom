package com.ecom.User.Entities;


import jakarta.persistence.Entity;
import lombok.Data;

@Entity
@Data
public class Cart {

    int id;


    User user;


}
