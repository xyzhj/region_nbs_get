package zhj.region_nbs_get.service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.springframework.stereotype.Service;
import zhj.region_nbs_get.entity.Region;
import zhj.region_nbs_get.mapper.RegionMapper;

import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import java.io.IOException;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.X509Certificate;

@Service
public class NBSGetService extends ServiceImpl<RegionMapper, Region> implements INBSGetService {

    @Override
    public Document getDoc(String URI) throws IOException {
        return SSLHelper.getConnection(URI)
                .timeout(30000)
                .userAgent("Mozilla")
                .get();
    }
}
