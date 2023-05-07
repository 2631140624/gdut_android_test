


package com.example.test2.a;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;
import android.view.View;

import com.example.test1.R;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

public class Two_AActivity extends AppCompatActivity {

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