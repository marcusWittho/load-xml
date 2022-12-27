package com.wittho.loadxml.service;

import com.wittho.loadxml.commons.NotFoundException;
import com.wittho.loadxml.model.Slc0001;
import com.wittho.loadxml.repository.Slc0001Repository;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import org.springframework.stereotype.Service;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

@Service
public class Slc0001Service {

  private final ReadXmlService readXmlService;
  private final LiquidService liquidService;
  private final Slc0001Repository slc0001Repository;

  public Slc0001Service(ReadXmlService readXmlService, LiquidService liquidService,
      Slc0001Repository slc0001Repository) {
    this.readXmlService = readXmlService;
    this.liquidService = liquidService;
    this.slc0001Repository = slc0001Repository;
  }

  public String buildSlc() {
    Document doc = readXmlService.docContent();
    NodeList slc0001 = doc.getElementsByTagName("SLC0001");

    Element slcElement = (Element) slc0001.item(0);

    Slc0001 slc = Slc0001.createSlc0001(
        slcElement.getElementsByTagName("CodMsg").item(0).getTextContent(),
        slcElement.getElementsByTagName("NumCtrlSLC").item(0).getTextContent(),
        slcElement.getElementsByTagName("ISPBIF").item(0).getTextContent(),
        slcElement.getElementsByTagName("TpInf").item(0).getTextContent(),
        slcElement.getElementsByTagName("DtHrSLC").item(0).getTextContent(),
        slcElement.getElementsByTagName("DtMovto").item(0).getTextContent()
    );

    liquidService.buildLiquid(slcElement, slc);

    slc0001Repository.save(slc);

    return "SisMsg carregado com sucesso.";
  }

  public List<Slc0001> getAll() {

    List<Slc0001> slc = slc0001Repository.findAll();

    if (slc.isEmpty()) {
      throw new NotFoundException("Nenhum Slc0001 foi encontrado.");
    }

    return slc;
  }

  public Slc0001 getById(String id) {

    Optional<Slc0001> slc = slc0001Repository.findById(UUID.fromString(id));

    if (slc.isEmpty()) {
      throw new NotFoundException(String.format("Registro com o id %s inexistente.", id));
    }

    return slc.get();
  }
}
