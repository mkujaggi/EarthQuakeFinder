package bawpapp.crackeddish.com.bawp.data;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v4.content.ContextCompat;
import android.support.v7.graphics.Palette;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import bawpapp.crackeddish.com.bawp.R;
import bawpapp.crackeddish.com.bawp.model.Course;
import de.hdodenhof.circleimageview.CircleImageView;

/**
 * Created by mkujaggi on 08-03-2018.
 */

public class CourseListAdapter extends RecyclerView.Adapter<CourseListAdapter.ViewHolder>
implements  View.OnClickListener{
    //private ArrayList<Course> courseArrayList;
    private CourseData courseData=new CourseData();
    public OnItemClickListener itemClickListener;

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View courseRow= LayoutInflater.from(parent.getContext()).inflate(R.layout.course_row,parent,false);
        return new ViewHolder(courseRow);
    }

    @Override
    public void onBindViewHolder(final CourseListAdapter.ViewHolder holder, int position) {

        final Context context=holder.courseTile.getContext();
        Course course=courseData.courseList().get(position);
        holder.courseTile.setText(course.getCourseName());
        Picasso.with(context).load(course.getImageResourseId(context))
                .into(holder.courseImageView);
        Picasso.with(holder.courseTile.getContext()).load(course.getImageResourseId(context))
                .into(holder.authorImageView);
        Bitmap photo= BitmapFactory.decodeResource(context.getResources(),course.getImageResourseId(context));
        Palette.from(photo).generate(new Palette.PaletteAsyncListener() {
            @Override
            public void onGenerated(Palette palette) {
                int bgColor= palette.getMutedColor(ContextCompat.getColor(context,android.R.color.black));
                holder.courseTile.setBackgroundColor(bgColor);
                holder.authorImageView.setBorderColor(bgColor);

            }
        });
    }

    @Override
    public int getItemCount() {
        return courseData.courseList().size();
    }

    public void setOnClickListener(OnItemClickListener itemClickListener){
        this.itemClickListener=itemClickListener;
    }

    @Override
    public void onClick(View v) {

    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        public TextView courseTile;
        public ImageView courseImageView;
        public CircleImageView authorImageView;
        public ViewHolder(View itemView) {
            super(itemView);
            //Very important piece of code ~ register our view to receive click events
            itemView.setOnClickListener(this);
            courseTile=itemView.findViewById(R.id.courseTitleId);
            courseImageView=itemView.findViewById(R.id.courseImageId);
            authorImageView=itemView.findViewById(R.id.authorImageId);
        }

        @Override
        public void onClick(View v) {
            itemClickListener.onItemClick(v,getAdapterPosition());

        }

    }
    public interface OnItemClickListener{
        void onItemClick(View view,int position);
    }
}
