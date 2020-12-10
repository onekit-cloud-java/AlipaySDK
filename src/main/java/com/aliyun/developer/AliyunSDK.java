package com.aliyun.developer;

import cn.onekit.thekit.JSON;


import com.aliyuncs.AliyunAPI;
import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.entity.ImageSyncScanRequest_body;
import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.green.model.v20180509.ImageSyncScanRequest;
import com.aliyuncs.http.FormatType;
import com.aliyuncs.http.HttpResponse;
import com.aliyuncs.http.MethodType;
import com.aliyuncs.http.ProtocolType;
import com.aliyuncs.profile.DefaultProfile;
import com.aliyuncs.profile.IClientProfile;


@SuppressWarnings("unused")
public class AliyunSDK extends AliyunAPI {

    public HttpResponse ImageSyncScanRequest(ImageSyncScanRequest_body body) {
        IClientProfile profile = DefaultProfile.getProfile(AliyunAccount.regionId, AliyunAccount.accessKeyId, AliyunAccount.accessKeySecret);
        try {
            //noinspection deprecation
            DefaultProfile.addEndpoint("cn-shanghai", "cn-shanghai", "Green", "green.cn-shanghai.aliyuncs.com");
        } catch (ClientException e) {
            e.printStackTrace();
        }
        IAcsClient client = new DefaultAcsClient(profile);
        ImageSyncScanRequest imageSyncScanRequest = new ImageSyncScanRequest();
        imageSyncScanRequest.setAcceptFormat(FormatType.JSON);
        imageSyncScanRequest.setMethod(MethodType.POST);
        imageSyncScanRequest.setEncoding("utf-8");
        imageSyncScanRequest.setProtocol(ProtocolType.HTTP);

        imageSyncScanRequest.setHttpContent(org.apache.commons.codec.binary.StringUtils.getBytesUtf8(JSON.object2string(body)),
                "UTF-8", FormatType.JSON);

        HttpResponse Response =null;
        try {
            Response =  client.doAction(imageSyncScanRequest);
        } catch (ClientException e) {
            e.printStackTrace();
        }
        return Response;
    }
}
