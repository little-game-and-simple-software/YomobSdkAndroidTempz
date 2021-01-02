package test.tgsdk.jar;
 
import android.app.Activity;
import android.os.Bundle;
import com.soulgame.sgsdk.tgsdklib.TGSDK;
import android.widget.Button;
import android.view.View.OnClickListener;
import android.view.View;
import android.widget.Toast;
import android.widget.TextView;
import com.soulgame.sgsdk.tgsdklib.ad.ITGADListener;
public class MainActivity extends Activity { 
    String appid="Lme7951z69s731zb4gvW";
    String sceneId="0fzVwIMnEJdm3Ws6Jxf";
     TextView stateView;
     public void showbanner()
     {
     //    TGSDK.setBannerConfig();    
     }
     public void closeBanner()
     {
         TGSDK.closeBanner(this,appid);
     }
     class myAdListener implements ITGADListener
    {

        @Override
        public void onShowSuccess(String p1, String p2) 
        {
            
        }

        @Override
        public void onShowFailed(String p1, String p2, String p3) 
        {
            
        }

        @Override
        public void onADClick(String p1, String p2)
        {
        }

        @Override
        public void onADClose(String p1, String p2, boolean p3)
        {
            
       }
     }
    @Override
    protected void onCreate(Bundle savedInstanceState)
	{
        //应用appid 在yomob官网注册
        
        super.onCreate(savedInstanceState);
         setContentView(R.layout.activity_main);
         stateView=findViewById(R.id.state);
		Button i= findViewById(R.id.init);
        TGSDK.setDebugModel(true);
        TGSDK.initialize(this,appid,null);
        TGSDK.preloadAd(this);
       //TGSDK.setADListener(new );
        if (TGSDK.couldShowAd(sceneId)) {
            TGSDK.showAd(this, sceneId);
        }
        TGSDK.showTestView(this,sceneId);
		i.setOnClickListener(new OnClickListener()
			{
				@Override
				public void onClick(View p1) 
				{
					int is_wifi=TGSDK.isWIFI();
					//Toast.makeText(getApplicationContext(),"wifi"+is_wifi,Toast.LENGTH_LONG).show();
					String version=TGSDK.SDKVersion();
					Toast.makeText(getApplicationContext(),"版本"+version,Toast.LENGTH_LONG).show();
                  boolean could=  TGSDK.couldShowAd(sceneId);
                  stateView.setText("状态"+could);
                  if(could)
                  {
                       TGSDK.showTestView(MainActivity.this,sceneId);
                   }
				}
		});
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        TGSDK.onRequestPermissionsResult(this, requestCode, permissions, grantResults);
    
    }
    
    @Override
    protected void onStop()
    {
        super.onStop();
        TGSDK.onStop(this);
    }

    @Override
    protected void onPause() {
        super.onPause();
        TGSDK.onPause(this);
    }

    @Override
    protected void onResume() {
        super.onResume();
        TGSDK.onResume(this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        TGSDK.onDestroy(this);
    }
	
} 
