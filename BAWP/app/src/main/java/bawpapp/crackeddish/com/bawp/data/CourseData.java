package bawpapp.crackeddish.com.bawp.data;

import java.util.ArrayList;

import bawpapp.crackeddish.com.bawp.model.Course;

/**
 * Created by mkujaggi on 08-03-2018.
 */

public class CourseData {
    private String[] courseNames={"First Course","Second Course","Third Course","Fourth Course",
    "Fifth Course","Sixth Course","Seventh Course"};

    public ArrayList<Course> courseList(){
        ArrayList<Course> list=new ArrayList<>();
        for(int i=0;i<courseNames.length;i++){
            Course course=new Course(courseNames[i],courseNames[i].replace(" ","").toLowerCase(),"happy_woman");
            list.add(course);
        }
        return list;
    }
}
