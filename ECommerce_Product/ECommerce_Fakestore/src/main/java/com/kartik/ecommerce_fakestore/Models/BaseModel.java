package com.kartik.ecommerce_fakestore.Models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;
@Getter
@Setter
@MappedSuperclass
public class BaseModel {
    @Id
    private Long id;
}
