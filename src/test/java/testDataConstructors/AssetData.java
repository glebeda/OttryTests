package testDataConstructors;

import org.springframework.beans.factory.InitializingBean;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by glebeda on 07.11.2016.
 */
/*public class AssetData implements InitializingBean {
    private String name;
    private int assetTypeId;
    private Integer nodeId;
    private int siteId;
    private Double posX;
    private Double posY;

    public Double getPosX() {
        return posX;
    }

    public void setPosX(Double posX) {
        this.posX = posX;
    }

    public Double getPosY() {
        return posY;
    }

    public void setPosY(Double posY) {
        this.posY = posY;
    }

    private int serviceLayerId;
    private List<DomainData> domains;
    private String domainDataKey;
    private DomainDataContainer domainData;
    private List<Integer> domainIds;
    private String assetTypeName;
    private String siteName;
    private String assetStatus;
    private String description;
    private String gps;
    private String serviceLayerName;
    private String slot;
    private String port;
    private String subnetworks;
    private String nodeName;
    private String ip;

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setAssetTypeId(int assetTypeId) {
        this.assetTypeId = assetTypeId;
    }

    public int getAssetTypeId() {
        return assetTypeId;
    }

    public void setNodeId(Integer nodeId) {
        this.nodeId = nodeId;
    }

    public Integer getNodeId() {
        return nodeId;
    }

    public void setSiteId(int siteId) {
        this.siteId = siteId;
    }

    public int getSiteId() {
        return siteId;
    }

    public void setServiceLayerId(int serviceLayerId) {
        this.serviceLayerId = serviceLayerId;
    }

    public int getServiceLayerId() {
        return serviceLayerId;
    }

    public List<DomainData> getDomains() {
        return domains;
    }

    public void setDomainDataKey(String domainDataKey) {
        this.domainDataKey = domainDataKey;
    }

    public void setDomainData(DomainDataContainer domainData) {
        this.domainData = domainData;
    }

    public List<Integer> getDomainIds() {
        return domainIds;
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        domains = domainData.getDashboardDomainSets().get(domainDataKey);
        //assert domains != null;
        domainIds = new ArrayList<Integer>();
        domains.forEach((domain) -> domainIds.add(domain.getId()));
    }

    public void setAssetTypeName(String assetTypeName) {
        this.assetTypeName = assetTypeName;
    }

    public String getAssetTypeName() {
        return assetTypeName;
    }

    public void setSiteName(String siteName) {
        this.siteName = siteName;
    }

    public String getSiteName() {
        return siteName;
    }

    public void setAssetStatus(String assetStatus) {
        this.assetStatus = assetStatus;
    }

    public String getAssetStatus() {
        return assetStatus;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public void setGps(String gps) {
        this.gps = gps;
    }

    public String getGps() {
        return gps;
    }

    public void setServiceLayerName(String serviceLayerName) {
        this.serviceLayerName = serviceLayerName;
    }

    public String getServiceLayerName() {
        return serviceLayerName;
    }

    public void setSlot(String slot) {
        this.slot = slot;
    }

    public String getSlot() {
        return slot;
    }

    public void setPort(String port) {
        this.port = port;
    }

    public String getPort() {
        return port;
    }

    public void setSubnetworks(String subnetworks) {
        this.subnetworks = subnetworks;
    }

    public String getSubnetworks() {
        return subnetworks;
    }

    public void setNodeName(String nodeName) {
        this.nodeName = nodeName;
    }

    public String getNodeName() {
        return nodeName;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getIp() {
        return ip;
    }
}                          */
