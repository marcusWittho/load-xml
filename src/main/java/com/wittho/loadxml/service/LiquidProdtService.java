package com.wittho.loadxml.service;

import com.wittho.loadxml.model.LiquidProdt;
import com.wittho.loadxml.model.Prodt;
import org.springframework.stereotype.Service;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

@Service
public class LiquidProdtService {

  public LiquidProdt buildLiquidProdt(Prodt prodt, Element element) {
    NodeList liquidProdtElement = element.getElementsByTagName("Grupo_SLC0001_LiquidProdt");
    LiquidProdt newLiquidProdt = null;

    for (short i = 0; i < liquidProdtElement.getLength(); i++) {
      newLiquidProdt = LiquidProdt.createLiquidProdtInstance(
          element.getElementsByTagName("IdentdLinhaBilat").item(i).getTextContent(),
          element.getElementsByTagName("TpDeb_Cred").item(i).getTextContent(),
          element.getElementsByTagName("ISPBIFCredtd").item(i).getTextContent(),
          element.getElementsByTagName("ISPBIFDebtd").item(i).getTextContent(),
          Double.parseDouble(
              element.getElementsByTagName("VlrLanc").item(i).getTextContent()),
          element.getElementsByTagName("CNPJNLiqdantDebtd").item(i).getTextContent(),
          element.getElementsByTagName("NomCliDebtd").item(i).getTextContent(),
          element.getElementsByTagName("CNPJNLiqdantCredtd").item(i).getTextContent(),
          element.getElementsByTagName("NomCliCredtd").item(i).getTextContent(),
          element.getElementsByTagName("TpTranscSLC").item(i).getTextContent()
      );

      newLiquidProdt.setProdt(prodt);
      prodt.addLiquidProdt(newLiquidProdt);
    }

    return newLiquidProdt;
  }
}
