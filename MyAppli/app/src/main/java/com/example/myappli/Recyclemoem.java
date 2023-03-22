package com.example.myappli;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

public class Recyclemoem extends Fragment {
    MainActivity activity;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.activity_recyclemoem,
                container, false);
        activity =(MainActivity)getActivity();
        Bundle b = activity.bundle;
        SingerDTO d = (SingerDTO) b.getSerializable("dto");
        TextView t = view.findViewById(R.id.tvMain);
        t.setText(d.name);
        TextView tt = view.findViewById(R.id.textView);
        tt.setText(d.mop);
        TextView ttt = view.findViewById(R.id.textView2);
        ttt.setText(d.content);
        ImageView i = view.findViewById(R.id.img);
        i.setImageResource(d.nameimg);
        ImageView ii = view.findViewById(R.id.imageView);
        ii.setImageResource(d.mapimg);
        ImageView iii = view.findViewById(R.id.imageView2);
        iii.setImageResource(d.contentimg);
        return view;
    }
}
