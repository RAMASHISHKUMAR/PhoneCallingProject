package adapter;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

import fragment.ContactsFragment;
import fragment.FavoriteFragment;
import fragment.HistoryFragment;

public class PagerAdapter extends FragmentPagerAdapter {

    List<Fragment>fragments;

    public PagerAdapter(FragmentManager fm , List<Fragment> fragments) {
        super(fm);
        this.fragments = fragments;
    }

    @Override
    public Fragment getItem(int position) {
        return fragments.get(position);
    }

    @Override
    public int getCount() {
        return fragments.size();
    }



    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        if (fragments.get(position) instanceof FavoriteFragment) {
            return "Favorite";
        }else if(fragments.get(position)instanceof HistoryFragment) {
            return "History";
        }if (fragments.get(position)instanceof ContactsFragment) {
            return "Contacts";

        }return " ";
        //return super.getPageTitle(position);
    }
}
