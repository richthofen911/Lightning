package ap1.com.electric;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.graphics.Color;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.OvalShape;
import android.os.Bundle;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.FrameLayout;

public class MainActivity extends Activity {
    // private static final String TAG = "Electric_Screen";

    private static final String ADS_APP_ID = "100013003";
    private static final String ADS_SECRET_KEY = "8c5f923f5cfa060dd6e16d6272807516";
    private static final String TAG_LIST = "37b3ec7ac0d720a17e82cb8d8884e1d1";
    private static final String TAG_BANNER = "580ca01dca508f822532c9c7ed7604be";
    private View adBannerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        CustomSurfaceView view = new CustomSurfaceView(this, null);
        setContentView(view);
        getWindow().setFlags(
                WindowManager.LayoutParams.FLAG_HARDWARE_ACCELERATED,
                WindowManager.LayoutParams.FLAG_HARDWARE_ACCELERATED);
    }


    public boolean onKeyDown(int keyCode, KeyEvent event) {
        // TODO Auto-generated method stub
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            showDialog();
        }
        return super.onKeyDown(keyCode, event);
    }

    private void showDialog() {
        new AlertDialog.Builder(this)
                .setTitle("Quit")
                .setMessage("要退出吗？")
                .setNegativeButton("我要退出",
                        new DialogInterface.OnClickListener() {

                            @Override
                            public void onClick(DialogInterface arg0, int arg1) {
                                // TODO Auto-generated method stub
                                finish();
                            }
                        })
                .setPositiveButton("更多推荐",
                        new DialogInterface.OnClickListener() {

                            @Override
                            public void onClick(DialogInterface arg0, int arg1) {
                                // TODO Auto-generated method stub
                            }
                        }).show();
    }

    private void drawUpdateIndicator(int color, boolean drawLeftOrRight) {
        ShapeDrawable smallerCircle = new ShapeDrawable(new OvalShape());
        smallerCircle.setIntrinsicHeight(60);
        smallerCircle.setIntrinsicWidth(60);
        smallerCircle.setBounds(new Rect(0, 0, 60, 60));
        smallerCircle.getPaint().setColor(color);
        smallerCircle.setPadding(50, 50, 50, 100);

        Drawable drawableleft = null;
        Drawable drawableRight = null;
        if (drawLeftOrRight) {
            drawableleft = smallerCircle;
        } else {
            drawableRight = smallerCircle;
        }
        // showAppWallButton.setCompoundDrawables(drawableleft, null,
        // drawableRight, null);
    }
}
