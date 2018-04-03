package fragmentmycourse.crackeddish.com.mycourselistfragment;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.ListFragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.Toast;

import java.util.List;

import fragmentmycourse.crackeddish.com.mycourselistfragment.Util.ScreenUtility;
import fragmentmycourse.crackeddish.com.mycourselistfragment.data.Course;
import fragmentmycourse.crackeddish.com.mycourselistfragment.data.CourseData;
import fragmentmycourse.crackeddish.com.mycourselistfragment.data.CoureArrayAdapter;

/**
 * Created by mkujaggi on 13-03-2018.
 */

public class CourseListFragment extends ListFragment {
    List<Course> courses=new CourseData().courseList();
    private Callbacks activity;
    public CourseListFragment(){
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ScreenUtility screenUtility=new ScreenUtility(getActivity());
        Log.d("WIDTH",String.valueOf(screenUtility.getDpWidth()));
        CoureArrayAdapter adapter=new CoureArrayAdapter(getActivity(),R.layout.course_listitem,courses);
        setListAdapter(adapter);

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.course_list_fragment,container,false);
        return view;
    }
    public  interface Callbacks{
        void onItemSelected(Course course,int position);
    }

    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
       Course course=courses.get(position);
       this.activity.onItemSelected(course,position);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        this.activity= (Callbacks) context;    }
}
