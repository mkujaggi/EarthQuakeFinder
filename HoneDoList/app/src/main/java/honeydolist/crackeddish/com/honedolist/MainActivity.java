package honeydolist.crackeddish.com.honedolist;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class MainActivity extends AppCompatActivity {

    private Button saveButton;
    private EditText enterMessage;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        saveButton=(Button)findViewById(R.id.button);
        enterMessage=(EditText) findViewById(R.id.editText);
        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!enterMessage.getText().toString().equals("")){
                    writeToFile(enterMessage.getText().toString());
                }else {
                    Toast.makeText(MainActivity.this,"Not Entered enything.",Toast.LENGTH_LONG).show();
                }


            }
        });
        try {
            if (readFromFile()!=null){
                enterMessage.setText(readFromFile());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private void writeToFile(String message){
        try {
            OutputStreamWriter outputStreamWriter=new OutputStreamWriter(openFileOutput("todolist.txt", Context.MODE_PRIVATE));
            outputStreamWriter.write(message);
            outputStreamWriter.close();//Always close  streams
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private String readFromFile() throws IOException {
        String result="";
        try {
            InputStream inputStream=openFileInput("todolist.txt");
            if (inputStream!=null){
                InputStreamReader inputStreamReader=new InputStreamReader(inputStream);
                BufferedReader bufferedReader=new BufferedReader(inputStreamReader);
                String tempString="";
                StringBuilder stringBuilder=new StringBuilder();
                while ((tempString=bufferedReader.readLine())!=null){
                    stringBuilder.append(tempString+"\n");
                    //stringBuilder.append("\n");
                }
                inputStream.close();
                result=stringBuilder.toString();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return result;
    }
}
