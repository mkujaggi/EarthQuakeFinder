package fragmentmycourse.crackeddish.com.mycourselistfragment.Util;

import android.app.Activity;
import android.util.DisplayMetrics;
import android.view.Display;

/**
 * Created by mkujaggi on 14-03-2018.
 */

public class ScreenUtility {
    private Activity activity;
    private float dpWidth;
    private float dpHeight;

    public ScreenUtility(Activity activity) {
        this.activity = activity;
        Display display=activity.getWindowManager().getDefaultDisplay();
        DisplayMetrics outMetrics=new DisplayMetrics();
        display.getMetrics(outMetrics);
        float density=activity.getResources().getDisplayMetrics().density;
        dpHeight=outMetrics.heightPixels/density;
        dpWidth=outMetrics.widthPixels/density;
    }

    public float getDpWidth() {
        return dpWidth;
    }

    public float getDpHeight() {
        return dpHeight;
    }
}
