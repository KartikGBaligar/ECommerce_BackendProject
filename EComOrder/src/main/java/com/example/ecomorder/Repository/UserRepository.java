package com.example.ecomorder.Repository;

import com.example.ecomorder.Model.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {
}
