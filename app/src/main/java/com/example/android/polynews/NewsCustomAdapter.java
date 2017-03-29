package com.example.android.polynews;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

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
            date.setText(articleModel.getDate().getDay() + "/" + articleModel.getDate().getMonth()
                    + " " + articleModel.getDate().getHours()
                    + ":"+ articleModel.getDate().getMinutes());
            TextView content = (TextView) convertView.findViewById(R.id.content);
            content.setText(articleModel.getContent());

            ImageView imageView = (ImageView) convertView.findViewById(R.id.thumbnail);
            ProgressBar progressBar = (ProgressBar) convertView.findViewById(R.id.pb_loading_indicator);
            new AsyncTaskLoadImage(imageView, progressBar).execute(articleModel.getUrlMedia());
        }

        return convertView;
    }
}
