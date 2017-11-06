package wss.com.mystudysolutions.custom;

import android.support.v4.app.Fragment;

import java.util.List;

/**
 * Created by Chiranjit Jana on 06/11/2017.
 */

public class CustomFragmentObject {

    private List<Fragment> fragmentList;
    private List<String> title;

    public List<Fragment> getFragmentList() {
        return fragmentList;
    }

    public void setFragmentList(List<Fragment> fragmentList) {
        this.fragmentList = fragmentList;
    }

    public List<String> getTitle() {
        return title;
    }

    public void setTitle(List<String> title) {
        this.title = title;
    }
}
