package com.ffcs.crmd.cas.intf.util;

import java.io.File;
import java.io.FileWriter;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.log4j.Logger;
import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;
import org.dom4j.tree.DefaultAttribute;

import com.ctg.itrdc.platform.common.utils.type.StringUtils;


public class XmlUtil {
    
    private static Logger      logger             = Logger.getLogger(XmlUtil.class);
    /**
     * delattXMLFile
     *
     * @param string String
     */
    public static boolean  delete(String path,String elname, String string) {
        try {
            SAXReader saxReader = new SAXReader();
            Document doc = saxReader.read(new File(path));
            Element root = doc.getRootElement(); //获取根结点
            List els = root.elements();
            for (int i = 0; i < els.size(); i++) {
                Element el = (Element) els.get(i);
                if(elname.equals(el.getName())){
                    String id = el.attributeValue("id");
                    if (id.equals(string)) {
                        els.remove(el);
                    }
                }               
            }
            /** 将document中的内容写入文件中 */
            OutputFormat format = OutputFormat.createPrettyPrint();
            /** 指定XML编码 */
            format.setEncoding("GBK");
            XMLWriter writer = new XMLWriter(new FileWriter(new File(path)),
                    format);
            writer.write(doc);
            writer.close();
            return true;

        } catch (Exception ex) {
            logger.info("删除备份记录成功失败");
            logger.error(ex.getMessage());
            ex.printStackTrace();
            return false;
        }
    }
    
    /**
     * 删除指定文件根节点下的指定结点
     * @param path XML文件绝对路径
     * @param elname 结点名
     * @param key 结点属性名(用于定位节点)
     * @param value 结点属性值(用于定位节点)
     * @return
     */
    public static boolean  delElement(String path,String elname,String key,String value) {
        try {
            File file = new File(path);
            if (!file.exists()) {
                logger.info("文件不存在!不用删除!");
                return false;
            }
            SAXReader saxReader = new SAXReader();
            Document doc = saxReader.read(file);
            Element root = doc.getRootElement(); //获取根结点
            List els = root.elements();
            for (int i = 0; i < els.size(); i++) {
                Element el = (Element) els.get(i);
                if(elname.equals(el.getName())){
                    String id = el.attributeValue(key);
                    if (id.equals(value)) {
                        els.remove(el);
                    }
                }               
            }
            /** 将document中的内容写入文件中 */
            OutputFormat format = OutputFormat.createPrettyPrint();
            /** 指定XML编码 */
            format.setEncoding("GBK");
            XMLWriter writer = new XMLWriter(new FileWriter(file),
                    format);
            writer.write(doc);
            writer.close();
            logger.info("删除XML记录成功");          
            return true;

        } catch (Exception ex) {
            logger.info("删除备份记录成功失败");
            logger.error(ex.getMessage());
            ex.printStackTrace();
            return false;
        }
    }
    
