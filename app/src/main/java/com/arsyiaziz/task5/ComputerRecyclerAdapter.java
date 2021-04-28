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

public class ComputerRecyclerAdapter extends RecyclerView.Adapter<ComputerRecyclerAdapter.ViewHolder> {
    private List<ComputerModel> computers;
    private OnItemClickListener<ComputerModel> clickListener;

    public void setClickListener(OnItemClickListener<ComputerModel> clickListener) {
        this.clickListener = clickListener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.recycler_computer_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.onBind(computers.get(position));
    }

    @Override
    public int getItemCount() {
        return computers.size();
    }

    public void setComputers(ArrayList<ComputerModel> computers) {
        this.computers = computers;
    }


    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        ComputerModel computer;
        ImageView ivComputerPhoto;
        TextView tvComputerName;
        TextView tvComputerSummary;
        TextView tvComputerDeveloper;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            itemView.setOnClickListener(this);
            tvComputerName = itemView.findViewById(R.id.tv_computer_name);
            ivComputerPhoto = itemView.findViewById(R.id.iv_computer_photo);
            tvComputerSummary = itemView.findViewById(R.id.tv_computer_summary);
            tvComputerDeveloper = itemView.findViewById(R.id.tv_computer_developer);
        }

        public void onBind(ComputerModel computer) {
            this.computer = computer;
            ivComputerPhoto.setImageResource(computer.getPhoto());
            tvComputerDeveloper.setText(computer.getDeveloper());
            tvComputerName.setText(computer.getName());
            tvComputerSummary.setText(computer.getSummary());
        }

        @Override
        public void onClick(View view) {
            clickListener.onClick(computer);
        }
    }


}
