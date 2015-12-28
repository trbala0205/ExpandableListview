package com.bala.expandablelistview;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ExpandableListView;

public class MainActivity extends AppCompatActivity {

	private Toolbar toolbar;
	private static ExpandableListView expandableListView;
	private static ExpandableListAdapter adapter;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        
		expandableListView = (ExpandableListView) findViewById(R.id.simple_expandable_listview);
		// Setting group indicator null for custom indicator
		expandableListView.setGroupIndicator(null);
		
		setItems();
		//setListener();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
	
	// Setting headers and childs to expandable listview
	void setItems(){
		
		// Array list for header
		ArrayList<String> header = new ArrayList<String>();
		
		// Array list for child items
		List<String> child1 = new ArrayList<String>();
		List<String> child2 = new ArrayList<String>();
		List<String> child3 = new ArrayList<String>();
		List<String> child4 = new ArrayList<String>();
		
		// Hash map for both header and child
		HashMap<String, List<String>> hashMap = new HashMap<String, List<String>>();
		
		// Adding headers to list
		for (int i = 1; i < 5; i++) {
			header.add("Group " + i);
		}
		// Adding child data
		for (int i = 1; i < 5; i++) {
			child1.add("Group 1  " + " : Child" + i);
		}
		// Adding child data
		for (int i = 1; i < 5; i++) {
			child2.add("Group 2  " + " : Child" + i);
		}
		// Adding child data
		for (int i = 1; i < 6; i++) {
			child3.add("Group 3  " + " : Child" + i);
		}
		// Adding child data
		for (int i = 1; i < 7; i++) {
			child4.add("Group 4  " + " : Child" + i);
		}
		
		// Adding header and childs to hash map
		hashMap.put(header.get(0), child1);
		hashMap.put(header.get(1), child2);
		hashMap.put(header.get(2), child3);
		hashMap.put(header.get(3), child4);
		
		adapter = new ExpandableListAdapter(MainActivity.this, header, hashMap);
		// Setting adpater over expandablelistview
		expandableListView.setAdapter(adapter);
		
	}
}
