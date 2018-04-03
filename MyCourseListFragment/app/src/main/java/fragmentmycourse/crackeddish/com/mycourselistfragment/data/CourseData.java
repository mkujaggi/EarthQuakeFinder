package fragmentmycourse.crackeddish.com.mycourselistfragment.data;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by mkujaggi on 13-03-2018.
 */

public class CourseData {
    private String[]courseNames={"First Course","Second Course", "Third Course","Fourth Course","Fifth Course","Sixth Course"
    ,"Seventh Course"};
    public ArrayList<Course> courseList(){
        ArrayList<Course> list =new ArrayList<>();
        for (int i=0;i<courseNames.length;i++){
            Course course=new Course(courseNames[i],courseNames[i].replace(" ","").toLowerCase());
            list.add(course);
        }
        return list;
    }
}
