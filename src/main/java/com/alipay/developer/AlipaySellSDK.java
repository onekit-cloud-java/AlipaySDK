package com.alipay.developer;

import cn.onekit.thekit.JSON;
import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.request.AlipayOpenAppQrcodeCreateRequest;
import com.alipay.api.response.AlipayOpenAppQrcodeCreateResponse;
import com.alipay.openapi.AlipaySellAPI;
import com.alipay.openapi.entity.alipay_open_app_qrcode_create_body;


public class AlipaySellSDK extends AlipaySellAPI {

    private AlipayClient alipayClient = new DefaultAlipayClient(host,AlipayAccount.appId,AlipayAccount.privateKey
            ,AlipayAccount.fromat,AlipayAccount.charset,AlipayAccount.alipayPublicKey
            ,AlipayAccount.signType);

    public AlipaySellSDK(String host, String app_id, String method, String format, String charset, String sign_type, String sign, String timestamp, String version, String app_auth_token) {
        super(host, app_id, method, format, charset, sign_type, sign, timestamp, version, app_auth_token);
    }


    public AlipayOpenAppQrcodeCreateResponse alipay_open_app_qrcode_create(alipay_open_app_qrcode_create_body body) throws AlipayApiException {


            AlipayOpenAppQrcodeCreateRequest request = new AlipayOpenAppQrcodeCreateRequest();
            request.setBizContent(JSON.object2string(body));
            return alipayClient.execute(request);

    }
}
