package wss.com.mystudysolutions.uicommons;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;
import java.util.List;

import wss.com.mystudysolutions.custom.CustomFragmentObject;
import wss.com.mystudysolutions.localdb.notifire.CustomObject;

public class ViewPagerAdapter extends FragmentPagerAdapter {
        private final List<Fragment> mFragmentList = new ArrayList<>();
        private final List<String> mFragmentTitleList = new ArrayList<>();

        public ViewPagerAdapter(FragmentManager manager) {
            super(manager);
        }

        @Override
        public Fragment getItem(int position) {
            return mFragmentList.get(position);
        }

        @Override
        public int getCount() {
            return mFragmentList.size();
        }

        public void addFragment(List<Fragment> fragment, List<String> title) {

            for (int i = 0; i < title.size(); i++) {
                mFragmentTitleList.add(title.get(i).toString());
            }

            for (int x=0;x<fragment.size();x++)
            {
                mFragmentList.add(fragment.get(x));
            }

        }

        public void addFragment(Object obj)
        {
            CustomFragmentObject custom = (CustomFragmentObject) obj;

            List<Fragment> fragmentList = custom.getFragmentList();

            List<String> titleList=custom.getTitle();


            for (int i = 0; i < titleList.size(); i++) {
                mFragmentTitleList.add(titleList.get(i).toString());
            }

            for (int x=0;x<fragmentList.size();x++)
            {
                mFragmentList.add(fragmentList.get(x));
            }


        }

        @Override
        public CharSequence getPageTitle(int position) {
            return mFragmentTitleList.get(position);
        }
    }