    /**
     * 删除文件根节点下指定节点名的所有节点
     * @param path XML文件绝对路径
     * @param index 节点名
     */
    public static void delElement(String path, String elname) {
        try {
            File file = new File(path);
            if (!file.exists()) {
                logger.info("文件不存在!不用删除!");
                return ;
            }
            SAXReader saxReader = new SAXReader();
            Document doc = saxReader.read(file);
            Element root = doc.getRootElement(); //获取根结点
            List els = root.elements();
            for (int i = 0; i < els.size(); i++) {              
                Element el = (Element) els.get(i);
                if(el.getName().equalsIgnoreCase(elname)){
                    els.remove(el);
                }               
            }
            /** 将document中的内容写入文件中 */
            OutputFormat format = OutputFormat.createPrettyPrint();
            /** 指定XML编码 */
            format.setEncoding("GBK");
            XMLWriter writer = new XMLWriter(new FileWriter(file),
                    format);
            writer.write(doc);
            writer.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }


    /**
     * 删除文件根节点下指定索引节点
     * @param path XML文件绝对路径
     * @param index 节点索引
     */
    public static void delElement(String path, Integer index) {
        try {
            File file = new File(path);
            if (!file.exists()) {
                logger.info("文件不存在!不用删除!");
                return ;
            }
            SAXReader saxReader = new SAXReader();
            Document doc = saxReader.read(file);
            Element root = doc.getRootElement(); //获取根结点
            List els = root.elements();
            Element el = (Element) els.get(index);
            els.remove(el);
            /** 将document中的内容写入文件中 */
            OutputFormat format = OutputFormat.createPrettyPrint();
            /** 指定XML编码 */
            format.setEncoding("GBK");
            XMLWriter writer = new XMLWriter(new FileWriter(file),
                    format);
            writer.write(doc);
            writer.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    /**
     * 修改指定文件根节点下指定节点的值
     * @param path XML文件绝对路径
     * @param elname 节点名
     * @param key 节点属性名
     * @param value 节点属性值
     * @param map 节点属性键值对
     */
    public static void updateXMLFile(String path,String elname,String key, String value, Map map) {
        try {
            File file = new File(path);
            if (!file.exists()) {
                logger.info("文件不存在!修改失败!");
                return ;
            }
            SAXReader saxReader = new SAXReader();
            Document doc = saxReader.read(file);
            Element root = doc.getRootElement();
            List els = root.elements();
            for (int i = 0; i < els.size(); i++) {
                Element el = (Element) els.get(i);
                if(elname.equals(el.getName())){
                    String id = el.attributeValue(key);
                    if (id.equals(value)) {
                        Iterator it = map.entrySet().iterator();
                        while (it.hasNext()) {
                            Entry entry = (Entry) it.next();
                            el.attributeValue((String) entry.getKey(),
                                    (String) entry.getValue());
                        }
                    }
                }               
            }
            /** 将document中的内容写入文件中 */
            OutputFormat format = OutputFormat.createPrettyPrint();
            /** 指定XML编码 */
            format.setEncoding("GBK");
            XMLWriter writer = new XMLWriter(new FileWriter(file),
                    format);
            writer.write(doc);
            writer.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }

    /**
     * 获取指定文件根节点下指定节点的属性键值对
     * @param path XML文件绝对路径
     * @param elname 节点名
     * @param key  节点属性名
     * @param value 节点属性值
     * @return
     */
    public static Map getXMLFile(String path,String elname,String key, String value) {
        Map map = new LinkedHashMap();
        try {
            File file = new File(path);
            if (!file.exists()) {
                logger.info("文件不存在!获取信息失败!");
                return map;
            }
            SAXReader saxReader = new SAXReader();
            Document doc = saxReader.read(new File(path));
            Element root = doc.getRootElement();
            List els = root.elements();
            for (int i = 0; i < els.size(); i++) {
                Element el = (Element) els.get(i);
                if(elname.equals(el.getName()))
                if (value.equals(el.attributeValue(key))) {
                    Iterator it=el.attributeIterator();
                    while(it.hasNext()){
                        DefaultAttribute att=(DefaultAttribute)it.next();
                        map.put(att.getName(),att.getValue());                      
                    }
                }
            }

        } catch (Exception ex) {
            logger.error(ex);
        }
        return map;

    }

    /**
     * 在XML文件的根节点下添加节点
     * @param path XML文件绝对路径
     * @param elname 新节点名
     * @param map 新节点属性键值对
     */
    public static void addXMLFile(String path,String elname, Map map) {
        try {
            File file = new File(path);
            if (!file.exists()) {
                XmlUtil.createXMLFile(path,"root");
            }
            SAXReader saxReader = new SAXReader();
            Document doc = saxReader.read(new File(path));
            Element root = doc.getRootElement();
            Element mesElement = root.addElement(elname);
            Iterator it = map.entrySet().iterator();
            while (it.hasNext()) {
                Entry entry = (Entry) it.next();
                mesElement.addAttribute((String) entry.getKey(), (String) entry
                        .getValue());
            }
            try {
                /** 将document中的内容写入文件中 */
                OutputFormat format = OutputFormat.createPrettyPrint();
                /** 指定XML编码 */
                format.setEncoding("GBK");
                XMLWriter writer = new XMLWriter(new FileWriter(file), format);
                writer.write(doc);
                writer.close();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }

    /**
     * 获取根节点下特定名字节点的集合
     * @param path  XML文件绝对路径
     * @param elname 特定节点名
     * @return
     */
    public static List listXMLFile(String path,String elname) {
        List list = new LinkedList();
        try {
            File file = new File(path);
            if (!file.exists()) {
                return list;
            }
            SAXReader saxReader = new SAXReader();
            Document doc = saxReader.read(file);

            Element root = doc.getRootElement(); //获取根结点
            List els = root.elements();
            for (int i = 0; i < els.size(); i++) {
                Map map = new LinkedHashMap();
                Element mes = (Element) els.get(i);
                if(elname.equals(mes.getName())){
                    Iterator it=mes.attributeIterator();
                    while(it.hasNext()){
                        DefaultAttribute att=(DefaultAttribute)it.next();
                        map.put(att.getName(),att.getValue());                      
                    }
                    list.add(map);
                }
                
            }
        } catch (Exception ex) {
            logger.error(ex);
            ex.printStackTrace();
        }
        return list;

    }

    /**
     * 创建XML文件
     * @param path XML文件绝对路径
     */
    public static void createXMLFile(String path,String rootName) {
        try {
            File file = new File(path);
            if (!file.exists()) {//如果文件不存在则创建
                file.getParentFile().mkdirs();
                file.createNewFile();
            }
            /** 建立document对象 */
            Document document = DocumentHelper.createDocument();
            document.addElement(rootName);

            /** 将document中的内容写入文件中 */
            OutputFormat format = OutputFormat.createPrettyPrint();
            /** 指定XML编码 */
            format.setEncoding("GBK");
            XMLWriter writer = new XMLWriter(new FileWriter(file), format);
            writer.write(document);
            writer.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    
    /**
     * 获Xml中第一个指定节点的值
     * .
     * 
     * @param inXml
     * @param tagName
     * @return
     * @author Wangjianjun
     * 2012-3-13 Wangjianjun
     */
    public static String getXmlContent(final String inXml, final String tagName) {
        if(StringUtils.isNullOrEmpty(tagName) || StringUtils.isNullOrEmpty(inXml)){
            return "";
        }
        int startIndex = -1;
        int endIndex = -1;
        final String str_maskStartStr = "<" + tagName + ">";
        final String str_maskEndStr = "</" + tagName + ">";
        
        if (inXml != null) {
            startIndex = inXml.indexOf(str_maskStartStr);
            endIndex = inXml.indexOf(str_maskEndStr);
            if (startIndex != -1) {
                final int contentStart = inXml.indexOf('>', startIndex) + 1;
                return inXml.substring(contentStart, endIndex);
            }
        }
        return "";
    }

    public static void main(String[] args) {
        List list=XmlUtil.listXMLFile("message","c:/nboa/backup/dbmanager.xml");
        for(int i=0;i<list.size();i++){
            Map map=(Map)list.get(i);
            Iterator it=map.entrySet().iterator();
            while(it.hasNext()){
                Entry entry=(Entry)it.next();
                System.out.println(entry.getKey()+"="+entry.getValue());
                
            }
        }
    }
}
