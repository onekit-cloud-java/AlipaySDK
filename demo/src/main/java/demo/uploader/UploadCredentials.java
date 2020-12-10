package demo.uploader;

import java.io.Serializable;
@SuppressWarnings("unused")
public class UploadCredentials implements Serializable {

    private String accessKeyId;
    private String  accessKeySecret;
    private String  securityToken;
    private Long  expiredTime;
    private String  ossEndpoint;
    private String  ossInternalEndpoint;
    private String  uploadBucket;
    private String  uploadFolder;

    @SuppressWarnings("WeakerAccess")
    public UploadCredentials(String accessKeyId, String accessKeySecret, String securityToken, Long expiredTime, String ossEndpoint, String ossInternalEndpoint, String uploadBucket, String uploadFolder) {
        this.accessKeyId = accessKeyId;
        this.accessKeySecret = accessKeySecret;
        this.securityToken = securityToken;
        this.expiredTime = expiredTime;
        this.ossEndpoint = ossEndpoint;
        this.ossInternalEndpoint = ossInternalEndpoint;
        this.uploadBucket = uploadBucket;
        this.uploadFolder = uploadFolder;
    }

    @SuppressWarnings("WeakerAccess")
    public String getAccessKeyId() {
        return accessKeyId;
    }


    public void setAccessKeyId(String accessKeyId) {
        this.accessKeyId = accessKeyId;
    }
    @SuppressWarnings("WeakerAccess")
    public String getAccessKeySecret() {
        return accessKeySecret;
    }

    public void setAccessKeySecret(String accessKeySecret) {
        this.accessKeySecret = accessKeySecret;
    }
    @SuppressWarnings("WeakerAccess")
    public String getSecurityToken() {
        return securityToken;
    }

    public void setSecurityToken(String securityToken) {
        this.securityToken = securityToken;
    }
    @SuppressWarnings("WeakerAccess")
    public Long getExpiredTime() {
        return expiredTime;
    }

    public void setExpiredTime(Long expiredTime) {
        this.expiredTime = expiredTime;
    }
    @SuppressWarnings("WeakerAccess")
    public String getOssEndpoint() {
        return ossEndpoint;
    }

    public void setOssEndpoint(String ossEndpoint) {
        this.ossEndpoint = ossEndpoint;
    }
    @SuppressWarnings("WeakerAccess")
    public String getUploadBucket() {
        return uploadBucket;
    }

    public void setUploadBucket(String uploadBucket) {
        this.uploadBucket = uploadBucket;
    }
    @SuppressWarnings("WeakerAccess")
    public String getUploadFolder() {
        return uploadFolder;
    }

    public void setUploadFolder(String uploadFolder) {
        this.uploadFolder = uploadFolder;
    }
    @SuppressWarnings("WeakerAccess")
    public String getOssInternalEndpoint() {
        return ossInternalEndpoint;
    }

    public void setOssInternalEndpoint(String ossInternalEndpoint) {
        this.ossInternalEndpoint = ossInternalEndpoint;
    }
}
