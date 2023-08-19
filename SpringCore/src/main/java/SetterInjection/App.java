package SetterInjection;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App 
{
    public static void main( String[] args )
    {
        ApplicationContext con = new ClassPathXmlApplicationContext("SetterInjection/config.xml");
        User u2 = (User)con.getBean("u2");
        System.out.println(u2.getId());
        System.out.println(u2.getContact());
        System.out.println(u2.getName());
       
        
    }
}
