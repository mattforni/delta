package com.example.del;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import android.annotation.SuppressLint;
import android.app.ActionBar;
import android.app.Activity;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.view.Menu;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TabHost;
import android.widget.TabHost.OnTabChangeListener;
import android.widget.TabHost.TabSpec;
import android.widget.TextView;

@SuppressLint("NewApi")
public class MainActivity extends Activity implements OnTabChangeListener, OnPageChangeListener{ 
    private TabHost host;  
    private ViewPager pager;
    
public void onCreate(Bundle savedInstanceState) {  
   super.onCreate(savedInstanceState);
   ActionBar actionBar = getActionBar();
   actionBar.hide();
   setContentView(R.layout.activity_main);  
   
   // tab stuff
   
   host = (TabHost)findViewById(android.R.id.tabhost);  
   pager = (ViewPager) findViewById(R.id.pager);  
   
   host.setup();  
   TabSpec spec = host.newTabSpec("tab1");  
   spec.setContent(R.id.library);  
   spec.setIndicator("LIBRARY");   
   host.addTab(spec);  
   
   spec = host.newTabSpec("tab2");  
   spec.setContent(R.id.player);  
   spec.setIndicator("PLAYER");  
   host.addTab(spec);
   
   spec = host.newTabSpec("tab3");  
   spec.setContent(R.id.playlist);  
   spec.setIndicator("PLAYLIST");  
   host.addTab(spec);  
   
   pager.setAdapter(new MyPagerAdapter(this));  
   pager.setOnPageChangeListener(this);  
   host.setOnTabChangedListener(this);
   setTabColor(host);
   
   // list stuff
   
   initList();

   // We get the ListView component from the layout
   ListView lv = (ListView) findViewById(R.id.listView);

   // This is a simple adapter that accepts as parameter
   // Context
   // Data list
   // The row layout that is used during the row creation
   // The keys used to retrieve the data
   // The View id used to show the data. The key number and the view id must match
   SimpleAdapter simpleAdpt = new SimpleAdapter(this, planetsList, R.layout.list_item, new String[] {"planet"}, new int[] {R.id.list_item_text});

   lv.setAdapter(simpleAdpt);
   
   // font stuff
   
   Typeface tf = Typeface.createFromAsset(getAssets(),
           "fonts/impact.ttf");
   
   TextView tvCurrentSong = (TextView) findViewById(R.id.current_song);
   TextView tvCurrentArtist = (TextView) findViewById(R.id.current_artist);
   
   tvCurrentSong.setTypeface(tf);
   tvCurrentArtist.setTypeface(tf);
 }  
    @Override  
    public void onTabChanged(String tabId){  
         int pageNumber = 0;  
         if(tabId.equals("tab1")){  
              pageNumber = 0;  
         } else if(tabId.equals("tab2")){  
              pageNumber = 1;  
         } else{  
              pageNumber = 2;  
         } 
         pager.setCurrentItem(pageNumber);
         setTabColor(host);
    }
    
    public void setTabColor(TabHost tabhost) {
        for(int i=0;i<tabhost.getTabWidget().getChildCount();i++) {
            tabhost.getTabWidget().getChildAt(i).setBackgroundColor(getResources().getColor(R.color.unselected_tab_bg)); //unselected
        }
        tabhost.getTabWidget().getChildAt(tabhost.getCurrentTab()).setBackgroundColor(getResources().getColor(R.color.selected_tab_bg)); // selected
    }
    
    @Override  
    public void onPageSelected(int pageNumber) {  
         host.setCurrentTab(pageNumber);
    } 
        @Override
        public boolean onCreateOptionsMenu(Menu menu) {
                // Inflate the menu; this adds items to the action bar if it is present.
                getMenuInflater().inflate(R.menu.main, menu);
                return true;
        }
		@Override
		public void onPageScrollStateChanged(int arg0) {
			// TODO Auto-generated method stub
			
		}
		@Override
		public void onPageScrolled(int arg0, float arg1, int arg2) {
			// TODO Auto-generated method stub
			
		}

		List<HashMap<String, String>> planetsList = new ArrayList<HashMap<String,String>>();

		   private void initList() {
		    // We populate the planets

		    planetsList.add(createPlanet("planet", "Mercury"));
		    planetsList.add(createPlanet("planet", "Venus"));
		    planetsList.add(createPlanet("planet", "Mars"));
		    planetsList.add(createPlanet("planet", "Jupiter"));
		    planetsList.add(createPlanet("planet", "Saturn"));
		    planetsList.add(createPlanet("planet", "Uranus"));
		    planetsList.add(createPlanet("planet", "Neptune"));
		    planetsList.add(createPlanet("planet", "Mercury"));
		    planetsList.add(createPlanet("planet", "Venus"));
		    planetsList.add(createPlanet("planet", "Mars"));
		    planetsList.add(createPlanet("planet", "Jupiter"));
		    planetsList.add(createPlanet("planet", "Saturn"));
		    planetsList.add(createPlanet("planet", "Uranus"));
		    planetsList.add(createPlanet("planet", "Neptune"));
		    planetsList.add(createPlanet("planet", "Mercury"));
		    planetsList.add(createPlanet("planet", "Venus"));
		    planetsList.add(createPlanet("planet", "Mars"));
		    planetsList.add(createPlanet("planet", "Jupiter"));
		    planetsList.add(createPlanet("planet", "Saturn"));
		    planetsList.add(createPlanet("planet", "Uranus"));
		    planetsList.add(createPlanet("planet", "Neptune"));

		}

		private HashMap<String, String> createPlanet(String key, String name) {
		    HashMap<String, String> planet = new HashMap<String, String>();
		    planet.put(key, name);

		    return planet;
		}
		
}