package zhj.region_nbs;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;

import java.io.IOException;

@SpringBootApplication
@MapperScan("zhj.region_nbs.mapper")
public class RegionNbsApplication {

    public static void main(String[] args) {
        SpringApplication.run(RegionNbsApplication.class, args);
    }
}


