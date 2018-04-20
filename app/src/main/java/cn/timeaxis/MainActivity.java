package cn.timeaxis;

import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import cn.timeaxis.adapter.MyAdapter;
import cn.timeaxis.view.AxisItemDecoration;

public class MainActivity extends AppCompatActivity {

    public static String TAG = "MainActivity ---> ";

    private RecyclerView recyclerView;

    private MyAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.recyclerView);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        adapter = new MyAdapter();
        recyclerView.setAdapter(adapter);

        AxisItemDecoration decoration = new AxisItemDecoration(MainActivity.this, getResIds());
        decoration.setAxisColor(ContextCompat.getColor(this, R.color.colorPrimary));
        decoration.setAxisStroke(6);
        recyclerView.addItemDecoration(decoration);

        adapter.setData(data);

        recyclerView.setNestedScrollingEnabled(false);
        recyclerView.setFocusableInTouchMode(false);

    }

    private List<String> data = new ArrayList<>();

    private List<Integer> getResIds() {
        List<Integer> list = new ArrayList<>();
        for (int i=0; i<20; i++){
            list.add(R.mipmap.ic_launcher_round);
            data.add(String.valueOf("第" + i + "条"));
        }
        return list;
    }


}
