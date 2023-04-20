package com.fullstack_imenik.Imenik.repository;
import com.fullstack_imenik.Imenik.model.user;
import org.apache.catalina.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<user,Long> {
}
