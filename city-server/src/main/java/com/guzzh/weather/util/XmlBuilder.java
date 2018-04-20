package com.guzzh.weather.util;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;
import java.io.Reader;
import java.io.StringReader;

/**
 * @author gzz
 * @since 2018-4-16
 */
public class XmlBuilder {
    /**
     * 将xml转换为指定POJO
     *@author zz
     *@date 2018-4-16 10:53
     *@param clazz, xmlStr
     *@return java.lang.Object
     */
    public static Object xmlStrToObject(Class<?> clazz,String xmlStr) throws Exception{
        Object xmlObject=null;
        Reader reader=null;
        JAXBContext context=JAXBContext.newInstance(clazz);
        Unmarshaller unmarshaller=context.createUnmarshaller();

        reader=new StringReader(xmlStr);
        xmlObject = unmarshaller.unmarshal(reader);
        if(reader!=null){
            reader.close();
        }
        return xmlObject;
    }
}
