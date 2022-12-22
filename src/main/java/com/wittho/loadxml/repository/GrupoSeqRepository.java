package com.wittho.loadxml.repository;

import com.wittho.loadxml.model.GrupoSeq;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GrupoSeqRepository extends JpaRepository<GrupoSeq, UUID> {

}
