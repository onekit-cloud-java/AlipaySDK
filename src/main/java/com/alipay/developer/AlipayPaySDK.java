package com.alipay.developer;


import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.openapi.AlipayPayAPI;

@SuppressWarnings("unused")
public class AlipayPaySDK extends AlipayPayAPI {

    private AlipayClient alipayClient = new DefaultAlipayClient(host,AlipayAccount.appId,AlipayAccount.privateKey
            ,AlipayAccount.fromat,AlipayAccount.charset,AlipayAccount.alipayPublicKey
            ,AlipayAccount.signType);

    public AlipayPaySDK(String host, String app_id, String method, String format, String charset, String sign_type, String sign, String timestamp, String version, String app_auth_token) {
        super(host, app_id, method, format, charset, sign_type, sign, timestamp, version, app_auth_token);
    }


   /* public AntMerchantExpandShopQueryResponse ant_merchant_expand_shop_query(ant_merchant_expand_shop_query_body body) throws AlipayApiException {

        AntMerchantExpandShopQueryRequest request = new AntMerchantExpandShopQueryRequest();
        request.setBizContent(JSON.object2string(body));
        return alipayClient.execute(request);

    }*/
}
