package fragmentmycourse.crackeddish.com.mycourselistfragment.data;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import fragmentmycourse.crackeddish.com.mycourselistfragment.R;

/**
 * Created by mkujaggi on 13-03-2018.
 */

public class CoureArrayAdapter extends ArrayAdapter<Course> {
    private List<Course> courses;
    private Context context;




    public CoureArrayAdapter(@NonNull Context context, int resource, List<Course> courses) {
        super(context, resource, courses);
        this.context=context;
        this.courses=courses;

    }
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        Course course=courses.get(position);
        LayoutInflater inflater= (LayoutInflater) context.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
        View view=inflater.inflate(R.layout.course_listitem,null);
        ImageView courseImageView=view.findViewById(R.id.courseImageId);
        courseImageView.setImageResource(course.getImageResourceId(context));
        TextView courseTextView=view.findViewById(R.id.courseName);
        courseTextView.setText(course.getCourseName());
        return view;
    }
}
