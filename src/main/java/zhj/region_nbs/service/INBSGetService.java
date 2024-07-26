package zhj.region_nbs.service;

import org.jsoup.nodes.Document;

public interface INBSGetService {
    public Document getDoc(String URI) throws Exception;
}
