package android.eservices.staticfragmenttabs;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.viewpager.widget.ViewPager;

public class MainActivity extends AppCompatActivity implements FragmentOne.OnButtonClickListener{

    private ViewPager viewPager;
    private int currentCounter = 0;
    private TextView counterTextView;
    private FragmentOne f1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setupViewPagerAndTabs();
    }

    //TODO fill the method to get view references and initialize viewpager to display our fragments
    private void setupViewPagerAndTabs() {
        viewPager = findViewById(R.id.tab_viewpager);

        //TODO we want two fragments with layouts : fragment_one, fragment_two.
        f1 = FragmentOne.newInstance();
        final FragmentTwo f2 = FragmentTwo.newInstance();

        //TODO set adapter to viewpager and handle fragment change inside
        viewPager.setAdapter(new FragmentStatePagerAdapter(getSupportFragmentManager()) {
            @Override
            public Fragment getItem(int position) {
                if (position == 0) {
                    return f1;
                }
                else {
                    return f2;
                }
            }

            @Override
            public int getCount() {
                return 2;
            }
        });

    }


    public void onButtonClicked(int increment) {
        currentCounter += increment;
    }


    @Override
    public void onAttachFragment(Fragment fragment) {
        if (fragment instanceof FragmentOne) {
            f1.setOnButtonClickListener(this);
        }
    }

    //TODO : increment and decrement counter, use the already provided String ressource (see strings.xml)
}
