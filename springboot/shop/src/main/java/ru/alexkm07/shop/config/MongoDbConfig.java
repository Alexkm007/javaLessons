package ru.alexkm07.shop.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@Configuration
@EnableMongoRepositories(basePackages = "ru.alexkm07.shop.repository.mongo")
public class MongoDbConfig {
}
