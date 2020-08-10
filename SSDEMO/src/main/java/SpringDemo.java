
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringDemo {

	public static void main(String[] args) {

		ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
		Employee emp = (Employee) context.getBean("x");
		System.out.println(emp.getData());
		
		
		Employee emp1 = (Employee) context.getBean("x");
		System.out.println(emp1.getData());
	}

}
