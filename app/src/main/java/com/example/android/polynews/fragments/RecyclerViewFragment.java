package com.example.android.polynews.fragments;

import android.database.Cursor;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;

import com.example.android.polynews.R;
import com.example.android.polynews.adapters.NewsRecyclerViewAdapter;
import com.example.android.polynews.data.DataHandler;
import com.example.android.polynews.models.ArticleModel;

import java.util.ArrayList;
import java.util.List;

import static com.example.android.polynews.data.DataHandler.getArticleFromCursor;

/**
 * Created by Jehan on 05/04/2017.
 */

public class RecyclerViewFragment extends Fragment {
    /**
     * The fragment argument representing the section number for this
     * fragment.
     */
    private List<ArticleModel> articleModels;
    private LinearLayoutManager layoutManager;

    public RecyclerViewFragment() {
        articleModels = new ArrayList<>();
        layoutManager = new LinearLayoutManager(this.getContext());
    }

    /**
     * Returns a new instance of this fragment for the given section
     * number.
     */
    public static RecyclerViewFragment newInstanceGrid() {
        return new RecyclerViewFragment();

    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        DataHandler mDbHelper = new DataHandler(this.getContext());
        mDbHelper.createDatabase();
        mDbHelper.open();

        Cursor cursor = mDbHelper.getTestData();
        while(!cursor.isAfterLast()){
            articleModels.add(getArticleFromCursor(cursor));
            cursor.moveToNext();
        }
        cursor.close();
        mDbHelper.close();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_recycler, container, false);
    }

    @Override
    public void onActivityCreated(Bundle bundle){
        super.onActivityCreated(bundle);
        RecyclerView recyclerView = (RecyclerView) getView().findViewById(R.id.section_recycler_label);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(new NewsRecyclerViewAdapter(articleModels));
    }
}
