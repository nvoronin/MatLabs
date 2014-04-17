package edu.nikita.lab2;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.*;


/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	Resource resource = new FileSystemResource("Spring-Common.xml");
    	BeanFactory factory = new XmlBeanFactory(resource);
    	
    	NumberSeries d = (NumberSeries)factory.getBean(NumberSeries.class);
    	d.Produce();
    }
}
