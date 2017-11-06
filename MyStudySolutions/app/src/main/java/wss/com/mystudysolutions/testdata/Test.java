package wss.com.mystudysolutions.testdata;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.view.View;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import wss.com.mystudysolutions.fragments.SingleCourseFragment;
import wss.com.mystudysolutions.models.Article;
import wss.com.mystudysolutions.models.Course;
import wss.com.mystudysolutions.models.Practical;
import wss.com.mystudysolutions.models.QuestionBank;
import wss.com.mystudysolutions.models.Semester;
import wss.com.mystudysolutions.models.Subject;
import wss.com.mystudysolutions.utils.AppConstants;

/**
 * Created by Chiranjit Jana on 28/10/2017.
 */

public class Test {

    public static ArrayList<String> getCourseTitleHeader() {
        ArrayList<String> courseName = new ArrayList<>();
        courseName.add("Bsc(IT)");
        courseName.add("Bsc(SC)");
        courseName.add("Msc(SC)");
        courseName.add("Msc(IT)");
        return courseName;
    }


    //created dummy data to show in the articles
    public static Object getCourseData() {


        ArrayList<Course> listCourses = new ArrayList<Course>();

        Course bscit = new Course();
        bscit.setCourseName("Bsc(IT)");
        bscit.setCourseTitle("Becholar In Information Technology");
        bscit.setDuration("Duration : 3 Years");
        bscit.setDescription("Description : The Bachelor of Information Technology degree is a distinctly different from a general B. Sc. The Bachelor of Engineering in Information Technology, however is a 3-year program and the degree awarded is referred to as B.Tech or B.E. One can apply for BSc IT after completing HSC or after completing Engineering Diploma.");
        bscit.setEligiblity("Eligiblity : Passed 12 with 60%");

        listCourses.add(bscit);

        Course bscsc = new Course();
        bscsc.setCourseName("Bsc(SC)");
        bscsc.setCourseTitle("Becholar In Information Science");
        bscsc.setDuration("Duration : 3 Years");
        bscsc.setDescription("Description : The Bachelor of Information Science degree is a distinctly different from a general B. Sc. The Bachelor of Engineering in Information Technology, however is a 2-year program and the degree awarded is referred to as B.Tech or B.E. One can apply for BSc IT after completing HSC or after completing Engineering Diploma.");
        bscsc.setEligiblity("Eligiblity : Passed 12 with 60%");

        listCourses.add(bscsc);

        Course mscsc = new Course();
        mscsc.setCourseName("Msc(SC)");
        mscsc.setCourseTitle("Master In Information Science");
        mscsc.setDuration("Duration : 2 Years");
        mscsc.setDescription("Description : The Master of Information Science degree is a distinctly different from a general B. Sc. The Bachelor of Engineering in Information Technology, however is a 2-year program and the degree awarded is referred to as B.Tech or B.E. One can apply for BSc IT after completing HSC or after completing Engineering Diploma.");
        mscsc.setEligiblity("Eligiblity : Passed Bsc(SC) with 60%");

        listCourses.add(mscsc);

        Course mscit = new Course();
        mscit.setCourseName("Msc(IT)");
        mscit.setCourseTitle("Master In Information Technology");
        mscit.setDuration("Duration : 2 Years");
        mscit.setEligiblity("Eligiblity : Passed Bsc(IT) with 60%");
        mscit.setDescription("Description : The Master of Information Technology degree is a distinctly different from a general B. Sc. The Bachelor of Engineering in Information Technology, however is a 2-year program and the degree awarded is referred to as B.Tech or B.E. One can apply for BSc IT after completing HSC or after completing Engineering Diploma.");

        listCourses.add(mscit);


        return listCourses;

    }


/*    public static ArrayList<String> getBlogsTitleHeader() {
        *//*ArrayList<String> blogs = new ArrayList<>();
        blogs.add("Android");
        blogs.add("Java");
        blogs.add("Spring And Hibernate");
        blogs.add("Bootsrap");
        blogs.add("Magento");*//*



        return blogs;
    }*/


    //created dummy data to show in the articles
    /*public static Object getBlogsData() {
        ArrayList<ArrayList<Article>> articles = new ArrayList<ArrayList<Article>>();

        for (int i = 0; i < 3; i++) {
            ArrayList<Article> listArticle = new ArrayList<>();
            for (int k = 0; k < 5; k++) {
                Article artcile = new Article(i + "type" + k, "String url" + k,
                        "String title", "String contain",
                        "String createDate", "String author");
                listArticle.add(artcile);
            }
            articles.add(listArticle);
        }

        return articles;

    }*/


