package com.zc741.navigationdrawer;

import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class TabLayoutActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_tab_layout);

        Toolbar tabToolbar = (Toolbar) findViewById(R.id.tab_toolbar);
        tabToolbar.setTitle("Tabs");
        tabToolbar.setTitleTextColor(Color.WHITE);
        tabToolbar.setNavigationIcon(R.mipmap.ic_arrow_back);
        tabToolbar.inflateMenu(R.menu.base_toolbar_menu);
        tabToolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        tabToolbar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.action_search:
                        Toast.makeText(TabLayoutActivity.this, "search", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.action_notification:
                        Toast.makeText(TabLayoutActivity.this, "notification", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.action_item1:
                        Toast.makeText(TabLayoutActivity.this, "设置", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.action_item2:
                        Toast.makeText(TabLayoutActivity.this, "模式", Toast.LENGTH_SHORT).show();
                        break;
                }
                return true;
            }
        });

        TabLayout tabLayout = (TabLayout) findViewById(R.id.tablayout);
        tabLayout.setTabMode(TabLayout.MODE_FIXED);//设置tabs是否滚动，数量少不滚动
        tabLayout.setTabTextColors(Color.WHITE, Color.LTGRAY);

        final List<MyFragment> myFragments = new ArrayList<>();
        final List<String> tabtitles = new ArrayList<>();
        for (int i = 1; i <= 4; i++) {
            tabtitles.add("Tab" + i);
            myFragments.add(MyFragment.newInstance("Fragment" + i));
        }

        ViewPager viewPager = (ViewPager) findViewById(R.id.viewPager);
        viewPager.setOffscreenPageLimit(myFragments.size());

        viewPager.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager()) {

            @Override
            public CharSequence getPageTitle(int position) {
                return tabtitles.get(position);
            }

            @Override
            public int getCount() {
                return myFragments.size();
            }

            @Override
            public Fragment getItem(int position) {
                return myFragments.get(position);
            }
        });
        tabLayout.setupWithViewPager(viewPager);
    }
}
