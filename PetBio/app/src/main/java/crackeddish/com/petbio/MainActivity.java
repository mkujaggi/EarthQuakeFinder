package crackeddish.com.petbio;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private ImageView catView;
    private ImageView dogView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        catView=(ImageView)findViewById(R.id.catID);
        dogView=(ImageView)findViewById(R.id.dogID);
        catView.setOnClickListener(this);
        dogView.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.catID:
                //go to second activity
                Intent intentCat=new Intent(MainActivity.this,BioActivity.class);
                intentCat.putExtra("name","Jarvis");
                intentCat.putExtra("bio","Great cat love people and purr a lot.");
                startActivity(intentCat);
                break;
            case R.id.dogID:
                //go to second activity
                Intent intentDog=new Intent(MainActivity.this,BioActivity.class);
                intentDog.putExtra("name","Dufus");
                intentDog.putExtra("bio","Great dog love people only barks at strangers.");
                startActivity(intentDog);
                break;
        }
    }
}
