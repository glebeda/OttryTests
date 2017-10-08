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
    public String Host;
    public String DBuser;
    public String DBpassword;

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

    public String getDBuser() {
        return DBuser;
    }

    public void setDBuser(String dbuser) {
        this.DBuser = dbuser;
    }

    public String getDBpassword() {
        return DBpassword;
    }

    public void setDBpassword(String dbpassword) {
        this.DBpassword = dbpassword;
    }
}
