package com.wittho.loadxml.service;

import com.wittho.loadxml.model.Liquid;
import com.wittho.loadxml.model.Prodt;
import org.springframework.stereotype.Service;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

@Service
public class ProdtService {

  private final LiquidProdtService liquidProdtService;

  public ProdtService(LiquidProdtService liquidProdtService) {
    this.liquidProdtService = liquidProdtService;
  }

  public void buildProdt(Element liquidElement, Liquid liquid) {
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
    }
  }
}
