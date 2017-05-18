package code.qr.yingyai.yingyaiqrcode;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONObject;

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
        showText();

        // Create List view
        createListView();


    }// Main Method

    private void createListView() {
        try {

            MyConstant myConstant = new MyConstant();
            String urlJSON = myConstant.getUrlGetProduct();

            GetData getData = new GetData(this);
            getData.execute(urlJSON);
            String strJSON = getData.get();
            Log.d("18MayV1", "JSON ==>" + strJSON);

            JSONArray jsonArray = new JSONArray(strJSON);
            int i = jsonArray.length();
            String[] iconString = new String[i];
            String[] titleStrings = new String[i];
            String[] detailStrings = new String[i];

            for (int i1=0;i1<i;i1++) {

                JSONObject jsonObject = jsonArray.getJSONObject(i1);
                iconString[i1] = jsonObject.getString("Image");
                titleStrings[i1] = jsonObject.getString("Produce");
                detailStrings[i1] = jsonObject.getString("Detail");

            }//For
            MyAdapter myAdapter = new MyAdapter(this, iconString, titleStrings, detailStrings);
            listView.setAdapter(myAdapter);

        } catch (Exception e) {
            Log.d("18MayV1", "e createListView ==>" + e.toString());
        }

    }

    private void showText() {
        nameString = getIntent().getStringExtra("Login");
        textView.setText(nameString);
    }

    private void initialView() {
        textView = (TextView) findViewById(R.id.txtNameLogin);
        brImageView = (ImageView) findViewById(R.id.imvBarCode);
        qrImageView = (ImageView) findViewById(R.id.imvQrCode);
        listView = (ListView) findViewById(R.id.LivProduct);
    }
}   //Main Class
