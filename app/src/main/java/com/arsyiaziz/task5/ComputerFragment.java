package com.arsyiaziz.task5;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class ComputerFragment extends Fragment implements OnItemClickListener<ComputerModel>{
    private RecyclerView rvComputer;
    private ComputerRecyclerAdapter adapter;

    public static ComputerFragment newInstance() {
        ComputerFragment fragment = new ComputerFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_computer, container, false);
        rvComputer = rootView.findViewById(R.id.rv_computer);
        adapter = new ComputerRecyclerAdapter();
        adapter.setComputers(ComputerDatabase.getComputers());
        rvComputer.setLayoutManager(new LinearLayoutManager(getActivity()));
        rvComputer.setHasFixedSize(true);
        adapter.setClickListener(this);
        rvComputer.setAdapter(adapter);
        return rootView;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onClick(ComputerModel computerModel) {
        Intent intent = new Intent(getActivity(), DetailActivity.class);
        intent.putExtra(DetailActivity.details, computerModel);
        startActivity(intent);
    }
}