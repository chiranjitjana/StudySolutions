package wss.com.mystudysolutions.models;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by Chiranjit Jana on 20/10/2017.
 */

public class Course implements Serializable{
    private int id;
    private String courseName;
    private String courseTitle;
    private String duration;
    private String description;
    private String eligiblity;
    private ArrayList<Semester> semesters;

    public ArrayList<Semester> getSemesters() {
        return semesters;
    }

    public void setSemesters(ArrayList<Semester> semesters) {
        this.semesters = semesters;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public String getEligiblity() {
        return eligiblity;
    }

    public void setEligiblity(String eligiblity) {
        this.eligiblity = eligiblity;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCourseTitle() {
        return courseTitle;
    }

    public void setCourseTitle(String courseTitle) {
        this.courseTitle = courseTitle;
    }
}
