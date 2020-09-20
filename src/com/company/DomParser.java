package com.company;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.net.URL;
import org.w3c.dom.*;


public class DomParser {
    DomParser(){
        getValute();
    }
    private void getValute(){
        try {
            String pre_apiURL = "http://www.cbr.ru/scripts/XML_daily.asp";
            URL url = new URL(pre_apiURL);
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder db = dbf.newDocumentBuilder();
            Document doc = db.parse(url.openStream());
            Element valuteCurs = doc.getDocumentElement();
            NodeList valuteList = valuteCurs.getChildNodes();
            for(int i=0;i<valuteList.getLength();i++){
                Node valute = valuteList.item(i);
                if(valute instanceof Element){
                    Element valuteElement = (Element)valute;
                    getChild(valuteElement);
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    private void getChild(Element valuteElement){
        Valute valuteObject = new Valute();
        NodeList valuteElementList = valuteElement.getChildNodes();
        for(int i=0;i<valuteElementList.getLength();i++){
            Node valuteProperty = valuteElementList.item(i);
            if(valuteProperty instanceof Element){
                Element property = (Element)valuteProperty;
                Text textNode = (Text)property.getFirstChild();
                String valut = textNode.getData().trim();
                if(property.getTagName().equals("NumCode"))
                    valuteObject.setNumCode(valut);
                else if (property.getTagName().equals("CharCode"))
                    valuteObject.setCharCode(valut);
                else if (property.getTagName().equals("Nominal"))
                    valuteObject.setNominal(valut);
                else if (property.getTagName().equals("Name"))
                    valuteObject.setName(valut);
                else if (property.getTagName().equals("Value"))
                    valuteObject.setValue(valut);
            }
        }
        if (valuteObject.getNumCode().equals("344")){
            System.out.println(valuteObject.getNominal());
            System.out.println(valuteObject.getName());
            System.out.println(valuteObject.getValue());
        }
    }
}
