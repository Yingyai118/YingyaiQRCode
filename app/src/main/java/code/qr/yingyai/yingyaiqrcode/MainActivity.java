package code.qr.yingyai.yingyaiqrcode;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    //Explicit
    private EditText userEditText, passwordEditText;
    private TextView textView;
    private Button button;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Initial View
        InitialView();

        //Controller
        controller();

    }   //Main Method

    private void controller() {

        textView.setOnClickListener(MainActivity.this);
        button.setOnClickListener(MainActivity.this);
    }

    private void InitialView() {

        userEditText = (EditText) findViewById(R.id.edtUser);
        passwordEditText = (EditText) findViewById(R.id.edtPassword);
        textView = (TextView) findViewById(R.id.txtnewregist);
        button = (Button) findViewById(R.id.btnLogin);

    }

    @Override
    public void onClick(View v) {

        //For textview
        if (v == textView) {
            //Intent to Register
            Intent intent = new Intent(MainActivity.this, RegisterActivity.class);
            startActivity(intent);


        }

        //For button
        if (v == button) {

        }

    }
}   //Main Class
