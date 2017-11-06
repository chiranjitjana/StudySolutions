package wss.com.mystudysolutions.models;

import java.io.Serializable;

/**
 * Created by Chiranjit Jana on 31/10/2017.
 */

public class QuestionBank implements Serializable {
    private String title;
    private String status;
    private String fileName;
    private String fUrl;
    private String qbId;
    private String createdDate;
    private String author;

    public QuestionBank() {
    }

    public QuestionBank(String title, String status, String fileName, String fUrl, String qbId, String createdDate, String author) {
        this.title = title;
        this.status = status;
        this.fileName = fileName;
        this.fUrl = fUrl;
        this.qbId = qbId;
        this.createdDate = createdDate;
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getfUrl() {
        return fUrl;
    }

    public void setfUrl(String fUrl) {
        this.fUrl = fUrl;
    }

    public String getQbId() {
        return qbId;
    }

    public void setQbId(String qbId) {
        this.qbId = qbId;
    }

    public String getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(String createdDate) {
        this.createdDate = createdDate;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }
}
