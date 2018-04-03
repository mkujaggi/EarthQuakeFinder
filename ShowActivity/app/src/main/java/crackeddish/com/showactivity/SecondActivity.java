package crackeddish.com.showactivity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    private TextView showMessage;
    private Button backButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        Bundle extras=getIntent().getExtras();
        showMessage=(TextView)findViewById(R.id.messageTextView);
        backButton=(Button)findViewById(R.id.goBAckButtonID);
        if (extras!=null)
        {
            String message=extras.getString("Message");
            int myInt=extras.getInt("Value");
            showMessage.setText("Messages from first "+message+" "+String.valueOf(myInt));
        }

        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent returnIntent=getIntent();
                returnIntent.putExtra("returnData","From second Activity");
                setResult(RESULT_OK,returnIntent);
                finish();
            }
        });
    }
}
