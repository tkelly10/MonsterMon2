package springxml.services.beans;

import org.springframework.context.support.ClassPathXmlApplicationContext;


public class SpringApp {
    public SpringApp() {
    }

    public static void main(String[] args) {

        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        CardInfo theCardLog = context.getBean("myCL", CardInfo.class);
        CardLog theCardInfo = context.getBean("myCI",CardLog.class);
        System.out.println(theCardInfo.changeLog());
        System.out.println(theCardLog.changeLog());

        context.close();
    }
}
