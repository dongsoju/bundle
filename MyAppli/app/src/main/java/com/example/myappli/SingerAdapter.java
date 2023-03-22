package com.example.myappli;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;


public class SingerAdapter extends
        RecyclerView.Adapter<SingerAdapter.ViewHolder>{
    private static final String TAG = "main:SingerAdapter";

    // 메인에게 넘겨받는것 -> 반드시 : Context, ArrayList<DTO>
    MainActivity activity;
    Context context;
    ArrayList<SingerDTO> dtos;
    Recyclemoem recyclemoem;
    LayoutInflater inflater;

    // 생성자로 메인에서 넘겨받은것들을 연결
    public SingerAdapter(Context context, ArrayList<SingerDTO> dtos, MainActivity a) {
        this.context = context;
        this.dtos = dtos;
        activity = a;
        // 화면 붙이는 객체를 생성
        inflater = LayoutInflater.from(context);
    }

    ////////////////////////////////////////////////////
    // 매소드는 여기에 만든다
    // dtos에 dto를 추가하는 매소드
    public void addDto(SingerDTO dto){
        dtos.add(dto);
    }


   // 화면을 인플레이트 시킨다 (붙인다)
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = inflater.inflate(R.layout.singerview,
                parent, false);

        return new ViewHolder(itemView);
    }

    // 인플레이트 시킨 화면에 데이터를 셋팅시킨다
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, @SuppressLint("RecyclerView") int position) {
        Log.d(TAG, "onBindViewHolder: " + position);

        // dtos에 있는 데이터를 각각 불러온다
        SingerDTO dto = dtos.get(position);
        // 불러온 데이터를 ViewHolder에 만들어 놓은 setDto를
        // 사용하여 데이터를 셋팅시킨다
        holder.setDto(dto);

        // 리싸이클러뷰에 항목을 선택했을때 그 항목을 가져오는 리스너
        holder.parentLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SingerDTO dto1 = dtos.get(position);
                Bundle b = new Bundle();
                b.putSerializable("dto",dto1);
                activity.fragmentControl(new Recyclemoem(),b);
                Toast.makeText(context,
                        "이름 : " + dto1.getName(), Toast.LENGTH_SHORT).show();
            }
        });

    }

    // dtos에 저장된 dto 갯수
    @Override
    public int getItemCount() {
        return dtos.size();
    }

    // 3. xml 파일에서 사용된 모든 변수를 adapter에서 클래스로 선언한다
    public class ViewHolder extends RecyclerView.ViewHolder{
        // singerview.xml 에서 사용된 모든 위젯을 정의한다
        TextView Name, Mop,content;
        ImageView nameimg, mapimg,contentimg;
        LinearLayout parentLayout;

        // singerview.xml에서 정의한 아이디를 찾아 연결시킨다(생성자)
        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            parentLayout = itemView.findViewById(R.id.parentLayout);
            Name = itemView.findViewById(R.id.tvName);
            Mop = itemView.findViewById(R.id.tvMop);
            content = itemView.findViewById(R.id.content);
            nameimg = itemView.findViewById(R.id.nameimg);
            mapimg = itemView.findViewById(R.id.mapimg);
            contentimg = itemView.findViewById(R.id.contentimg);
        }

        // singerview에 데이터를 연결시키는 매소드를 만든다
        public void setDto(SingerDTO dto){
            Name.setText(dto.getName());
            Mop.setText(dto.getMop());
            content.setText(dto.getContent());
            nameimg.setImageResource(dto.getNameimg());
            mapimg.setImageResource(dto.getMapimg());
            contentimg.setImageResource(dto.getContentimg());
        }

    }



}
