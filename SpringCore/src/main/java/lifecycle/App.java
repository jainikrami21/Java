package lifecycle;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App 
{
    public static void main( String[] args )
    {
        AbstractApplicationContext con = new ClassPathXmlApplicationContext("lifecycle/config.xml");
        User u2 = (User)con.getBean("u2");
        System.out.println(u2);
        con.registerShutdownHook();
        
    }
}
