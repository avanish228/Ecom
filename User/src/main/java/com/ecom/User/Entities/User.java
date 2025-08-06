package com.ecom.User.Entities;

import jakarta.persistence.Entity;
import lombok.Data;

@Entity
@Data
public class User {
    int id;
    String name;
    String email;
}
