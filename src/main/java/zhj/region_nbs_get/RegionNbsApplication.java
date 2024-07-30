package zhj.region_nbs_get;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("zhj.region_nbs_get.mapper")
public class RegionNbsApplication {

    public static void main(String[] args) {
        SpringApplication.run(RegionNbsApplication.class, args);
    }
}


