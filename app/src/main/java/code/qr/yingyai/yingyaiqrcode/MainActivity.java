package code.qr.yingyai.yingyaiqrcode;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    //Explicit
    private EditText userEditText, passwordEditText;
    private TextView textView;
    private Button button;
    private String userString, passwordString;


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

            //Get value from EditText
            userString = userEditText.getText().toString().trim();
            passwordString = passwordEditText.getText().toString().trim();

            //Check Space
            if (userString.equals("")|| passwordString.equals("")) {
                //Have space
                MyAlert myAlert = new MyAlert(this);
                myAlert.myDialog(getResources().getString(R.string.title_HaveSpace),
                        getResources().getString(R.string.message_HaveSpace));
            } else {
                //No space
                CheckUserandPass();
            }

        }

    }

    private void CheckUserandPass() {
        try {

            GetData getData = new GetData(this);
            MyConstant myConstant = new MyConstant();
            getData.execute(myConstant.getUrlGetUser());
            String stringJSON = getData.get();
            Log.d("17MayV2", "JSON ==>" + stringJSON);

            JSONArray jsonArray = new JSONArray(stringJSON);
            Boolean b = true; // User False
            String strName = null, strPassword = null;
            MyAlert myAlert = new MyAlert(this);

            for (int i=0;i<jsonArray.length();i++) {
                JSONObject jsonObject = jsonArray.getJSONObject(i);
                if (userString.equals(jsonObject.getString("User"))) {
                    b = false;
                    strName = jsonObject.getString("Name");
                    strPassword = jsonObject.getString("Password");

                }
            }   // For

            if (b) {
                //User False
             myAlert.myDialog(getResources().getString(R.string.title_UserFalse),
                     getResources().getString(R.string.message_UserFalse));
            } else if (passwordString.equals(strPassword)) {
                //  Password True
                Toast.makeText(MainActivity.this, "Welcome" + strName, Toast.LENGTH_SHORT).show();

                //Intent to Service
                Intent intent = new Intent(MainActivity.this, ServiceActivity.class);
                intent.putExtra("Login", strName);
                startActivity(intent);
                finish();

            } else {
                //  Password False
                myAlert.myDialog(getResources().getString(R.string.title_PasswordFailse),
                        getResources().getString(R.string.message_PasswordFalse));
            }
        } catch (Exception e) {
            Log.d("17MayV2", "e checkUser ==>" + e.toString());
        }
    }
}   //Main Class
