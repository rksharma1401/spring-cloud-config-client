package learn.springcloud.configclient.dao;


import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import learn.springcloud.configclient.model.User;

public interface UserRepo extends JpaRepository<User, Integer> {
    Optional<User> findByUserName(String userName);
}