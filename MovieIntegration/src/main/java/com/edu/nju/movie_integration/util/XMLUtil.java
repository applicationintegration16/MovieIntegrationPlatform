package com.edu.nju.movie_integration.util;

import net.sf.json.xml.XMLSerializer;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.*;
import java.util.Map;

/**
 * @Author: py
 * @Date: 2019-05-12 14:28
 * @Version 1.0
 */
public class XMLUtil {
    /**
     * 获取一个XMLDocument对象
     * @return XMLDocument
     */
    public static Document createXml(){
        DocumentBuilderFactory documentBuilderFactory=DocumentBuilderFactory.newInstance();
        try {
            DocumentBuilder builder=documentBuilderFactory.newDocumentBuilder();
            Document document=builder.newDocument();
            document.setXmlStandalone(false);
            return document;
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 给Document添加节点
     * @param name 节点名
     * @param property 属性集合
     */
    public static void addElement(Document document,String name,Map<String,Object> property){
        Element element=document.createElement(name);
        for(String key:property.keySet()){
            Element temp=document.createElement(key);
            temp.setTextContent(property.get(key)+"");
            element.appendChild(temp);
        }
        document.appendChild(element);
    }

    /**
     * XML写入本地
     * @param name 文件名
     */
    public static void writeXml(Document document,String name) {
        TransformerFactory factory = TransformerFactory.newInstance();

        Transformer transformer = null;
        try {
            transformer = factory.newTransformer();
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            transformer.transform(new DOMSource(document), new StreamResult(new File(name + ".xml")));
        } catch (TransformerException e) {
            e.printStackTrace();
        }
    }

    /**
     * xml转json字符串
     * @param filePath 文件路径
     * @return json字符串
     */
    public static String xml2json(String filePath) {
        File file=new File(filePath);
        String content="";
        try {
            FileReader fileReader=new FileReader(file);
            BufferedReader reader=new BufferedReader(fileReader);
            String temp;
            while((temp=reader.readLine())!=null){
                content+=temp;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        XMLSerializer xmlSerializer = new XMLSerializer();
        return xmlSerializer.read(content).toString();
    }



}
