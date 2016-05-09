package com.zc741.navigationdrawer;

import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class CoordinatorLayouttActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_collasing_toolbar_layout);

        Toolbar collasingToolbar = (Toolbar) findViewById(R.id.collasing_toolbar);
        collasingToolbar.setTitle("CoordinatorLayout");
        collasingToolbar.setNavigationIcon(R.mipmap.ic_arrow_back);
        collasingToolbar.inflateMenu(R.menu.base_toolbar_menu);
        collasingToolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        collasingToolbar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.action_search:
                        Toast.makeText(getApplicationContext(), "search", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.action_notification:
                        Toast.makeText(getApplicationContext(), "notification", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.action_item1:
                        Toast.makeText(getApplicationContext(), "设置", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.action_item2:
                        Toast.makeText(getApplicationContext(), "模式", Toast.LENGTH_SHORT).show();
                        break;
                }
                return true;
            }
        });

        TabLayout coordinatorLayout = (TabLayout) findViewById(R.id.collasing_tablayout);
        coordinatorLayout.setTabMode(TabLayout.MODE_FIXED);
        coordinatorLayout.setTabTextColors(Color.WHITE,Color.LTGRAY);

        final List<MyFragment> myFragments = new ArrayList<>();
        final List<String> tabtitles = new ArrayList<>();
        for (int i = 1; i <= 4; i++) {
            tabtitles.add("Tab" + i);
            myFragments.add(MyFragment.newInstance("fragment" + i));
        }

        ViewPager view_pager = (ViewPager) findViewById(R.id.view_pager);
        view_pager.setOffscreenPageLimit(myFragments.size());

        view_pager.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager()) {

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
        coordinatorLayout.setupWithViewPager(view_pager);

    }
}
