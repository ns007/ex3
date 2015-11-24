package com.example.netanel.rememberthetahini;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;

import static com.example.netanel.rememberthetahini.TaskListActivity.*;

public class CreateTaskActivity extends AppCompatActivity {

    EditText UserInput;
    DBHandler dbHandler;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_task);
        UserInput = (EditText) findViewById(R.id.userInput);
    }

    /** Called when the user clicks the CREATE button */
    public void addTask(View view) {
        Tasks task = new Tasks(UserInput.getText().toString());
        task.set_id(1);
        myTasks.add(task);
        /*dbHandler = new DBHandler(this,null,null,1);
        dbHandler.addTask(task);*/
        Intent intent = new Intent(this, TaskListActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);// clear back stack
        startActivity(intent);
        finish();
        return;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_create_task, menu);
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
