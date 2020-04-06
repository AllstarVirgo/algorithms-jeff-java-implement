package test;

/**
 * @author potato
 * @Date 2019/9/23 15:43
 */


import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.io.File;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * @author potato
 * @Date 2019/9/23 15:41
 */
public class XmlParseTest {
    public static void main(String[] args) {

        String text = "<Response>\n" +
                "<MDN>0982684444</MDN>\n" +
                "<RtnDateTime>20100601123003</RtnDateTime>\n" +
                "<TaskID>20100608181004517001</TaskID>\n" +
                "<Code>0</Code>\n" +
                "<Reason>成功</Reason>\n" +
                "</Response>";

        SAXReader reader = new SAXReader();

        //加载文件
        Document document = null;
        try {
            document = reader.read(new File("test.txt"));
        } catch (DocumentException e) {
            e.printStackTrace();
        }
        //获取根结点
        Element rowData = document.getRootElement();
        //根节点迭代器
        Iterator it = rowData.elementIterator();
        Map<String, String> map = new HashMap<>();

        while (it.hasNext()) {
            //一级节点
            Element row = (Element) it.next();
            //一级节点迭代器
            if("Body".equals(row.getName())) {
                //取值
                Iterator subNodes = row.elementIterator();
                while (subNodes.hasNext()) {
                    Element subNode = (Element)subNodes.next();
                    map.put(subNode.getName(), subNode.getStringValue());
                }
            }

        }
        for (String key :
                map.keySet()) {
            System.out.println("key: "+key+ " value: "+map.get(key));
        }

    }

}
