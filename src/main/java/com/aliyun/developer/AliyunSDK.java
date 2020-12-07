package com.aliyun.developer;

import com.alibaba.fastjson.JSONObject;

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


public class AliyunSDK extends AliyunAPI {

    public HttpResponse ImageSyncScanRequest(ImageSyncScanRequest_body body) {
        IClientProfile profile = DefaultProfile.getProfile(AliyunAccount.regionId, AliyunAccount.accessKeyId, AliyunAccount.accessKeySecret);
        try {
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

        JSONObject httpBody = new JSONObject();
        httpBody.put("scenes",body.getScenes());
        httpBody.put("tasks", body.getTasks());

        HttpResponse Response =null;
        try {
            Response =  client.doAction(imageSyncScanRequest);
        } catch (ClientException e) {
            e.printStackTrace();
        }
        return Response;
    }
}
