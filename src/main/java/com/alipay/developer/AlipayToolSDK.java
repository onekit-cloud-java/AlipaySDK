package com.alipay.developer;


import cn.onekit.thekit.JSON;
import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.request.*;
import com.alipay.api.response.*;
import com.alipay.openapi.AlipayToolAPI;
import com.alipay.openapi.entity.*;


@SuppressWarnings("unused")
public class AlipayToolSDK extends AlipayToolAPI {


    private AlipayClient alipayClient = new DefaultAlipayClient(host,AlipayAccount.appId,AlipayAccount.privateKey
            ,AlipayAccount.fromat,AlipayAccount.charset,AlipayAccount.alipayPublicKey
            ,AlipayAccount.signType);

    public AlipayToolSDK(String host, String app_id, String method, String format, String charset, String sign_type, String sign, String timestamp, String version, String app_auth_token) {
        super(host, app_id, method, format, charset, sign_type, sign, timestamp, version, app_auth_token);
    }


    public AlipaySystemOauthTokenResponse alipay_system_oauth_token(String grant_type, String code, String refresh_token) throws AlipayApiException{

        AlipaySystemOauthTokenRequest request = new AlipaySystemOauthTokenRequest();
        request.setGrantType(grant_type);
        if(grant_type.equals("authorization_code")){
            request.setCode(code);
        }else{
            request.setRefreshToken(refresh_token);
        }

        return alipayClient.execute(request);


    }



   /* public MonitorHeartbeatSynResponse monitor_heartbeat_syn(String biz_content) throws AlipayApiException{
        MonitorHeartbeatSynRequest request = new MonitorHeartbeatSynRequest();
        request.setBizContent(biz_content);

        return alipayClient.execute(request);

    }*/

    public AlipayOpenAppMessageTopicSubscribeResponse alipay_open_app_message_topic_subscribe(alipay_open_app_message_topic_subscribe_body body) throws AlipayApiException {
        AlipayOpenAppMessageTopicSubscribeRequest request = new AlipayOpenAppMessageTopicSubscribeRequest();
        request.setBizContent(JSON.object2string(body));
        return alipayClient.execute(request);
    }
}
