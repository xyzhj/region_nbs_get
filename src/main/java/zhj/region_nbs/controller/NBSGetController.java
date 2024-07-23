package zhj.region_nbs.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import zhj.region_nbs.service.NBSGetService;

@Controller
@RequestMapping("/nbsget")
public class NBSGetController {

    @Autowired
    NBSGetService nbsGetService;

    @RequestMapping("/get")
    public void get() {
        nbsGetService.getDoc(rootURI);
    }
}
