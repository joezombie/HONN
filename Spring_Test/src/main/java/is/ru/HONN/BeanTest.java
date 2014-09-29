package is.ru.HONN;

import org.apache.log4j.PropertyConfigurator;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;

/**
 * Created by joezombie on 29.9.2014.
 */
public class BeanTest {
    public static void main(String[] args){
        PropertyConfigurator.configure("test.properties");

        ApplicationContext applicationContext = new FileSystemXmlApplicationContext("spring-config.xml");

        Person p = (Person)applicationContext.getBean("person");
        System.out.println(p);
    }
}
