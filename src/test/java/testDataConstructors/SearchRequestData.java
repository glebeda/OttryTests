package testDataConstructors;

import org.springframework.beans.factory.InitializingBean;

public class SearchRequestData {
    private String name;

    public void setName(String name) {
        this.name = name;
    }

    public void setSearchRequest(String searchRequest) {
        this.searchRequest = searchRequest;
    }

    private String searchRequest;

    public String getName() {
        return name;
    }

    public String getSearchRequest() {
        return searchRequest;
    }


}
