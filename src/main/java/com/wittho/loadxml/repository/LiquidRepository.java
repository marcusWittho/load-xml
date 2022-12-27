package com.wittho.loadxml.repository;

import com.wittho.loadxml.model.Liquid;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LiquidRepository extends JpaRepository<Liquid, UUID> {

}
