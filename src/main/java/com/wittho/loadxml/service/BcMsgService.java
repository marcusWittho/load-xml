package com.wittho.loadxml.service;

import com.wittho.loadxml.model.BcMsg;
import com.wittho.loadxml.model.GrupoSeq;
import com.wittho.loadxml.repository.BcMsgRepository;
import org.springframework.stereotype.Service;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

@Service
public class BcMsgService {

  private final ReadXmlService readXmlService;
  private final GrupoSeqService grupoSeqService;
  private final BcMsgRepository bcMsgRepository;

  public BcMsgService(ReadXmlService readXmlService, GrupoSeqService grupoSeqService,
      BcMsgRepository bcMsgRepository) {
    this.readXmlService = readXmlService;
    this.grupoSeqService = grupoSeqService;
    this.bcMsgRepository = bcMsgRepository;
  }

  public String buildBcMsg() {

    try {
      Document doc = readXmlService.docContent();

      NodeList bcMsg = doc.getChildNodes();

      Element bcMsgElement = (Element) bcMsg.item(0);

      BcMsg bcMsgInstance = BcMsg.createBcMsgInstance(
          bcMsgElement.getElementsByTagName("IdentdEmissor").item(0).getTextContent(),
          bcMsgElement.getElementsByTagName("IdentdDestinatario").item(0).getTextContent(),
          bcMsgElement.getElementsByTagName("DomSist").item(0).getTextContent(),
          bcMsgElement.getElementsByTagName("NUOp").item(0).getTextContent(),
          null
      );

      GrupoSeq grupoSeq = grupoSeqService.buildGrupoService(bcMsgElement, bcMsgInstance);
      bcMsgInstance.setGrupoSeq(grupoSeq);

      bcMsgRepository.save(bcMsgInstance);

      return "BcMsg carregado com sucesso.";
    } catch (Exception e) {
      e.printStackTrace();
    }

    return null;
  }
}
