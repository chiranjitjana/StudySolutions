package wss.com.mystudysolutions.listeners;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import wss.com.mystudysolutions.application.SingletoneApp;
import wss.com.mystudysolutions.utils.AppConstants;

/**
 * Created by Chiranjit Jana on 29/10/2017.
 */

public class ButtonClickListners implements  View.OnClickListener{

    private String buttonType;
    private String fileUrl;
    private Intent intent;
    private Activity activity;
   /* private Context context;
    AppCompatActivity activity;*/
    public ButtonClickListners(String buttonType, String fileUrl,Intent intent,Activity activity) {
        this.buttonType = buttonType;
        this.fileUrl = fileUrl;
        this.intent=intent;
        this.activity=activity;
    }

    @Override
    public void onClick(View view) {


        switch (buttonType)
        {
            case AppConstants.VIEW_BUTTON:
                System.out.print("View");
                break;
            case AppConstants.DOWNLOAD_BUTTON:
                System.out.print("Download");
                break;
            case AppConstants.NAVIGATE:
                activity.startActivity(intent);

                break;

        }

    }
}
