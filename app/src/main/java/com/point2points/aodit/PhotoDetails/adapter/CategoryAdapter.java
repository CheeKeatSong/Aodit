package com.point2points.aodit.PhotoDetails.adapter;

import android.content.Context;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.point2points.aodit.PhotoDetails.holder.CategoryHolder;
import com.point2points.aodit.PhotoDetails.model.Category;
import com.point2points.aodit.R;

import java.util.ArrayList;

/**
 * Created by Edwin on 18/9/2016.
 */
public class CategoryAdapter extends RecyclerView.Adapter<CategoryHolder> {

    private Context mContext;
    private LayoutInflater mInflater;
    private ArrayList<Category> mCategory = new ArrayList<>();

    public CategoryAdapter(Context context, ArrayList<Category> categories) {
        this.mContext = context;
        this.mCategory = categories;
        this.mInflater = LayoutInflater.from(context);
    }

    @Override
    public CategoryHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.custom_photo_row, parent, false);
        return new CategoryHolder(view);
    }

    @Override
    public void onBindViewHolder(CategoryHolder holder, int position) {
        holder.getmTxtCategoryName().setText(mCategory.get(position).getCategoryName());

        if (mCategory.get(position).getCategoryName().equals(mContext.getString(R.string.food))){
            holder.getmLnBackground().setBackgroundColor(ContextCompat.getColor(mContext, R.color.color_hue));
            holder.getmImgCategoryIcon().setImageResource(R.mipmap.summary_food);
        } else  if (mCategory.get(position).getCategoryName().equals(mContext.getString(R.string.other))){
            holder.getmLnBackground().setBackgroundColor(ContextCompat.getColor(mContext, R.color.tabs_secodary));
            holder.getmImgCategoryIcon().setImageResource(R.mipmap.summary_other);
        } else  if (mCategory.get(position).getCategoryName().equals(mContext.getString(R.string.groceries))){
            holder.getmLnBackground().setBackgroundColor(ContextCompat.getColor(mContext, R.color.color_dark));
            holder.getmImgCategoryIcon().setImageResource(R.mipmap.summary_groceries);
        } else  if (mCategory.get(position).getCategoryName().equals(mContext.getString(R.string.transport))){
            holder.getmLnBackground().setBackgroundColor(ContextCompat.getColor(mContext, R.color.color_tetiary));
            holder.getmImgCategoryIcon().setImageResource(R.mipmap.summary_transport);
        } else  if (mCategory.get(position).getCategoryName().equals(mContext.getString(R.string.utility))){
            holder.getmLnBackground().setBackgroundColor(ContextCompat.getColor(mContext, R.color.color_warm));
            holder.getmImgCategoryIcon().setImageResource(R.mipmap.summary_utility);
        } else  if (mCategory.get(position).getCategoryName().equals(mContext.getString(R.string.entertaiment))){
            holder.getmLnBackground().setBackgroundColor(ContextCompat.getColor(mContext, R.color.color_cool));
            holder.getmImgCategoryIcon().setImageResource(R.mipmap.summary_entertainment);
        }
    }

    @Override
    public int getItemCount() {
        return mCategory.size();
    }
}
