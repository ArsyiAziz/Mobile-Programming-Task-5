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

public class DeveloperFragment extends Fragment implements OnItemClickListener<DeveloperModel>{

    private RecyclerView rvDeveloper;
    private DeveloperRecyclerAdapter adapter;

    public static DeveloperFragment newInstance() {
        DeveloperFragment fragment = new DeveloperFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_developer, container, false);
        rvDeveloper = rootView.findViewById(R.id.rv_developer);
        adapter = new DeveloperRecyclerAdapter();
        adapter.setDevelopers(DeveloperDatabase.getDevelopers());
        rvDeveloper.setLayoutManager(new LinearLayoutManager(getActivity()));
        rvDeveloper.setHasFixedSize(true);
        adapter.setClickListener(this);
        rvDeveloper.setAdapter(adapter);
        return rootView;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onClick(DeveloperModel developerModel) {
        Intent intent = new Intent(getActivity(), DeveloperDetailActivity.class);
        intent.putExtra(DeveloperDetailActivity.details, developerModel);
        startActivity(intent);
    }
}