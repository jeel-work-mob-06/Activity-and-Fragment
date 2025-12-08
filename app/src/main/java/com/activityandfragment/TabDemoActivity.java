package com.activityandfragment;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabLayout;

public class TabDemoActivity extends AppCompatActivity {

    TabLayout tabLayout;
    ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_tab_demo);

        tabLayout = findViewById(R.id.tablayout);
        viewPager = findViewById(R.id.tabview);

        tabLayout.post(new Runnable() {
            @Override
            public void run() {
                tabLayout.setupWithViewPager(viewPager);
            }
        });

        viewPager.setAdapter(new TabDemoAdapter(getSupportFragmentManager()));


    }

    private class TabDemoAdapter extends FragmentPagerAdapter {
        public TabDemoAdapter(FragmentManager supportFragmentManager) {
            super(supportFragmentManager);
        }

        @Nullable
        @Override
        public CharSequence getPageTitle(int position) {

            switch (position){
                case 0:
                    return "Chat";
                case 1:
                    return "Call";
                case 2:
                    return "Status";
                default:
                    return "Demo";

            }


        }

        @NonNull
        @Override
        public Fragment getItem(int position) {
            switch (position){
                case 0:
                    return new ChatFragment();
                case 1:
                    return new CallFragment();
                case 2:
                    return new StatusFragment();
                default:
                    return new DemoFragment();

            }
        }

        @Override
        public int getCount() {
            return 5;
        }
    }
}