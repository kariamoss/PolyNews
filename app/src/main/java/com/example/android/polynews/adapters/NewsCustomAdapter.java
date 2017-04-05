package com.example.android.polynews.adapters;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.example.android.polynews.R;
import com.example.android.polynews.models.ArticleModel;
import com.example.android.polynews.models.TypeMedia;

import java.io.IOException;
import java.net.URL;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

/**
 * Created by Jehan on 29/03/2017.
 */

public class NewsCustomAdapter extends ArrayAdapter<ArticleModel> {


    public NewsCustomAdapter(@NonNull Context context, @NonNull List<ArticleModel> objects) {
        super(context, 0, objects);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) getContext()
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        if (convertView == null){
            convertView = inflater.inflate(R.layout.list_item_news, null);
        }
        ArticleModel articleModel = getItem(position);
        if(articleModel != null){
            TextView title = (TextView) convertView.findViewById(R.id.title);
            title.setText(articleModel.getTitle());
            TextView category = (TextView) convertView.findViewById(R.id.category);
            category.setText(articleModel.getCategory());
            TextView date = (TextView) convertView.findViewById(R.id.date);
            SimpleDateFormat myFormat = new SimpleDateFormat("dd/MM HH:mm");
            String time = "";
            try {
                time = myFormat.format(articleModel.getDateFormat().parse(articleModel.getDate()));
            } catch (ParseException e) {
                e.printStackTrace();
            }
            date.setText(time);
            TextView content = (TextView) convertView.findViewById(R.id.content);
            content.setText(articleModel.getContent());

            ImageView imageView = (ImageView) convertView.findViewById(R.id.thumbnail);
            ProgressBar progressBar = (ProgressBar) convertView.findViewById(R.id.pb_loading_indicator);
            ImageView imageView2 = (ImageView) convertView.findViewById(R.id.logoVideo);
            if(articleModel.getTypeMedia() == TypeMedia.VIDEO){

                new AsyncTaskLoadImage(imageView, progressBar).execute(articleModel.getUrlImageForVideo());
                imageView2.setVisibility(View.VISIBLE);
            }
            else {
                new AsyncTaskLoadImage(imageView, progressBar).execute(articleModel.getUrlMedia());
                imageView2.setVisibility(View.INVISIBLE);
            }
        }

        return convertView;
    }
}


class AsyncTaskLoadImage extends AsyncTask<String, Void, Bitmap> {
    private ImageView ivNews;
    private ProgressBar pbNews;

    AsyncTaskLoadImage(ImageView imageView, ProgressBar progressBar){
        ivNews = imageView;
        pbNews = progressBar;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        pbNews.setVisibility(View.VISIBLE);
    }

    @Override
    protected Bitmap doInBackground(String... params) {
        Bitmap image = null;
        try {
            URL url = new URL(params[0]);
            image = BitmapFactory.decodeStream(url.openConnection().getInputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return image;
    }

    @Override
    protected void onPostExecute(Bitmap bitmap) {
        pbNews.setVisibility(View.INVISIBLE);
        if(bitmap != null){
            ivNews.setImageBitmap(bitmap);
        }
    }
}





