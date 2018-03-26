package com.example.usuario.listviewpersonalizado;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ListView listView;
    private List<String> names;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = (ListView)findViewById(R.id.listView);

        names = new ArrayList<String>();
        names.add("juan");
        names.add("pedro");
        names.add("antonio");
        names.add("pepe");
        names.add("ana");
        names.add("juan");
        names.add("pedro");
        names.add("antonio");
        names.add("pepe");
        names.add("ana");
        names.add("juan");
        names.add("pedro");
        names.add("antonio");
        names.add("pepe");
        names.add("ana");

        final MyAdapter adapter = new MyAdapter(this,R.layout.list_item,names);

        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                Toast.makeText(MainActivity.this,i + " " + l + " " + adapterView.getAdapter().getItem(i).toString(),Toast.LENGTH_SHORT).show();
            }
        });
        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(MainActivity.this,adapterView.getAdapter().getItem(i).toString().toUpperCase(),Toast.LENGTH_SHORT).show();
                return false;
            }
        });
    }

}
 class MyAdapter extends BaseAdapter{
    private Context context;
    private int layout;
    private List<String> names;

    public MyAdapter(Context context, int layout, List<String> names) {
        this.context = context;
        this.layout = layout;
        this.names = names;
    }

    @Override
    public int getCount() {
        if (this.names != null){
            return this.names.size();
        }else {
            return 0;
        }
    }

    @Override
    public Object getItem(int i) {
        return this.names.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View convertView, ViewGroup viewGroup) {

        View v = convertView;

        LayoutInflater layoutInflater = LayoutInflater.from(this.context);
        v = layoutInflater.inflate(R.layout.list_item,null);
        String nombre = names.get(i);
        TextView textView = v.findViewById(R.id.textView);
        textView.setText(nombre);
        return v;
    }
}


