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
        articleModels.add(new ArticleModel(0, "L'info pour les nuls", "Ceci est un contenu\n" +
                "La longueur devrait être assez grande pour tester maintenant :)", "Jehan",
                new Date(1995,11,12), "politique", "image",
                "http://static.eyrolles.com/img/2/7/5/4/0/3/1/7/9782754031790_h430.jpg"));
        articleModels.add(new ArticleModel(1, "Troll", "Ceci est un contenu\n" +
                "La longueur devrait être assez grande pour tester maintenant :)", "Jehan",
                new Date(1995,11,12), "politique", "video",
                "https://www.youtube.com/watch?v=dQw4w9WgXcQ"));
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
