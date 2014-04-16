package com.example.del;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Typeface;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class MyPagerAdapter extends PagerAdapter {  
    private Context ctx;
    public MyPagerAdapter(Context ctx){  
         this.ctx = ctx;  
    }  
    @Override  
    public Object instantiateItem(ViewGroup container, int position) {  
         TextView tView = new TextView(ctx);  
         position++;  
         tView.setText("Page number: " + position);  
         tView.setTextColor(Color.RED);  
         tView.setTextSize(20);
         
         Typeface tf = Typeface.createFromAsset(ctx.getAssets(),
                 "fonts/impact.ttf");
         tView.setTypeface(tf);
         container.addView(tView);
         return tView;  
    }
    
    @Override  
    public int getCount() {  
         return 3;  
    }  
    @Override  
    public boolean isViewFromObject(View view, Object object) {  
         return (view == object);  
    }
    @Override
    public void destroyItem(View container, int position, Object object) {
    // TODO Auto-generated method stub
    ((ViewPager) container).removeView((View) object);
    }
}  