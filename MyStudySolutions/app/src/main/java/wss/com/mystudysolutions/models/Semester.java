package wss.com.mystudysolutions.models;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by Chiranjit Jana on 29/10/2017.
 */

public class Semester implements Serializable{
    private String semId,semName;
    private ArrayList<Subject> subject;

    public Semester() {
    }

    public Semester(String semId, String semName, ArrayList<Subject> subject) {
        this.semId = semId;
        this.semName = semName;
        this.subject = subject;
    }

    public String getSemId() {
        return semId;
    }

    public void setSemId(String semId) {
        this.semId = semId;
    }

    public String getSemName() {
        return semName;
    }

    public void setSemName(String semName) {
        this.semName = semName;
    }

    public ArrayList<Subject> getSubject() {
        return subject;
    }

    public void setSubject(ArrayList<Subject> subject) {
        this.subject = subject;
    }
}
