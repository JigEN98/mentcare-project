package mentapp.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;

import org.springframework.stereotype.Component;
import java.io.IOException;


@Component
public class EventHandler {

    @Autowired
    InitializeDB initializeDB;

    @EventListener(ApplicationReadyEvent.class)
    public void OnReady() throws IOException {
        System.out.println("System: OnReady");
        initializeDB.initDB();
    }
}