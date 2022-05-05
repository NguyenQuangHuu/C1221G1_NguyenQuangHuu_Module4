package vn.codegym.model;

public class MailSetting {
    private String language;
    private String pageSize;
    private Boolean filter;
    private String signature;

    public MailSetting() {
    }

    public MailSetting(String language, String pageSize, Boolean filter, String signature) {
        this.language = language;
        this.pageSize = pageSize;
        this.filter = filter;
        this.signature = signature;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getPageSize() {
        return pageSize;
    }

    public void setPageSize(String pageSize) {
        this.pageSize = pageSize;
    }

    public Boolean getFilter() {
        return filter;
    }

    public void setFilter(Boolean filter) {
        this.filter = filter;
    }

    public String getSignature() {
        return signature;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }
}
