package zhj.region_nbs_get.controller;

import org.jsoup.nodes.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import zhj.region_nbs_get.service.NBSGetService;
import zhj.region_nbs_get.entity.*;

import java.io.IOException;

@RestController
public class NBSGetController {

    @Autowired
    private NBSGetService nbsGetService;

    @Value("${stats.region.rootURI}")
    private String rootURI;

    @RequestMapping("/get")
    public Region get() throws IOException {
        Document doc = nbsGetService.getDoc(rootURI);
        Region r = new Region();
        r.rn = doc.title();
        return r;
    }
}
