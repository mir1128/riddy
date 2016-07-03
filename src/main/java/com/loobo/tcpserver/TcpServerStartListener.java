package com.loobo.tcpserver;

import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class TcpServerStartListener implements ServletContextListener {

    @Autowired
    TcpServer tcpServer;

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        if (!tcpServer.initialize()) {
            return;
        }
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {

    }
}
