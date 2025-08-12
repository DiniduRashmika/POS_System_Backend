package com.possystem.POS_System.repo;

import com.possystem.POS_System.entity.CustomerContactNumber;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

@Repository
@EnableJpaRepositories
public interface CustomerContactNumberRepo extends JpaRepository<CustomerContactNumber,Integer> {
}
