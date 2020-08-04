package com.approcket.checkbox_recycle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements ProgrammingAdapter.CheckBoxCheckedListener {
    String[] s;
    ProgrammingAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        RecyclerView recyclerView = findViewById(R.id.recyclerview);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        s = new String[]{"java", "res", "frag", "viewgroup", "view pager", "android", "txt", "development", "ranji trophy"};
        adapter=new ProgrammingAdapter(s,MainActivity.this);
        recyclerView.setAdapter(adapter);
       adapter.setCheckBoxCheckedListener(this);
    }

    @Override
    public void getCheckBoxCheckedListener(int position) {
        Toast.makeText(this, s[position], Toast.LENGTH_SHORT).show();
    }
}