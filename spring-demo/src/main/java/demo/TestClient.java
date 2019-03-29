package demo;

import org.springframework.beans.factory.support.BeanDefinitionReader;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

public class TestClient {

	public static void main(String[] args) {

		Resource resource = new ClassPathResource("springContext-aa.xml");
		DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();
		BeanDefinitionReader beanDefinitionReader = new XmlBeanDefinitionReader(beanFactory);
		beanDefinitionReader.loadBeanDefinitions(resource);

		Person p = Person.builder().name("zhangsan").age(20).desc("test").build();
		IHello iHello = (IHello) beanFactory.getBean("hello");
		iHello.showInfo(p);

	}


}

