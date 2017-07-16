package com.example.saurav.gridview;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    public static String[] imageName = {"Gingerbread", "HoneyComb", "IceCream", "JellyBean", "Lollipop", "Kitkat"};
    public Integer[] mThumbIds = {
            R.drawable.gingerbread, R.drawable.honeycomb,
            R.drawable.icecream, R.drawable.jellybean,
            R.drawable.lollipop, R.drawable.kitkat
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        GridView gridview = (GridView) findViewById(R.id.gridview);
        gridview.setAdapter(new ImageAdapter(this, imageName, mThumbIds));
        gridview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View v,
                                    int position, long id) {
                Toast.makeText(MainActivity.this, " " + position,
                        Toast.LENGTH_SHORT).show();
            }
        });

    }

    public class ImageAdapter extends BaseAdapter {

        private Context mContext;
        String[] result;
        Integer[] imageId;
        private LayoutInflater inflater = null;

        public ImageAdapter(Context c, String[] imageName, Integer[] mthumbIds) {
            mContext = c;
            result = imageName;
            imageId = mThumbIds;
            inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        }

        @Override
        public int getCount() {
            return mThumbIds.length;
        }

        @Override
        public Object getItem(int position) {
            return position;
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        public class Holder {
            TextView textview;
            ImageView imageview;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            Holder holder = new Holder();
            View rowView;

            rowView = inflater.inflate(R.layout.imagename, null);
            holder.textview = (TextView) rowView.findViewById(R.id.textView1);
            holder.imageview = (ImageView) rowView.findViewById(R.id.imageView1);


            holder.textview.setText(result[position]);
            holder.imageview.setImageResource(imageId[position]);

            return rowView;
        }

    }
}