    public static Object getGenericData() {
        ArrayList<Course> listCourses = new ArrayList<>();


        for (int i = 0; i < 4; i++) {
            Course course = new Course();
            course.setId(i);
            course.setCourseName("Course " + i);
            course.setCourseTitle("Course Title" + i);
            course.setDuration("Duration 4");
            course.setEligiblity("3 years");
            course.setDescription("dummy.............................");
            ArrayList<Semester> semList = new ArrayList<>();
            for (int k = 0; k < 6; k++) {
                Semester sem = new Semester();
                sem.setSemName("SEM Name" + k);
                sem.setSemId("SEM ID " + k);
                ArrayList<Subject> subList = new ArrayList<>();
                for (int j = 0; j < 5; j++) {
                    Subject sub = new Subject();
                    sub.setSubId("Sub Id " + j);
                    sub.setSubCreatedDate("17th march 2017 " + j);
                    sub.setSubName("Name " + j);
                    sub.setSubUrl("Url " + j);

                    ArrayList<QuestionBank> qbList = new ArrayList<>();
                    for (int t = 0; t < 4; t++) {
                        QuestionBank qb=new QuestionBank();
                        qb.setAuthor("Author "+t);
                        qb.setFileName("abc.txt "+t);
                        qb.setTitle("Title "+t);
                        qb.setCreatedDate("23 March 2017");
                        qb.setQbId("qb"+t);
                        qb.setStatus("New"+t);
                        qb.setfUrl("http://qb.com/12");

                        qbList.add(qb);
                    }


                    ArrayList<Practical> praticalList = new ArrayList<>();
                    for (int t = 0; t < 14; t++) {
                        int max = 14;
                        int min = 1;
                        Random no = new Random();
                        int rn = no.nextInt((max - min) + 1) + min;
                        String type = AppConstants.NONVIDEO;
                        if (rn % 2 == 0) {
                            type = AppConstants.VIDEO;
                        }

                        Practical prac=new Practical();
                        prac.setPid("pid "+t);
                        prac.setAuthor("Author "+t);
                        prac.setFileName("abc.txt "+t);
                        prac.setUrl("www.yahooo.com");
                        prac.setCreatedDate("23 March 2017");
                        prac.setpType(type);
                        prac.setpTitle("Title "+t);
                        prac.setpDescription("Dummmyy.................dummy");

                        praticalList.add(prac);
                    }

                    sub.setPracticalList(praticalList);
                    sub.setQblList(qbList);
                    subList.add(sub);
                }
                sem.setSubject(subList);
                semList.add(sem);
            }
            course.setSemesters(semList);
            listCourses.add(course);
        }


        return listCourses;
    }

    /*public static List<String> getSyllabusTitleHeader() {
        ArrayList<String> courseName = new ArrayList<>();
        courseName.add("Bsc(IT)");
        courseName.add("Bsc(SC)");
        courseName.add("Msc(SC)");
        courseName.add("Msc(IT)");
        return courseName;
    }*/

    public static List<String> getSyllabusSemester() {
        ArrayList<String> semester = new ArrayList<>();
        semester.add("Bsc(IT)");
        semester.add("Bsc(SC)");
        semester.add("Msc(SC)");
        semester.add("Msc(IT)");
        return semester;

    }



    public static ArrayList<Practical> getPractical() {
        int max = 14;
        int min = 1;
        ArrayList<Practical> list = new ArrayList<>();
        for (int i = 0; i < 15; i++) {
            Random no = new Random();
            int rn = no.nextInt((max - min) + 1) + min;
            String type = AppConstants.NONVIDEO;
            if (rn % 2 == 0) {
                type = AppConstants.VIDEO;
            }

            list.add(new Practical("DBMS " + 0, type, "23 march 2017",
                    "URL",
                    "dummy",
                    "It is a long established fact that a reader will be distracted by " +
                            "the readable content of a page when looking at its layout." +
                            " The point of using Lorem Ipsum is that it has a more-or-less" +
                            " normal distribution of letters, as opposed to using 'Content here," +
                            " content here', making it look like readable English. Many desktop" +
                            " publishing packages and web page editors now use Lorem Ipsum as their" +
                            " default model text, and a search for 'lorem ipsum' will uncover many web " +
                            "sites still in their infancy. Various versions have evolved over the years," +
                            "sometimes by accident, sometimes on purpose (injected humour and the like).", "Chiranjit Jana"));
        }


        return list;
    }


    public static List<String> getGenericHeaderForTablayout(Object obj) {

        ArrayList<Course> courses=(ArrayList<Course>)obj;
        List<String> data=new ArrayList<>();

        for (Course cours:courses) {
            data.add(cours.getCourseName());
        }

        return  data;
    }

    public static ArrayList<QuestionBank> getQB() {
        int max = 14;
        int min = 1;
        ArrayList<QuestionBank> list = new ArrayList<>();
        for (int i = 0; i < 15; i++) {
            Random no = new Random();
            int rn = no.nextInt((max - min) + 1) + min;

            if(rn%2==0)
            list.add(new QuestionBank("String title",
                   AppConstants.VISIBLE, "String fileName",
                    "String fUrl", "String qbId",
                    "String createdDate", "String author"));
            else
                list.add(new QuestionBank("String title",
                        AppConstants.HIDE, "String fileName",
                        "String fUrl", "String qbId",
                        "String createdDate", "String author"));

        }


        return list;
    }

    public static List<String> getFeedbackHeaderTab() {
        List<String> list=new ArrayList<>();
        list.add("Feedback Form");
        list.add("My Feedback List");

        return list;

    }
}
