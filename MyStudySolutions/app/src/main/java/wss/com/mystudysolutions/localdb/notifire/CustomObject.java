package wss.com.mystudysolutions.localdb.notifire;

import android.support.v4.app.FragmentActivity;

/**
 * Created by Chiranjit Jana on 05/11/2017.
 */

public class CustomObject {

    private Object data;
    private String targetViewType;
    private FragmentActivity targetFragment;

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public String getTargetViewType() {
        return targetViewType;
    }

    public void setTargetViewType(String targetViewType) {
        this.targetViewType = targetViewType;
    }

    public FragmentActivity getTargetFragment() {
        return targetFragment;
    }

    public void setTargetFragment(FragmentActivity targetFragment) {
        this.targetFragment = targetFragment;
    }
}
