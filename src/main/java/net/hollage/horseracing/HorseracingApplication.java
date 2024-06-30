package net.hollage.horseracing;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("net.hollage.horseracing.mapper")
public class HorseracingApplication {

  public static void main(String[] args) {
    SpringApplication.run(HorseracingApplication.class, args);
  }
}
