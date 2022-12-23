package com.wittho.loadxml.repository;

import com.wittho.loadxml.model.Prodt;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProdtRepository extends JpaRepository<Prodt, UUID> {

}
