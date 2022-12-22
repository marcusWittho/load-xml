package com.wittho.loadxml.repository;

import com.wittho.loadxml.model.BcMsg;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BcMsgRepository extends JpaRepository<BcMsg, UUID> {

}
