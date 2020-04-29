package com.manuver.learner;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import android.widget.TableLayout;
import android.widget.TextView;

import com.google.android.material.tabs.TabLayout;


public class MainActivity extends AppCompatActivity  {

    TextView mTextView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TabLayout tabLayout = findViewById(R.id.tab_layout_main);
        tabLayout.addTab(tabLayout.newTab().setText("Welcome"));
        tabLayout.addTab(tabLayout.newTab().setText("Taylor Swift"));
        tabLayout.addTab(tabLayout.newTab().setText("Raquel Murillo"));
        tabLayout.addTab(tabLayout.newTab().setText("Wonder Woman"));

        mTextView = findViewById(R.id.content_main_text);

        final ViewPager viewPager = findViewById(R.id.view_pager_main);
        viewPager.setAdapter(new FragmentStatePagerAdapter(getSupportFragmentManager(), 3) {

            @NonNull
            @Override
            public Fragment getItem(int position) {
                switch (position) {
                    case 0: return new TabFragment1();
                    case 1: return new TabFragment2();
                    case 2: return new TabFragment3();
                    default: return null;
                }
            }

            @Override
            public int getCount() {
                return 3;
            }
        });

        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }
}
