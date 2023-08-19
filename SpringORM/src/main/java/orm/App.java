package orm;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App 
{
    public static void main( String[] args )
    {
        ApplicationContext con = new ClassPathXmlApplicationContext("config.xml");
        Dao dao = (Dao)con.getBean("dao");
        User u = new User(1,"Jainik",987654321,"Ahmedabad");
        dao.insertUpdateUser(u);
        System.out.println("Insert and Update");
    }
}
