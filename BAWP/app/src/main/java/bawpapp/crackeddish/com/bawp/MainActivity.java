package bawpapp.crackeddish.com.bawp;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import bawpapp.crackeddish.com.bawp.R;
import bawpapp.crackeddish.com.bawp.controller.CreateAccountActivity;
import bawpapp.crackeddish.com.bawp.controller.DashboardActivity;

public class MainActivity extends AppCompatActivity {
    private EditText usernameEditText;
    private EditText passwordEditText;
    private Button login;
    private TextView createAccountText;
    private TextView errorMessageText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        errorMessageText=(TextView)findViewById(R.id.errorMessage);
        usernameEditText=(EditText)findViewById(R.id.loginUsername);
        passwordEditText=(EditText)findViewById(R.id.loginPassword);
        createAccountText=(TextView)findViewById(R.id.createAccountText);
        errorMessageText.setVisibility(View.INVISIBLE);
        login=(Button) findViewById(R.id.loginButton);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username=usernameEditText.getText().toString();
                String password=passwordEditText.getText().toString();
                if (username.equals("admin")&& password.equals("admin")){
                    errorMessageText.setVisibility(View.INVISIBLE);
                    startActivity(new Intent(MainActivity.this, DashboardActivity.class));
                }else{
                    errorMessageText.setVisibility(View.VISIBLE);
                    errorMessageText.setText(R.string.error_login);
                }

            }
        });


        createAccountText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    startActivity(new Intent(MainActivity.this, CreateAccountActivity.class));

            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_toggle) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
