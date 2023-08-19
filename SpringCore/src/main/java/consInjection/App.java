package consInjection;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App 
{
    public static void main( String[] args )
    {
        ApplicationContext con = new ClassPathXmlApplicationContext("consInjection/config.xml");
       
//        User u2 = (User)con.getBean("u2");
//        System.out.println(u2);
        
        Data d1 = (Data)con.getBean("d1");
        System.out.println(d1);
    
    }
}
