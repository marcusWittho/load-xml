package com.wittho.loadxml.service;

import java.io.File;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.springframework.stereotype.Service;
import org.w3c.dom.Document;

@Service
public class ReadXmlService {

  public Document docContent() {
    try {
      String curDir = System.getProperty("user.dir");

      File file = new File(curDir + "/xml/SLC0001-modelo.xml");

      DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();

      DocumentBuilder db = dbf.newDocumentBuilder();

      return db.parse(file);
    } catch (Exception e) {
      e.printStackTrace();
    }

    return null;
  }
}
