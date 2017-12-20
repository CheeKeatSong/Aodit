package com.point2points.aodit.DashBoard.adapter;

import android.content.Context;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.point2points.aodit.DashBoard.holder.ReceiptHolder;
import com.point2points.aodit.DashBoard.model.Receipt;
import com.point2points.aodit.R;

import java.util.ArrayList;

/**
 * Created by Edwin on 15/9/2016.
 */
public class ReceiptAdapter extends RecyclerView.Adapter<ReceiptHolder> {
    private Context mContext;
    private LayoutInflater mInflater;
    private ArrayList<Receipt> mReceipt = new ArrayList<>();

    public ReceiptAdapter(Context context, ArrayList<Receipt> receipts) {
        this.mContext = context;
        this.mReceipt = receipts;
        mInflater = LayoutInflater.from(context);
    }

    @Override
    public ReceiptHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.custom_receipt_row, parent, false);
        return new ReceiptHolder(view);
    }

    @Override
    public void onBindViewHolder(ReceiptHolder holder, int position) {
        holder.getmTxtReceiptName().setText(mReceipt.get(position).getReceiptName());
        holder.getmTxtReceiptNote().setText(mReceipt.get(position).getReceiptNote());
        holder.getmTxtReceiptLocation().setText(mReceipt.get(position).getReceiptLocation());
        holder.getmTxtReceiptPrice().setText(mReceipt.get(position).getReceiptPrice());
        holder.getmTxtReceiptDate().setText(mReceipt.get(position).getReceiptDate());

        if (position % 2 == 1) {
            holder.getmLnBackground().setBackgroundColor(ContextCompat.getColor(mContext, R.color.color_accent));
        }

        if (mReceipt.get(position).getReceiptType() != 0) {
            Glide.with(mContext)
                    .load(mReceipt.get(position).getReceiptType())
                    .asBitmap()
                    .diskCacheStrategy(DiskCacheStrategy.ALL)
                    .into(holder.getmImgReceipType());
        }

        if (mReceipt.get(position).getReceiptIcon() != null) {
            Glide.with(mContext)
                    .load(mReceipt.get(position).getReceiptIcon())
                    .asBitmap()
                    .diskCacheStrategy(DiskCacheStrategy.ALL)
                    .into(holder.getmImgReceiptIcon());
        }
    }

    @Override
    public int getItemCount() {
        return mReceipt.size();
    }
}
