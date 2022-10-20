package util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.Configuration;

public class HibernateUtil
{

        public  static SessionFactory factory;
        public static SessionFactory getFactory(){
            if(factory==null)
            {
                Configuration configuration=new Configuration().configure();
                factory=configuration.buildSessionFactory();
            }

            return factory;
        }

        public void closeFactory()
        {
            if(factory.isOpen())
            {
                factory.close();
            }
        }
}

