package edu.miu.cs590.hotelroomservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.data.mongodb.config.EnableMongoAuditing;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class })
@EnableMongoAuditing
@EnableCaching
public class HotelRoomServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(HotelRoomServiceApplication.class, args);
    }

}
