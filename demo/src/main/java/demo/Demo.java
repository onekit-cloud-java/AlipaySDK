package demo;


import cn.onekit.thekit.JSON;
import com.alipay.api.AlipayApiException;
import com.alipay.developer.*;
import com.alipay.openapi.entity.*;
import com.aliyun.developer.AliyunSDK;
import com.aliyuncs.entity.ImageSyncScanRequest_body;
import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.profile.DefaultProfile;
import com.aliyuncs.profile.IClientProfile;
import demo.uploader.ClientUploader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;


@RestController
@RequestMapping("/")

public class Demo {
    private AlipayToolSDK alipayToolSDK=new AlipayToolSDK("https://openapi.alipay.com/gateway.do",AlipayAccount.appId,"",AlipayAccount.fromat,AlipayAccount.charset,AlipayAccount.signType,
            "","2014-07-24 03:07:50",AlipayAccount.version,"");

    private AlipaySellSDK alipaySellSDK=new AlipaySellSDK("https://openapi.alipay.com/gateway.do",AlipayAccount.appId,"",AlipayAccount.fromat,AlipayAccount.charset,AlipayAccount.signType,
            "","2014-07-24 03:07:50",AlipayAccount.version,"");

    private AlipayMiniSDK alipayMiniSDK=new AlipayMiniSDK("https://openapi.alipay.com/gateway.do",AlipayAccount.appId,"",AlipayAccount.fromat,AlipayAccount.charset,AlipayAccount.signType,
            "","2014-07-24 03:07:50",AlipayAccount.version,"");

    private AliyunSDK aliyunSDK = new AliyunSDK();

    @RequestMapping("/token")
    public String getToken(
            @RequestParam String grant_type,
            @RequestParam String code,
            @RequestParam String refresh_token) throws AlipayApiException {

        return JSON.object2string(alipayToolSDK.alipay_system_oauth_token(grant_type, code, refresh_token));

    }
/*
    @RequestMapping("/syn")
    public String syn(
            @RequestParam String biz_content
    ) throws AlipayApiException {
        return JSON.object2string(alipayToolSDK.monitor_heartbeat_syn(biz_content));
    }*/

    @RequestMapping("/qrcode")
    public String qrcode(
    ) throws AlipayApiException {
        alipay_open_app_qrcode_create_body body = new alipay_open_app_qrcode_create_body();
        body.setUrl_param("page/component/component-pages/view/view");
        body.setQuery_param("x=1");
        body.setDescribe("二维码描述");

        return JSON.object2string(alipaySellSDK.alipay_open_app_qrcode_create(body));

    }

   /* @RequestMapping("/upload")
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

    }*/

    @RequestMapping("/content")
    public String content() throws AlipayApiException{
        alipay_security_risk_content_detect_body body = new alipay_security_risk_content_detect_body();
        body.setContent("hello");
        return JSON.object2string(alipayMiniSDK.alipay_security_risk_content_detect(body));
    }

    @SuppressWarnings("DuplicatedCode")
    @RequestMapping("imagecheck")
    public String imagecheck() {
        ImageSyncScanRequest_body body = new ImageSyncScanRequest_body();
        ArrayList<ImageSyncScanRequest_body.Scene> scenes = new ArrayList<>();
        scenes.add(ImageSyncScanRequest_body.Scene.porn);
        body.setScenes(scenes);
        ArrayList<ImageSyncScanRequest_body.Task> tasks = new ArrayList<>();
        ImageSyncScanRequest_body.Task task = new ImageSyncScanRequest_body.Task();

        task.setUrl("https://gw.alicdn.com/bao/upload/O1CN01Q7VOO01jbH50Niglu_!!6000000004566-0-yinhe.jpg_240x10000Q75.jpg_.webp");
        tasks.add(task);
        body.setTasks(tasks);
        return JSON.object2string(aliyunSDK.ImageSyncScanRequest(body));
    }

    @SuppressWarnings("DuplicatedCode")
    @RequestMapping("imagecheck2")
    public String imagecheck2() {
        IClientProfile profile = DefaultProfile.getProfile(AliyunAccount.regionId, AliyunAccount.accessKeyId, AliyunAccount.accessKeySecret);
        try {
            //noinspection deprecation
            DefaultProfile.addEndpoint("cn-shanghai", "cn-shanghai", "Green", "green.cn-shanghai.aliyuncs.com");
        } catch (ClientException e) {
            e.printStackTrace();
        }
        ImageSyncScanRequest_body body = new ImageSyncScanRequest_body();
        ArrayList<ImageSyncScanRequest_body.Scene> scenes = new ArrayList<>();
        body.setScenes(scenes);
        ArrayList<ImageSyncScanRequest_body.Task> tasks = new ArrayList<>();
        ImageSyncScanRequest_body.Task task = new ImageSyncScanRequest_body.Task();
        ClientUploader clientUploader = ClientUploader.getImageClientUploader(profile, false);
        String url = null;
        try{
            url = clientUploader.uploadFile("C:\\Users\\Administrator\\Desktop\\qq_pic_merged_1607393698487.jpg");
        }catch (Exception e){
            e.printStackTrace();
        }

        task.setUrl(url);

        tasks.add(task);
        body.setTasks(tasks);
        return JSON.object2string(aliyunSDK.ImageSyncScanRequest(body));
    }

    @RequestMapping("/subscribe")
    public String subscribe() throws AlipayApiException{
        alipay_open_app_message_topic_subscribe_body body = new alipay_open_app_message_topic_subscribe_body();
        body.setAuth_token("authusrB638cc24990f14790be851d840f3e2X90");
        body.setAuth_type("app_auth");
        body.setComm_type("HTTP");
        body.setTopic("alipay.open.auth.appauth.cancelled");
        body.setTag("BIZ_TAG");
        return JSON.object2string(alipayToolSDK.alipay_open_app_message_topic_subscribe(body));
    }

}
