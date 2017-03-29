package com.example.android.polynews;

import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by Jehan on 22/03/2017.
 */

public class NewsGridFragment extends Fragment {
    /**
     * The fragment argument representing the section number for this
     * fragment.
     */
    private static final String ARG_GRID_NUMBER = "grid_number";
    private List<ArticleModel> articleModels;

    public NewsGridFragment() {
        articleModels = new ArrayList<>();
        articleModels.add(new ArticleModel(0, "Cours d'info", "Ceci est un contenu\n" +
                "La longueur devrait être assez grande pour tester maintenant :)", "Jehan",
                new Date(1995,11,12), "Informatique", "image",
                "http://static.eyrolles.com/img/2/7/5/4/0/3/1/7/9782754031790_h430.jpg"));
        articleModels.add(new ArticleModel(0, "Tout là haut", "Pas beaucoup de contenu ici :x", "Jehan",
                new Date(1995,11,12,15,10), "Film", "image",
                "http://www.menucool.com/slider/jsImgSlider/images/image-slider-2.jpg"));
        articleModels.add(new ArticleModel(0, "Ｏ(≧▽≦)Ｏ", "Ces chats sont trop mignons. Le 5ème est tout fou !", "Jehan",
                new Date(1995,11,12), "Chat", "image",
                "https://beebom.com/wp-content/uploads/2016/01/Reverse-Image-Search-Engines-Apps-And-Its-Uses-2016.jpg"));
        articleModels.add(new ArticleModel(1, "Troll", "Mon dieu mais c'est une vidéo ! Que faire ?", "Jehan",
                new Date(1995,11,12), "Distraction", "video",
                "https://www.youtube.com/watch?v=dQw4w9WgXcQ"));
        articleModels.add(new ArticleModel(0, "Space", "Vers l'infini et au delà", "Jehan",
                new Date(1995,11,12), "Science", "image",
                "https://airbusdefenceandspace.com/wp-content/uploads/2016/09/earth-view-from-satellite-space-systems-cover.jpg"));


    }

    /**
     * Returns a new instance of this fragment for the given section
     * number.
     */
    public static NewsGridFragment newInstanceGrid(int sectionNumber) {
        NewsGridFragment fragment = new NewsGridFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_GRID_NUMBER, sectionNumber);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_newsgrid, container, false);
        return rootView;
    }

    @Override
    public void onActivityCreated(Bundle bundle){
        super.onActivityCreated(bundle);
        GridView gridView = (GridView) getView().findViewById(R.id.section_grid_label);
        gridView.setAdapter(new NewsCustomAdapter(this.getActivity(), articleModels));

    }
}
