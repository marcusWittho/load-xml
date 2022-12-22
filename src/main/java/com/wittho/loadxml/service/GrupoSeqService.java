package com.wittho.loadxml.service;

import com.wittho.loadxml.model.BcMsg;
import com.wittho.loadxml.model.GrupoSeq;
import org.springframework.stereotype.Service;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

@Service
public class GrupoSeqService {

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
}
