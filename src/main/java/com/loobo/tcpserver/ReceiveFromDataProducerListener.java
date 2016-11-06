package com.loobo.tcpserver;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.loobo.domain.model.ReportingDataCollection;
import com.loobo.repository.IReportingDataCollectionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import java.io.IOException;
import java.util.Date;

@WebListener
public class ReceiveFromDataProducerListener implements ServletContextListener {

    @Value("${data.sender.address}")
    private String sendAddress;

    @Value("${data.sender.port}")
    private int port;

    @Autowired
    IReportingDataCollectionRepository repository;

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        Receiver receiver = new Receiver(sendAddress, port);

        Thread receiveThread = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    try {
                        ReportingDataCollection data
                                = new ObjectMapper().readValue(receiver.readMessage(), ReportingDataCollection.class);
                        data.setReportingFrom("producer");
                        data.setReportingTime(new Date());
                        repository.save(data);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
        receiveThread.start();
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {

    }
}
