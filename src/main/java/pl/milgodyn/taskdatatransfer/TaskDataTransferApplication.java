package pl.milgodyn.taskdatatransfer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
public class TaskDataTransferApplication {

    public static void main(String[] args) {
        SpringApplication.run(TaskDataTransferApplication.class, args);
    }

}
