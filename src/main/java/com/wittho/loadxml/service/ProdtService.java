package com.wittho.loadxml.service;

import com.wittho.loadxml.commons.NotFoundException;
import com.wittho.loadxml.model.Liquid;
import com.wittho.loadxml.model.Prodt;
import com.wittho.loadxml.model.Slc0001;
import com.wittho.loadxml.repository.ProdtRepository;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import org.springframework.stereotype.Service;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

@Service
public class ProdtService {

  private final LiquidProdtService liquidProdtService;
  private final ProdtRepository prodtRepository;

  public ProdtService(LiquidProdtService liquidProdtService, ProdtRepository prodtRepository) {
    this.liquidProdtService = liquidProdtService;
    this.prodtRepository = prodtRepository;
  }

  public void buildProdt(Element liquidElement, Liquid liquid, Slc0001 slc) {
    NodeList prodtElement = liquidElement.getElementsByTagName("Grupo_SLC0001_Prodt");

    for (short i = 0; i < prodtElement.getLength(); i++) {
      Node node = prodtElement.item(i);
      Prodt prodtInstance = Prodt.createProdtInstance(null);

      if (node.getNodeType() == Node.ELEMENT_NODE) {
        Element element = (Element) node;

        prodtInstance = Prodt.createProdtInstance(
            element.getElementsByTagName("CodProdt").item(0).getTextContent()
        );

        liquidProdtService.buildLiquidProdt(prodtInstance, element);
      }

      prodtInstance.setLiquid(liquid);
      liquid.addProdt(prodtInstance);
      liquid.setSlc0001(slc);
      slc.addLiquid(liquid);
    }
  }

  public List<Prodt> getAll() {

    List<Prodt> prodtList = prodtRepository.findAll();

    if (prodtList.isEmpty()) {
      throw new NotFoundException("Nenhum Prodt foi encontrado.");
    }

    return prodtList;
  }

  public Prodt getById(String id) {

    Optional<Prodt> prodt = prodtRepository.findById(UUID.fromString(id));

    if (prodt.isEmpty()) {
      throw new NotFoundException(String.format("Registro com o id %s inexistente.", id));
    }

    return prodt.get();
  }
}
