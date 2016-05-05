package com.zc741.navigationdrawer;

import android.graphics.Color;
import android.support.design.widget.TabLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.Toast;

public class CoordinatorLayouttActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_collasing_toolbar_layout);

        Toolbar collasingToolbar = (Toolbar) findViewById(R.id.collasing_toolbar);
        collasingToolbar.setTitle("CoordinatorLayout");
        collasingToolbar.setNavigationIcon(R.mipmap.ic_arrow_back);
        collasingToolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        collasingToolbar.inflateMenu(R.menu.base_toolbar_menu);
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
        for (int i = 1; i <= 4; i++) {
            coordinatorLayout.addTab(coordinatorLayout.newTab().setText("Tab" + i));
        }
    }
}
