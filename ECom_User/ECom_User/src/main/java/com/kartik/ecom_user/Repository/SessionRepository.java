package com.kartik.ecom_user.Repository;

import com.kartik.ecom_user.Models.Session;
import jakarta.persistence.Id;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SessionRepository extends JpaRepository<Session, Long> {
    public Optional<Session> findByUserIdAndToken(Long userId, String token);

}
