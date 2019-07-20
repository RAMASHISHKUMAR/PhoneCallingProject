package activity;

import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.support.v7.widget.Toolbar;

import com.phonecallingproject.R;

import java.util.ArrayList;
import java.util.List;

import adapter.PagerAdapter;
import fragment.ContactsFragment;
import fragment.FavoriteFragment;
import fragment.HistoryFragment;

public class MainActivity extends AppCompatActivity {

    private Toolbar toolbar;
    private TabLayout tabLayout;
    private ViewPager viewPager;
    private FloatingActionButton floatingActionButton;

    List<Fragment>fragmentList = new ArrayList<>();
    private MenuItem menuItem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar = findViewById(R.id.toolbar);
        tabLayout = findViewById(R.id.tablayout);
        viewPager = findViewById(R.id.viewpager);
        floatingActionButton = findViewById(R.id.fab_action_button);
        setSupportActionBar(toolbar);

        floatingActionButton();             // floating action Button method ---dialpad
        addingFragmentWithViewPager();     // Add fragment with viewpager

    }

    public void addingFragmentWithViewPager(){
        // Adding Fragment
        fragmentList.add(new FavoriteFragment());
        fragmentList.add(new HistoryFragment());
        fragmentList.add(new ContactsFragment());

        PagerAdapter PagerAdapter = new PagerAdapter(getSupportFragmentManager(),fragmentList);
        tabLayout.setupWithViewPager(viewPager);
        viewPager.setAdapter(PagerAdapter);

        viewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int i, float v, int i1) {

            }

            @Override
            public void onPageSelected(int i) {

            }

            @Override
            public void onPageScrollStateChanged(int i) {

            }
        });

        tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
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

     // action menu on toolbar
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }
        //action perform on toolbar
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        this.menuItem = menuItem;

        int id = menuItem.getItemId();

        if (id == R.id.action_Contacts) {
            return true;
        }

        if (id == R.id.action_more) {
            return true;
        }

        if (id == R.id.action_call_duration) {
            return true;
        }

        if (id == R.id.action_delete) {
            return true;
        }

        if (id == R.id.action_filter_by) {
            return true;
        }

        if (id == R.id.action_import_export) {
            return true;
        }

        if (id == R.id.action_settings) {
            return true;
        }
     return super.onOptionsItemSelected(menuItem);
    }

//  Dial  paid operation
    public void floatingActionButton(){
        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Snackbar.make(v, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();



            }
        });


    }


}
