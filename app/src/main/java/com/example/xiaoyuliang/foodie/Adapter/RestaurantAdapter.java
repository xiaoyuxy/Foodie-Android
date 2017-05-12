package com.example.xiaoyuliang.foodie.Adapter;

import android.content.Context;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.example.xiaoyuliang.foodie.R;
import com.example.xiaoyuliang.foodie.SingleRestaurant;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * Created by xiaoyuliang on 5/8/17.
 */
public class RestaurantAdapter extends BaseAdapter {
    ArrayList<SingleRestaurant>  res_list;
    Context mcontext;
    private LayoutInflater mInflater;

    public RestaurantAdapter(Context context, ArrayList<SingleRestaurant> res_list)
    {
        mcontext = context;
        this.res_list = res_list;
        mInflater = (LayoutInflater) mcontext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }
    @Override
    public int getCount() {
        return res_list.size();
    }
    @Override
    public Object getItem(int position) {
        return res_list.get(position);
    }
    @Override
    public long getItemId(int position) {
        return position;
    }


//    @Override
//    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
//        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_restaurant,parent,false);
//        ViewHolder view_holder = new ViewHolder(view);
//        return view_holder;
//    }
//
//    @Override
//    public void onBindViewHolder(ViewHolder holder, int position) {
//        if(ress!=null){
//            if(ress.get(position).getText()!=null){
//                holder.nameRes.setText(ress.get(position).getRestaurant());
//
//                //change distance to km amd m
//                String distance = "";
//                Random random = new Random();
//                int distInt = random.nextInt();
//
//                if(distInt/1000 > 0)
//                {distance = distance + distInt/1000+" KM ";}
//
//                if(distInt%1000 > 0)
//                {distance = distance + distInt%1000+" M ";}
//
//                distance = distance + "away";
//
//                holder.distanceRes.setText(distance);
//                holder.ratingRes.setRating(random.nextFloat() % 6);
//            }
//
//            Glide.with(context).load(ress.get(position).getUrl()).asBitmap().
//                    diskCacheStrategy(DiskCacheStrategy.ALL).into(holder.imageRes);
//
//        }
//    }


    public View getView(int position, View convertView, ViewGroup parent) {

        ViewHolder holder;

        // check if the view already exists if so, no need to inflate and findViewById again!
        if (convertView == null) {

            // Inflate the custom row layout from your XML.
            convertView = mInflater.inflate(R.layout.item_restaurant, parent, false);

            // create a new "Holder" with subviews
            holder = new ViewHolder();
            holder.thumbnailImageView = (ImageView) convertView.findViewById(R.id.imageRes);
            holder.titleTextView = (TextView) convertView.findViewById(R.id.nameRes);
            holder.ratingbar = (RatingBar) convertView.findViewById(R.id.ratingRes);
            holder.detailTextView = (TextView) convertView.findViewById(R.id.distanceRes);

            // hang onto this holder for future recyclage
            convertView.setTag(holder);
        }
        else {

            // skip all the expensive inflation/findViewById and just get the holder you already made
            holder = (ViewHolder) convertView.getTag();
        }

        // Get relevant subviews of row view
        TextView titleTextView = holder.titleTextView;
        RatingBar ratingbar = holder.ratingbar;
        TextView detailTextView = holder.detailTextView;
        ImageView thumbnailImageView = holder.thumbnailImageView;

        //Get corresponding recipe for row
        SingleRestaurant res = (SingleRestaurant) getItem(position);

        // Update row view's textviews to display recipe information
        titleTextView.setText(res.name);
        ratingbar.setRating(res.rank);
        detailTextView.setText(res.distance );

        // Use Picasso to load the image. Temporarily have a placeholder in case it's slow to load
        Picasso.with(mcontext).load(res.image).placeholder(com.example.xiaoyuliang.foodie.R.mipmap
                .ic_launcher).into(thumbnailImageView);

        // Style text views
        Typeface titleTypeFace = Typeface.createFromAsset(mcontext.getAssets(),
                "fonts/JosefinSans-Bold.ttf");
        titleTextView.setTypeface(titleTypeFace);
        Typeface subtitleTypeFace = Typeface.createFromAsset(mcontext.getAssets(),
                "fonts/JosefinSans-SemiBoldItalic.ttf");
        Typeface detailTypeFace = Typeface.createFromAsset(mcontext.getAssets(),
                "fonts/Quicksand-Bold.otf");
        detailTextView.setTypeface(detailTypeFace);

        return convertView;
    }

    private static class ViewHolder {
        public TextView titleTextView;
        public RatingBar ratingbar;
        public TextView detailTextView;
        public ImageView thumbnailImageView;
    }
}
//    public static class ViewHolder extends RecyclerView.ViewHolder
//    {
//        private TextView nameRes,distanceRes;
//        private RatingBar ratingRes;
//        private ImageView imageRes;
//
//        public ViewHolder(View v){
//            super(v);
//            this.imageRes = (ImageView)v.findViewById(R.id.imageRes);
//            this.nameRes = (TextView)v.findViewById(R.id.nameRes);
//            this.ratingRes = (RatingBar)v.findViewById(R.id.ratingRes);
//            this.distanceRes = (TextView)v.findViewById(R.id.distanceRes);
//
//        }
//    }
//}
