package com.point2points.aodit.DashBoard.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.point2points.aodit.DashBoard.adapter.ReceiptAdapter;
import com.point2points.aodit.DashBoard.model.Receipt;
import com.point2points.aodit.R;

import java.util.ArrayList;

/**
 * Created by Edwin on 14/9/2016.
 */
public class ReceiptFragment extends Fragment {
    private RecyclerView mRecyclerView;
    private ArrayList<Receipt> mReceipt = new ArrayList<>();
    private ReceiptAdapter mAdapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_receipt, container, false);

        addReceipt();
        mRecyclerView = (RecyclerView) view.findViewById(R.id.recyclerView);
        mRecyclerView.setHasFixedSize(true);
        mAdapter = new ReceiptAdapter(getActivity(), mReceipt);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        mRecyclerView.setAdapter(mAdapter);

        return view;
    }

    private void addReceipt() {
        String[] receiptName = {"Shell Refuel", "Golden Screen Cinema", "MCD Lunch", "Shopping for iphone", "Shopping for clothes"};
        String[] receiptDate = {"12 November 2016", "10 November 2016", "3 November 2016", "27 October 2016", "25 October 2016"};
        String[] receiptLocation = {"Usj 11/4b", "Summit USJ", "Taipan USJ", "Subang Parade", "Sunway"};
        String[] receiptNote = {"Nothing", "Claim Voucher", "Claim from office", "Over spent budget", "Budget maintained"};
        String[] receiptPrice = {"RM50.00", "RM20.00", "RM10.00", "RM3500.00", "RM199.99"};
        int[] receiptType = {R.mipmap.receipt_utility,R.mipmap.receipt_entertainment,R.mipmap.receipt_food,R.mipmap.receipt_groceries
        ,R.mipmap.receipt_other};

        for (int i = 0; i < 5; i++) {
            Receipt receipt = new Receipt();
            receipt.setReceiptName(receiptName[i]);
            receipt.setReceiptDate(receiptDate[i]);
            receipt.setReceiptLocation(receiptLocation[i]);
            receipt.setReceiptType(receiptType[i]);
            receipt.setReceiptNote(receiptNote[i]);
            receipt.setReceiptPrice(receiptPrice[i]);
            mReceipt.add(receipt);
        }
    }
}
