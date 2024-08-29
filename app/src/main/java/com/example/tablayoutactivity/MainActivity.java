package com.example.tablayoutactivity;

import android.os.Bundle;
import android.widget.FrameLayout;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.google.android.material.tabs.TabLayout;

public class MainActivity extends AppCompatActivity {
TabLayout tab;
FrameLayout frame;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        tab=findViewById(R.id.tab);
        frame=findViewById(R.id.frame);
        //create new tab named as "First"
        TabLayout.Tab first = tab.newTab();
        first.setIcon(R.drawable.ic_android_black_24dp);
        first.setText("first");
        tab.addTab(first);//add tab in the TabLayout

        TabLayout.Tab second=tab.newTab();
        second.setText("second");
        second.setIcon(R.drawable.ic_android_black_24dp);
        tab.addTab(second);

        TabLayout.Tab third = tab.newTab();
        third.setIcon(R.drawable.ic_android_black_24dp);
        third.setText("third");
        tab.addTab(third);

        tab.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                Fragment fragment = null;
                switch (tab.getPosition()){
                    case 0:
                        fragment= new FirstFragement();
                        break;

                    case 1:
                        fragment = new SecondFragment();
                        break;

                    case 2:
                        fragment=new ThirdFragment();
                        break;
                }

                FragmentManager fm= getSupportFragmentManager();
                FragmentTransaction ft= fm.beginTransaction();
                ft.replace(R.id.frame, fragment);
//                ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
                ft.commit();

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