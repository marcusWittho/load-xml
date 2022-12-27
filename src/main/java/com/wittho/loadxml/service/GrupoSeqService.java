package com.wittho.loadxml.service;

import com.wittho.loadxml.commons.NotFoundException;
import com.wittho.loadxml.model.BcMsg;
import com.wittho.loadxml.model.GrupoSeq;
import com.wittho.loadxml.repository.GrupoSeqRepository;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import org.springframework.stereotype.Service;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

@Service
public class GrupoSeqService {

  private final GrupoSeqRepository grupoSeqRepository;

  public GrupoSeqService(GrupoSeqRepository grupoSeqRepository) {
    this.grupoSeqRepository = grupoSeqRepository;
  }

  public GrupoSeq buildGrupoSeq(Element bcMsgElement, BcMsg bcMsg) {

    NodeList grupoSeq = bcMsgElement.getElementsByTagName("Grupo_Seq");

    Element grupoSeqElement = (Element) grupoSeq.item(0);

    GrupoSeq grupoSeqInstance = GrupoSeq.createGrupoSeqInstance(
        grupoSeqElement.getElementsByTagName("NumSeq").item(0).getTextContent(),
        grupoSeqElement.getElementsByTagName("IndrCont").item(0).getTextContent(),
        bcMsg
    );

    bcMsg.setGrupoSeq(grupoSeqInstance);

    return grupoSeqInstance;
  }

  public List<GrupoSeq> getAll() {

    List<GrupoSeq> grupoSeqList = grupoSeqRepository.findAll();

    if (grupoSeqList.isEmpty()) {
      throw new NotFoundException("Nenhum grupoSeq foi encontrado.");
    }

    return grupoSeqList;
  }

  public GrupoSeq getById(String id) {

    Optional<GrupoSeq> grupoSeqById = grupoSeqRepository.findById(UUID.fromString(id));

    if (grupoSeqById.isEmpty()) {
      throw new NotFoundException(String.format("Registro com o id %s inexistente.", id));
    }

    return grupoSeqById.get();
  }
}
