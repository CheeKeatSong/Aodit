package com.point2points.aodit.DashBoard.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.point2points.aodit.DashBoard.adapter.SummaryAdapter;
import com.point2points.aodit.DashBoard.model.Summary;
import com.point2points.aodit.R;

import java.util.ArrayList;

/**
 * Created by Edwin on 14/9/2016.
 */
public class SummaryFragment extends Fragment {
    private RecyclerView mRecyclerView;
    private SummaryAdapter mAdapter;
    private ArrayList<Summary> mSummary = new ArrayList<>();
    private Summary summary = new Summary();

    public SummaryFragment() {
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_summary, container, false);
        addSummary();

        setRecyclerView(view);

        return view;
    }

    private void addSummary() {
        String[] title = {getActivity().getString(R.string.food), getActivity().getString(R.string.groceries),
                getActivity().getString(R.string.utility), getActivity().getString(R.string.transport)
                , getActivity().getString(R.string.other), getActivity().getString(R.string.entertaiment)};

        String[] budget = {"RM 65.00", "RM52.99", "RM42.99",
                "RM524.99", "RM855.99", "RM657.00"};

        String[] expenses = {"RM 65.00", "RM52.99", "RM42.99",
                "RM524.99", "RM855.99", "RM657.00"};

        for (int i = 0; i < 6; i++) {
            Summary summary = new Summary();
            summary.setSummaryTitle(title[i]);
            summary.setSummaryBudgetExp(budget[i]);
            summary.setSummaryExpenses(expenses[i]);
            mSummary.add(summary);
        }

        //For budget
        summary.setSummaryExpenditure("RM 500.00");
        summary.setSummaryBudget("RM1000.00");
        summary.setSummaryRemainder("RM500.00");
    }

    private void setRecyclerView(View view) {
        mRecyclerView = (RecyclerView) view.findViewById(R.id.recyclerView);
        mRecyclerView.setHasFixedSize(true);

        mAdapter = new SummaryAdapter(getActivity());
        mAdapter.setSummaryData(mSummary, summary);
        mRecyclerView.setAdapter(mAdapter);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

    }
}
