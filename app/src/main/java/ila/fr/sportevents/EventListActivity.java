package ila.fr.sportevents;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;
import java.util.List;

import ila.fr.sportevents.Utils.RecyclerViewAdapter;

public class EventListActivity extends AppCompatActivity {

    List items;
    RecyclerViewAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event_list);

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.myListSimple);

        // fill the list items
        items = new ArrayList<String>();
        for (int i = 0; i < 6; i++) {
            // new item
            items.add("Event " + i);
        }

        adapter = new RecyclerViewAdapter(items, android.R.layout.simple_list_item_1);
        recyclerView.setAdapter(adapter);

        // set the LinearLayoutManager in the recyclerView
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        // Add the RecyclerItemClickListener, to intercept click on his child
        // recyclerView.addOnItemTouchListener(new RecyclerItemClickListener(this, this));

        /* Button Add to add a new item in the list
        Button buttonAdd = (Button) findViewById(R.id.myButtonSimpleAdd);
        buttonAdd.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // add a new item at the end of the list
                add("test " + adapter.getItemCount(), adapter.getItemCount());
            }
        });*/
    }

    /**
     * Add new item , and notify to the adapter that item has been added
     * @param item : the new item
     * @param position : the position of the new item in the list
     */
    public void add(String item, int position) {
        items.add(position, item); // on insère le nouvel objet dans notre liste d'article lié à l'adapter
        adapter.notifyItemInserted(position); // on notifie à l'adapter ce changement
    }

}
