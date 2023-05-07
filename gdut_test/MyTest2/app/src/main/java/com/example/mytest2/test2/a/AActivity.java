


package com.example.mytest2.test2.a;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import com.example.mytest2.R;
import com.google.android.material.tabs.TabLayout;

public class AActivity extends AppCompatActivity {

    private ViewPager2 viewPager2;
    private TabLayout tabLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tow_a);
        viewPager2=findViewById(R.id.viewPager);
        tabLayout=findViewById(R.id.tabLayout2);
        ViewPager2Adapter adapter=new ViewPager2Adapter(this);
        viewPager2.setAdapter(adapter);
        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
           @Override
           public void onTabSelected(TabLayout.Tab tab) {
               System.out.println(tab.getPosition());
               viewPager2.setCurrentItem(tab.getPosition(),false);
           }

           @Override
           public void onTabUnselected(TabLayout.Tab tab) {

           }

           @Override
           public void onTabReselected(TabLayout.Tab tab) {

           }
       });
       viewPager2.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
           @Override
           public void onPageSelected(int position) {
               tabLayout.selectTab(tabLayout.getTabAt(position));

           }
       });

    }
}