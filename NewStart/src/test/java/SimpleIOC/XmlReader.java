package SimpleIOC;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.*;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class XmlReader {
    private Map<String,Object>  registry = new HashMap<>();

    public XmlReader(String context){
        parseXmlReader(context);
    }

    private void parseXmlReader(String context) {
        Class beanClass = null;
        try {
            File file = new File(context);
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder docBuilder = factory.newDocumentBuilder();
            Document doc = docBuilder.parse(file);
            Element root = doc.getDocumentElement();
            NodeList nodes = root.getChildNodes();
            for (int i = 0; i < nodes.getLength(); i++) {
                Node node = nodes.item(i);
                if(node instanceof Element){
                    Element element = (Element)node;
                    String id = element.getAttribute("id");
                    String className = element.getAttribute("class");
                    beanClass = Class.forName(className);
                    Object bean = beanClass.newInstance();
                    NodeList nodeList = element.getElementsByTagName("property");
                    for (int j = 0; j < nodeList.getLength(); j++) {
                        Node propertyNode = nodeList.item(j);
                        Element propertyElementNode = (Element) propertyNode;
                        String name = propertyElementNode.getAttribute("name");
                        String value = propertyElementNode.getAttribute("value");
                        Field declaredField = bean.getClass().getDeclaredField(name);
                        declaredField.setAccessible(true);
                        if(value!=null)
                            declaredField.set(bean,value);
                        else {
                            String ref = propertyElementNode.getAttribute("ref");
                            Objects.requireNonNull(ref);
                            declaredField.set(bean,getBean(ref));
                        }
                    }
                    registryBean(id,bean);
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("找不到对应的配置文件");
        } catch (ParserConfigurationException | SAXException | IOException | NoSuchFieldException | IllegalAccessException | InstantiationException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            System.out.println("找到对应的加载类");
        }
    }

    private void registryBean(String id, Object bean) {
        registry.put(id,bean);
    }

    public Object getBean(String name) {
        Object bean = registry.get(name);
        if (bean == null) {
            throw new IllegalArgumentException("there is no bean with name " + name);
        }

        return bean;
    }
}
