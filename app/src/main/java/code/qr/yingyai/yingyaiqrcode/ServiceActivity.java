package code.qr.yingyai.yingyaiqrcode;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

public class ServiceActivity extends AppCompatActivity {

    //  Explicit
    private TextView textView;
    private ImageView brImageView,qrImageView ;
    private ListView listView;
    private String nameString;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_service);

        //  Initial view

        initialView();

        //Show text

        nameString = getIntent().getStringExtra("Login");
        textView.setText(nameString);


    }// Main Method

    private void initialView() {
        textView = (TextView) findViewById(R.id.txtNameLogin);
        brImageView = (ImageView) findViewById(R.id.imvBarCode);
        qrImageView = (ImageView) findViewById(R.id.imvQrCode);
        listView = (ListView) findViewById(R.id.LivProduct);
    }
}   //Main Class
