package com.codepath.instagramclient;

import android.content.Context;
import android.view.LayoutInflater;
import android.widget.ArrayAdapter;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;


import java.util.List;

public class InstagramPhotosAdapter  extends ArrayAdapter<InstagramPhoto> {
    // What data do we need from the activity
    // Context, Data source
    public InstagramPhotosAdapter(Context context, List<InstagramPhoto> objects) {
        super(context,android.R.layout.simple_list_item_1, objects);
    }
    // What our item looks like
    // Use the template to display each photo
    @Override
    public View getView(int position, View convertView, ViewGroup parent){
        // Get the data item for this position
        InstagramPhoto photo = getItem(position);
        // check if we are using a recycled view
        if (convertView == null){
            // create a new view from template
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.item_photo, parent, false);
        }
        // Lookup the views for populating the data (image, caption)
        TextView tvCaption = (TextView) convertView.findViewById(R.id.tvCaption);
        ImageView ivPhoto = (ImageView) convertView.findViewById(R.id.ivPhoto);
           //  Insert the model data into each of the view items
        tvCaption.setText(photo.caption);
        // Clear out the imageview
        ivPhoto.setImageResource(0);
        // Insert the image using picasso
        Picasso.with(getContext()).load(photo.imageUrl).into(ivPhoto);

        // Return the created item as a view
        return convertView;
    }
}
