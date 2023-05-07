package com.example.test2.a;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

class ViewPager2Adapter extends FragmentStateAdapter {

    public ViewPager2Adapter(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        // 每个页面对应的fragment
        switch (position){
            case 0:return   A_Fragment.newInstance("1","");
            case 1:return   A_Fragment.newInstance("2","");
            case 2:return   A_Fragment.newInstance("3","");
            case 3:return   A_Fragment.newInstance("4","");
        }

        return null;
    }

    @Override
    public int getItemCount() {
        // 有几个页面就返回几
        return 4;
    }
}
