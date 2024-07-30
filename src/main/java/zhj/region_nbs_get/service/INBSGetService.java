package zhj.region_nbs_get.service;

import org.jsoup.nodes.Document;

public interface INBSGetService {
    public Document getDoc(String URI) throws Exception;
}
