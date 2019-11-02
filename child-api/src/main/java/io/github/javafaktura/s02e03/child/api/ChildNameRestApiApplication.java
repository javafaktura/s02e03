package io.github.javafaktura.s02e03.child.api;

import io.github.javafaktura.s02e03.child.core.service.ChildNameMemoryService;
import io.github.javafaktura.s02e03.child.core.provider.ChildNameStatsCsvStatsProvider;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ChildNameRestApiApplication {
    public static void main(String[] args) {
        SpringApplication.run(ChildNameRestApiApplication.class, args);
    }

    @Bean
    public ChildNameMemoryService getChildNameService(@Value("${csv.name}") String csvName) {
        return new ChildNameMemoryService(new ChildNameStatsCsvStatsProvider(getPathToFile(csvName)));
    }

    private String getPathToFile(String fileName) {
        return getClass().getClassLoader().getResource(fileName).getPath();
    }
}
