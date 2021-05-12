package com.spg.finalchallenge.repository;

import com.spg.finalchallenge.entity.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepository extends JpaRepository<Client, Long> {
    Client findById(long id);

    Client save(Client client);

    long count();
}
