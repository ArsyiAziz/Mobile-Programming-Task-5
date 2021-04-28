package com.arsyiaziz.task5;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class DeveloperRecyclerAdapter extends RecyclerView.Adapter<DeveloperRecyclerAdapter.ViewHolder> {
    private List<DeveloperModel> developers;
    private OnItemClickListener<DeveloperModel> clickListener;

    public void setClickListener(OnItemClickListener<DeveloperModel> clickListener) {
        this.clickListener = clickListener;
    }

    @NonNull
    @Override
    public DeveloperRecyclerAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.recycler_developer_item, parent, false);
        return new DeveloperRecyclerAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull DeveloperRecyclerAdapter.ViewHolder holder, int position) {
        holder.onBind(developers.get(position));
    }

    @Override
    public int getItemCount() {
        return developers.size();
    }

    public void setDevelopers(ArrayList<DeveloperModel> developers) {
        this.developers = developers;
    }


    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        DeveloperModel developer;
        TextView tvDeveloperName;
        ImageView ivDeveloperLogo;
        TextView tvDeveloperSummary;
        TextView tvDeveloperHQ;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            itemView.setOnClickListener(this);
            tvDeveloperName = itemView.findViewById(R.id.tv_developer_name);
            ivDeveloperLogo = itemView.findViewById(R.id.iv_developer_logo);
            tvDeveloperSummary = itemView.findViewById(R.id.tv_developer_summary);
            tvDeveloperHQ = itemView.findViewById(R.id.tv_developer_hq);
        }

        public void onBind(DeveloperModel developer) {
            this.developer = developer;
            ivDeveloperLogo.setImageResource(developer.getLogo());
            tvDeveloperHQ.setText(developer.getHQ());
            tvDeveloperName.setText(developer.getName());
            tvDeveloperSummary.setText(developer.getSummary());
        }

        @Override
        public void onClick(View view) {
            clickListener.onClick(developer);
        }
    }
}
