package com.TIDDEV.mhn.service.Repositories;

import com.TIDDEV.mhn.service.model.CustomerCheck;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CheckRepository extends JpaRepository<CustomerCheck , Long> {
}
