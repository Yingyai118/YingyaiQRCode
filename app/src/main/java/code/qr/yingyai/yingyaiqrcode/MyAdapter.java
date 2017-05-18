package code.qr.yingyai.yingyaiqrcode;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

/**
 * Created by Chonthicha.Ne on 5/18/2017.
 */

public class MyAdapter extends BaseAdapter{

    private Context context;
    private String[] iconStrings, titleStrings, detailStrings;
    private ImageView imageView;
    private TextView titleTextView , detailTextView;
    private String detailShort;

    public MyAdapter(Context context,
                     String[] iconStrings,
                     String[] titleStrings,
                     String[] detailStrings) {
        this.context = context;
        this.iconStrings = iconStrings;
        this.titleStrings = titleStrings;
        this.detailStrings = detailStrings;
    }

    @Override
    public int getCount() {
        return titleStrings.length;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = layoutInflater.inflate(R.layout.listview_layout, parent, false);

        //Initial view
        imageView = (ImageView) view.findViewById(R.id.ImvIcon);
        titleTextView = (TextView) view.findViewById(R.id.txtTitle);
        detailTextView = (TextView) view.findViewById(R.id.txtDetail);

        //  show text

        titleTextView.setText(titleStrings[position]);
        if (detailStrings[position].length() > 30) {
            detailShort = detailStrings[position].substring(0, 30) + "...";

        } else {
            detailShort = detailStrings[position];
        }
        detailTextView.setText(detailShort);

        //  show image

        Picasso.with(context).load(iconStrings[position]).into(imageView);


        return view;
    }
}   //Main Class
