package com.example.myappli;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import java.util.ArrayList;

public class Sinner extends Fragment {

    MainActivity activity;
    RecyclerView recyclerView;
    SingerAdapter adapter;
    ArrayList<SingerDTO> dtos;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        View view = (ViewGroup) inflater.inflate(R.layout.sinner,
                container, false);


        // 반드시 생성해서 어댑터에 넘겨야 함
        dtos = new ArrayList<>();
        activity = (MainActivity)getActivity();
        recyclerView = view.findViewById(R.id.recyclerView);
        // recyclerView에서 반드시 아래와 같이 초기화를 해줘야 함
        LinearLayoutManager layoutManager = new
                LinearLayoutManager(
                activity.getApplicationContext(), RecyclerView.HORIZONTAL, false);
        recyclerView.setLayoutManager(layoutManager);

        // 어댑터 객체 생성
        adapter = new
                SingerAdapter(activity.getApplicationContext(), dtos,activity);

        // 어댑터에 있는 ArrayList<SingerDTO> dtos에 dto 추가
        adapter.addDto(new SingerDTO("무등산",R.drawable.mountainmu));
        adapter.addDto(new SingerDTO("어등산",R.drawable.mountainmu));

        // 만든 어댑터를 리싸이클러뷰에 붙인다
        recyclerView.setAdapter(adapter);




        return view;
    }


}