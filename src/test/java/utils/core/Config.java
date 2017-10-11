package utils.core;

/**
 * Created with IntelliJ IDEA.
 * User: glebeda
 * Date: 06.07.16
 * Time: 11:24
 * To change this template use File | Settings | File Templates.
 */
public class Config {

    public String BaseURL;
    public String MerchantURL;
    public String Host;
    public String MerchantLogin;
    public String MerchantPassword;

    public String getBaseURL() {
        return BaseURL;
    }

    public void setBaseURL(String baseURL) {
        this.BaseURL = baseURL;
    }

    public String getHost() {
        return Host;
    }

    public void setHost(String host) {
        this.Host = host;
    }

    public String getMerchantLogin() {
        return MerchantLogin;
    }

    public void setMerchantLogin(String merchantLogin) {
        this.MerchantLogin = merchantLogin;
    }

    public String getMerchantPassword() {
        return MerchantPassword;
    }

    public void setMerchantPassword(String merchantPassword) {
        this.MerchantPassword = merchantPassword;
    }

    public String getMerchantURL() {
        return MerchantURL;
    }

    public void setMerchantURL(String merchantURL) {
        MerchantURL = merchantURL;
    }
}
