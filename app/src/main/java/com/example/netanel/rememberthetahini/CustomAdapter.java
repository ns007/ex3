package com.example.netanel.rememberthetahini;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by netanel on 03/11/2015.
 */
public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.ViewHolder> {

    private List<Tasks> tasksItems;
    public  CustomAdapter(List<Tasks> tasksItems){
        this.tasksItems = tasksItems;
    }
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // create a new view
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.listitem_tasks, parent, false);

        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        Tasks item = tasksItems.get(position);
        holder.mTaskDescr.setText(item.get_taskname());
        holder.mTaskDone.setText(String.format("%s", "DONE"));
    }

    @Override
    public int getItemCount() {
        return tasksItems.size();
    }

    // Provide a reference to the views for each data item
    // Complex data items may need more than one view per item, and
    // you provide access to all the views for a data item in a view holder
    public static class ViewHolder extends RecyclerView.ViewHolder {
        //Each item is a view in the card.
        private TextView mTaskDescr;
        private Button mTaskDone;
        public ViewHolder(View parentView) {
            super(parentView);
            mTaskDescr = (TextView) parentView.findViewById(R.id.ItemDesc);
            mTaskDone = (Button) parentView.findViewById(R.id.btnDone);
        }
    }
}
