package com.example.android.polynews;

import android.database.Cursor;
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

    public NewsGridFragment() {
        articleModels = new ArrayList<>();
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
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        DataHandler mDbHelper = new DataHandler(this.getContext());
        mDbHelper.createDatabase();
        mDbHelper.open();

        Cursor cursor = mDbHelper.getTestData();
        while(!cursor.isAfterLast()){
            ArticleModel articleModel = new ArticleModel(cursor.getInt(7),
                    cursor.getString(0), cursor.getString(1), cursor.getString(2),
                    cursor.getString(3), cursor.getInt(4),  cursor.getInt(5),
                    cursor.getString(6));
            articleModels.add(articleModel);
            cursor.moveToNext();
        }
        cursor.close();
        mDbHelper.close();
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
