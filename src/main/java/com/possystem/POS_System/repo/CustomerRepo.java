package com.possystem.POS_System.repo;

import com.possystem.POS_System.dto.CustomerDTO;
import com.possystem.POS_System.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

@Repository
@EnableJpaRepositories
public interface CustomerRepo extends JpaRepository<Customer,Integer> {
}
