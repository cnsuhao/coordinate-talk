/******************************
 * ������UI����
 */

package org.guohai.android.CoordinateTalk;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;
public class CoordinateTalk extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        Tools a =new Tools();
        findViews();
        textCoordinate.setText("xxx"+a.GetResolutionWeight());
    }
    
    private TextView textCoordinate;
    /* �������е���ͼ */
    private void findViews()
    {
    	textCoordinate = (TextView)findViewById(R.id.coordinate);
    }
}