package com.alipay.developer;

import cn.onekit.thekit.JSON;
import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.FileItem;
import com.alipay.api.request.AlipayMerchantItemFileUploadRequest;
import com.alipay.api.request.AlipayOpenAppMiniTemplatemessageSendRequest;
import com.alipay.api.request.AlipayOpenMiniContentSyncRequest;
import com.alipay.api.response.AlipayMerchantItemFileUploadResponse;
import com.alipay.api.response.AlipayOpenAppMiniTemplatemessageSendResponse;
import com.alipay.api.response.AlipayOpenMiniContentSyncResponse;
import com.alipay.openapi.AlipayMiniAPI;
import com.alipay.openapi.entity.alipay_open_mini_content_sync_body;

public class AlipayMiniSDK extends AlipayMiniAPI {

    private AlipayClient alipayClient = new DefaultAlipayClient(host,AlipayAccount.appId,AlipayAccount.privateKey
            ,AlipayAccount.fromat,AlipayAccount.charset,AlipayAccount.alipayPublicKey
            ,AlipayAccount.signType);

    public AlipayMiniSDK(String host, String app_id, String method, String format, String charset, String sign_type, String sign, String timestamp, String version, String app_auth_token) {
        super(host, app_id, method, format, charset, sign_type, sign, timestamp, version, app_auth_token);
    }


    public AlipayMerchantItemFileUploadResponse alipay_merchant_item_file_upload(String scene, String file_content) throws AlipayApiException {

        AlipayMerchantItemFileUploadRequest request = new AlipayMerchantItemFileUploadRequest();
        request.setScene(scene);
        FileItem FileContent = new FileItem(file_content);
        request.setFileContent(FileContent);
        return alipayClient.execute(request);


    }

    public AlipayOpenMiniContentSyncResponse alipay_open_mini_content_sync(alipay_open_mini_content_sync_body body) throws AlipayApiException {

        AlipayOpenMiniContentSyncRequest request = new AlipayOpenMiniContentSyncRequest();
        request.setBizContent(JSON.object2string(body));

        return alipayClient.execute(request);

    }
}
