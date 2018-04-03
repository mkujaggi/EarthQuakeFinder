package fragmentmycourse.crackeddish.com.mycourselistfragment;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import fragmentmycourse.crackeddish.com.mycourselistfragment.data.Course;

public class MainActivity extends AppCompatActivity implements CourseListFragment.Callbacks {

    private boolean isTwoPage=false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (findViewById(R.id.detailContainer)!=null){
            isTwoPage=true;
        }

    }

    @Override
    public void onItemSelected(Course course,int position) {
        if (isTwoPage){
            Bundle bundle=new Bundle();
            bundle.putInt("course_id",position);
            FragmentManager  fm=getSupportFragmentManager();
            CourseDetailFragment courseDetailFragment=new CourseDetailFragment();
            courseDetailFragment.setArguments(bundle);
            Fragment fragment= fm.findFragmentById(R.id.myContainer);

            fm.beginTransaction().replace(R.id.detailContainer, courseDetailFragment).commit();

        }else {
            Intent intent=new Intent(MainActivity.this,CourseDetailActivity.class);
            intent.putExtra("course_id",position);
            startActivity(intent);
        }


    }
}
