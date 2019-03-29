package demo;


import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;

public class TestMain {

	public static void main(String[] args) {

		Person p = Person.builder().name("zhangsan").age(20).desc("test").build();

		BeanFactory beanFactory = new XmlBeanFactory(new ClassPathResource("springContext-aa.xml"));
		IHello iHello = (IHello) beanFactory.getBean("hello");
		iHello.showInfo(p);


	}
}
