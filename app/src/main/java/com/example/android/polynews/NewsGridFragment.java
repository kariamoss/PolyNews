package com.example.android.polynews;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;

import java.io.IOException;
import java.sql.SQLException;
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

    public NewsGridFragment() {}

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
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        NewsDBHelper newsDBHelper = new NewsDBHelper(getActivity());
        try {
            newsDBHelper.createDataBase();
            newsDBHelper.openDataBase();
        } catch (IOException | SQLException e) {
            e.printStackTrace();
        }
        articleModels = newsDBHelper.getAllArticles();
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
