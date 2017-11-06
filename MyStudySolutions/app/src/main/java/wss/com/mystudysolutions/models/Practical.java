package wss.com.mystudysolutions.models;

import java.io.Serializable;

/**
 * Created by Chiranjit Jana on 29/10/2017.
 */

public class Practical implements Serializable {
    String pid,pTitle,pType,createdDate,url,fileName,pDescription,author;

    public Practical() {
    }

    public Practical(String pTitle, String pType, String createdDate, String url, String fileName, String pDescription, String author) {
        this.pTitle = pTitle;
        this.pType = pType;
        this.createdDate = createdDate;
        this.url = url;
        this.fileName = fileName;
        this.pDescription=pDescription;
        this.author=author;
    }

    public String getPid() {
        return pid;
    }

    public void setPid(String pid) {
        this.pid = pid;
    }

    public String getpDescription() {
        return pDescription;
    }

    public void setpDescription(String pDescription) {
        this.pDescription = pDescription;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getpTitle() {
        return pTitle;
    }

    public void setpTitle(String pTitle) {
        this.pTitle = pTitle;
    }

    public String getpType() {
        return pType;
    }

    public void setpType(String pType) {
        this.pType = pType;
    }

    public String getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(String createdDate) {
        this.createdDate = createdDate;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }
}
