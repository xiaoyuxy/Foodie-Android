package com.example.xiaoyuliang.foodie.Adapter;

import android.content.Context;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.xiaoyuliang.foodie.R;
import com.example.xiaoyuliang.foodie.Recommendation;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * Created by xiaoyuliang on 5/11/17.
 */

public class RecommandAdapter extends BaseAdapter {

        public static final String TAG = RecommandAdapter.class.getSimpleName();


        private Context mContext;
        private LayoutInflater mInflater;
        private ArrayList<Recommendation> mDataSource;

        public RecommandAdapter(Context context, ArrayList<Recommendation> items) {
            mContext = context;
            mDataSource = items;
            mInflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        }


    @Override
    public int getCount() {
        return mDataSource.size();
    }

    @Override
    public Object getItem(int position) {
        return mDataSource.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    /**
         * Get a View that displays the data at the specified position in the data set. You can either
         * create a View manually or inflate it from an XML layout file. When the View is inflated, the
         * parent View (GridView, ListView...) will apply default layout parameters unless you use
         * {@link LayoutInflater#inflate(int, ViewGroup, boolean)}
         * to specify a root view and to prevent attachment to the root.
         *
         * @param position    The position of the item within the adapter's data set of the item whose view
         *                    we want.
         * @param convertView The old view to reuse, if possible. Note: You should check that this view
         *                    is non-null and of an appropriate type before using. If it is not possible to convert
         *                    this view to display the correct data, this method can create a new view.
         *                    Heterogeneous lists can specify their number of view types, so that this View is
         *                    always of the right type (see {@link #getViewTypeCount()} and
         *                    {@link #getItemViewType(int)}).
         * @param parent      The parent that this view will eventually be attached to
         * @return A View corresponding to the data at the specified position.
         */
        @Override
        public View getView(int position, View convertView, ViewGroup parent) {

            ViewHolder holder;

            // check if the view already exists if so, no need to inflate and findViewById again!
            if (convertView == null) {

                // Inflate the custom row layout from your XML.
                convertView = mInflater.inflate(R.layout.list_item_recommendation, parent, false);

                // create a new "Holder" with subviews
                holder = new ViewHolder();
                holder.titleTextView = (TextView) convertView.findViewById(R.id.list_title);
                holder.thumbnailImageView = (ImageView) convertView.findViewById(R.id.list_thumbnail);
                holder.subtitleTextView = (TextView) convertView.findViewById(R.id.list_subtitle);
                holder.detailTextView = (TextView) convertView.findViewById(R.id.list_detail);

                //holder.detailTextView = (TextView) convertView.findViewById(com.CMPE277.alltherecipes.R.id.recipe_list_detail);

                // hang onto this holder for future recyclage
                convertView.setTag(holder);
            }
            else {

                // skip all the expensive inflation/findViewById and just get the holder you already made
                holder = (ViewHolder) convertView.getTag();
            }

            // Get relevant subviews of row view
            TextView titleTextView = holder.titleTextView;
            TextView subtitleTextView = holder.subtitleTextView;
            ImageView thumbnailImageView = holder.thumbnailImageView;
            TextView detailTextView = holder.detailTextView;

            //Get corresponding recipe for row
            Recommendation res = (Recommendation) getItem(position);

            // Update row view's textviews to display recipe information
            titleTextView.setText(res.name);
            subtitleTextView.setText(res.discription);
            detailTextView.setText(res.distance);

            // Use Picasso to load the image. Temporarily have a placeholder in case it's slow to load
            Picasso.with(mContext).load(res.image).placeholder(com.example.xiaoyuliang.foodie.R.mipmap
                    .ic_launcher).into(thumbnailImageView);

            // Style text views
            Typeface titleTypeFace = Typeface.createFromAsset(mContext.getAssets(),
                    "fonts/JosefinSans-Bold.ttf");
            titleTextView.setTypeface(titleTypeFace);
            Typeface subtitleTypeFace = Typeface.createFromAsset(mContext.getAssets(),
                    "fonts/JosefinSans-SemiBoldItalic.ttf");
            subtitleTextView.setTypeface(subtitleTypeFace);
            Typeface detailTypeFace = Typeface.createFromAsset(mContext.getAssets(),
                    "fonts/Quicksand-Bold.otf");


            return convertView;
        }

        private static class ViewHolder {
            public TextView titleTextView;
            public TextView subtitleTextView;
            public ImageView thumbnailImageView;
            public TextView detailTextView;
        }
}

