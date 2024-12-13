package ru.controlwork.services;

import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;
import jakarta.servlet.annotation.WebListener;
import org.flywaydb.core.Flyway;
import ru.controlwork.services.db.DBConnection;

import java.sql.SQLException;

@WebListener
public class AppListener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        Flyway flyway = Flyway.configure()
                .dataSource("jdbc:postgresql://localhost:5432/control", "postgres", "new_password")
                .baselineOnMigrate(true)
                .load();
        System.out.println("start migration");
        flyway.baseline();
        flyway.migrate();
        System.out.println("finish migration");
        DBConnection dbConnection = DBConnection.getInstance();
        sce.getServletContext().setAttribute("dbConnection", dbConnection);
        System.out.println("database connection created");
    }

    public void contextDestroyed(ServletContextEvent sce) {
        DBConnection dbConnection = (DBConnection) sce.getServletContext().getAttribute("dbConnection");
        try {
            dbConnection.getConnection().close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
