package com.example.a314_debugging;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;
public class Home extends AppCompatActivity {
    RecyclerView recyclerView;
    List_Adapter list_adapter;
    List<Reservations> reserv=new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        indata();
      recyclerView.findViewById(R.id.recyclerView1);
       recyclerView.setLayoutManager(new LinearLayoutManager(this));
        list_adapter=new List_Adapter(reserv);
        recyclerView.setAdapter(list_adapter);
        
    }
    public void indata(){
        Reservations r=new Reservations(R.drawable.pic_base,"21/11/2019","24/11/2019","$300");
        reserv.add(r);
        r=new Reservations(R.drawable.pic_base,"18/12/2019","29/12/2019","$600");
        reserv.add(r);
        r=new Reservations(R.drawable.pic_base,"09/12/2019","14/12/2019","$400");
        reserv.add(r);

    }
}
