package com.example.netanel.rememberthetahini;

import android.app.Activity;
import android.app.ListActivity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;

import java.sql.SQLData;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class TaskListActivity extends Activity {

    //private ArrayList<String> myTasks  = new ArrayList<String>();
    public static ArrayList<Tasks> myTasks = new ArrayList<Tasks>();
    //DBHandler dbHandler;
    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task_list);

        mRecyclerView = (RecyclerView)findViewById(R.id.list);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());
        mRecyclerView.setHasFixedSize(true);

        // use a linear layout manager
        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);
        /*for (int i = 0; i < 20; i++) {
            String temp =  "Mock task #" + i;
            myTasks.add(temp);
        }*/
        //dbHandler = new DBHandler(this,null,null,1);
        //printDatabase();
        //ListAdapter taskAdapter = new CustomAdapter(this,myTasks);
        //ListView lv = (ListView) findViewById(R.id.TaskListView);
        //lv.setAdapter(taskAdapter);
        // specify an adapter (see also next example)
        mAdapter = new CustomAdapter(GetTasks());
        mRecyclerView.setAdapter(mAdapter);
    }

    //=====================================================================
    private List<Tasks> GetTasks()
    {
        List<Tasks> taskList = new ArrayList<Tasks>();

        for(int i=0;i<=myTasks.size()-1;i++){
            taskList.add(myTasks.get(i));
        }
        return taskList;
    }

    private void printDatabase() {
        //myTasks = dbHandler.databaseToArraylist();
    }

    /** Called when the user clicks the NewTask button */
    public void NewTask(View view) {
        Intent intent = new Intent(this, CreateTaskActivity.class);
        startActivity(intent);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_task_list, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
