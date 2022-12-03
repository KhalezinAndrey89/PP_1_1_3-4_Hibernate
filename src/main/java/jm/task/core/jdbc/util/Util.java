package jm.task.core.jdbc.util;

import jm.task.core.jdbc.model.User;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Util {
    private static final String url = "jdbc:mysql://localhost:3306/resource_db";
    private static final String userName = "root";
    private static final String password = "030589Ah";
    private static final String driver = "com.mysql.cj.jdbc.Driver";
    private static final String dialect = "org.hibernate.dialect.MySQLDialect";
    private static SessionFactory sessionFactory;

    public static SessionFactory getSessionFactory() {
        try {
            Configuration configuration = new Configuration()
                    .setProperty("hibernate.connection.url", url)
                    .setProperty("hibernate.connection.username", userName)
                    .setProperty("hibernate.connection.password", password)
                    .setProperty("hibernate.connection.driver_class", driver)
                    .setProperty("hibernate.connection.dialect", dialect)
                    .addAnnotatedClass(User.class);

            sessionFactory = configuration.buildSessionFactory();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return sessionFactory;
    }
}
