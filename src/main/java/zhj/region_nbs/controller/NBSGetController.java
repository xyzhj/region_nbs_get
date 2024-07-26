package zhj.region_nbs.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import zhj.region_nbs.service.NBSGetService;

@RestController
public class NBSGetController {

    @Autowired
    private NBSGetService nbsGetService;

    @Value("${stats.region.rootURI}")
    private String rootURI;

    @RequestMapping("/get")
    public void get() {
        nbsGetService.getDoc(rootURI);
    }
}
