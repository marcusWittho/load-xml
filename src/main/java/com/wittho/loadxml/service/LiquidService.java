package com.wittho.loadxml.service;

import com.wittho.loadxml.commons.NotFoundException;
import com.wittho.loadxml.model.Liquid;
import com.wittho.loadxml.model.Slc0001;
import com.wittho.loadxml.repository.LiquidRepository;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import org.springframework.stereotype.Service;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

@Service
public class LiquidService {

  private final ProdtService prodtService;
  private final LiquidRepository liquidRepository;
  public LiquidService(ProdtService prodtService, LiquidRepository liquidRepository) {
    this.prodtService = prodtService;
    this.liquidRepository = liquidRepository;
  }

  public void buildLiquid(Element slcElement, Slc0001 slc) {
    NodeList liquidList = slcElement.getElementsByTagName("Grupo_SLC0001_Liquid");

    Element liquidElement = (Element) liquidList.item(0);

    Liquid liquidInstance = Liquid.createLiquidInstance(
        liquidElement.getElementsByTagName("DtLiquid").item(0).getTextContent(),
        liquidElement.getElementsByTagName("NumSeqCicloLiquid").item(0).getTextContent()
    );

    prodtService.buildProdt(liquidElement, liquidInstance, slc);
  }

  public List<Liquid> getAll() {

    List<Liquid> liquidList = liquidRepository.findAll();

    if (liquidList.isEmpty()) {
      throw new NotFoundException("Nenhum Liquid foi encontrado.");
    }

    return liquidList;
  }

  public Liquid getById(String id) {

    Optional<Liquid> liquid = liquidRepository.findById(UUID.fromString(id));

    if (liquid.isEmpty()) {
      throw new NotFoundException(String.format("Registro com o id %s inexistente.", id));
    }

    return liquid.get();
  }
}
