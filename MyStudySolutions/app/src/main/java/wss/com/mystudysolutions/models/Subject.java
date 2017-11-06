package wss.com.mystudysolutions.models;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by Chiranjit Jana on 29/10/2017.
 */

public class Subject implements Serializable {
    private String subId,subName,subUrl,subImage,subCreatedDate;
    private ArrayList<Practical> practicalList;
    private ArrayList<QuestionBank> qblList;

    public Subject() {
    }


    public Subject(String subId, String subName, String subUrl, String subImage, String subCreatedDate) {
        this.subId = subId;
        this.subName = subName;
        this.subUrl = subUrl;
        this.subCreatedDate = subCreatedDate;
        this.subImage=subImage;
    }

    public ArrayList<QuestionBank> getQblList() {
        return qblList;
    }

    public void setQblList(ArrayList<QuestionBank> qblList) {
        this.qblList = qblList;
    }

    public ArrayList<Practical> getPracticalList() {
        return practicalList;
    }

    public void setPracticalList(ArrayList<Practical> practicalList) {
        this.practicalList = practicalList;
    }
    public String getSubImage() {
        return subImage;
    }

    public void setSubImage(String subImage) {
        this.subImage = subImage;
    }

    public String getSubId() {
        return subId;
    }

    public void setSubId(String subId) {
        this.subId = subId;
    }

    public String getSubName() {
        return subName;
    }

    public void setSubName(String subName) {
        this.subName = subName;
    }

    public String getSubUrl() {
        return subUrl;
    }

    public void setSubUrl(String subUrl) {
        this.subUrl = subUrl;
    }

    public String getSubCreatedDate() {
        return subCreatedDate;
    }

    public void setSubCreatedDate(String subCreatedDate) {
        this.subCreatedDate = subCreatedDate;
    }
}
