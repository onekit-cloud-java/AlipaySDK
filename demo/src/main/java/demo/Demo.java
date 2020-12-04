package demo;


import cn.onekit.thekit.JSON;
import com.alipay.api.AlipayApiException;
import com.alipay.developer.AlipayMiniSDK;
import com.alipay.developer.AlipayPaySDK;
import com.alipay.developer.AlipaySellSDK;
import com.alipay.developer.AlipayToolSDK;
import com.alipay.openapi.entity.alipay_open_app_qrcode_create_body;
import com.alipay.openapi.entity.alipay_open_mini_content_sync_body;
import com.alipay.openapi.entity.ant_merchant_expand_shop_query_body;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/")

public class Demo {
    private AlipayToolSDK alipayToolSDK=new AlipayToolSDK("https://openapi.alipay.com/gateway.do",AlipayAccount.appId,"",AlipayAccount.fromat,AlipayAccount.charset,AlipayAccount.signType,
            "","2014-07-24 03:07:50",AlipayAccount.version,"");

    private AlipaySellSDK alipaySellSDK=new AlipaySellSDK("https://openapi.alipay.com/gateway.do",AlipayAccount.appId,"",AlipayAccount.fromat,AlipayAccount.charset,AlipayAccount.signType,
            "","2014-07-24 03:07:50",AlipayAccount.version,"");

    private AlipayPaySDK alipayPaySDK=new AlipayPaySDK("https://openapi.alipay.com/gateway.do",AlipayAccount.appId,"",AlipayAccount.fromat,AlipayAccount.charset,AlipayAccount.signType,
            "","2014-07-24 03:07:50",AlipayAccount.version,"");

    private AlipayMiniSDK alipayMiniSDK=new AlipayMiniSDK("https://openapi.alipay.com/gateway.do",AlipayAccount.appId,"",AlipayAccount.fromat,AlipayAccount.charset,AlipayAccount.signType,
            "","2014-07-24 03:07:50",AlipayAccount.version,"");

    @RequestMapping("/token")
    public String getToken(
            @RequestParam String grant_type,
            @RequestParam String code,
            @RequestParam String refresh_token) throws AlipayApiException {

        return JSON.object2string(alipayToolSDK.alipay_system_oauth_token(grant_type, code, refresh_token));

    }

    @RequestMapping("/syn")
    public String syn(
            @RequestParam String biz_content
    ) throws AlipayApiException {
        return JSON.object2string(alipayToolSDK.monitor_heartbeat_syn(biz_content));
    }

    @RequestMapping("/qrcode")
    public String qrcode(
    ) throws AlipayApiException {
        alipay_open_app_qrcode_create_body body = new alipay_open_app_qrcode_create_body();
        body.setUrl_param("page/component/component-pages/view/view");
        body.setQuery_param("x=1");
        body.setDescribe("二维码描述");

        return JSON.object2string(alipaySellSDK.alipay_open_app_qrcode_create(body));

    }

    @RequestMapping("/upload")
    public String upload(
            @RequestParam String scene,
            @RequestParam String file_content
    ) throws AlipayApiException {

        return JSON.object2string(alipayMiniSDK.alipay_merchant_item_file_upload(scene,file_content));

    }
    @RequestMapping("/sync")
    public String sync() throws AlipayApiException {

        alipay_open_mini_content_sync_body body = new alipay_open_mini_content_sync_body();
        Map<String,String[]> content_data = new HashMap<>();
        content_data.put("shopIds", new String[]{"2018030600077000000047967582"});
        Map<String,String> Extend_info = new HashMap<>();
        Extend_info.put("key","value");
        body.setContent_type("SHOP");
        body.setOperation("batchBind");
        body.setContent_data(content_data);
        body.setExtend_info(Extend_info);
        return JSON.object2string(alipayMiniSDK.alipay_open_mini_content_sync(body));

    }

    @RequestMapping("/shop")
    public String shop() throws AlipayApiException {
        ant_merchant_expand_shop_query_body body = new ant_merchant_expand_shop_query_body();
        body.setShop_id("2018030600077000000047967582");
        return JSON.object2string(alipayPaySDK.ant_merchant_expand_shop_query(body));

    }

}
