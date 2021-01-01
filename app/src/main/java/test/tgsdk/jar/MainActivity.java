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
     String appid;
     TextView stateView;
     public void showbanner()
     {
         TGSDK.setBannerConfig();    
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
         appid="";
        super.onCreate(savedInstanceState);
         setContentView(R.layout.activity_main);
         stateView=findViewById(R.id.state);
		Button i= findViewById(R.id.init);
        TGSDK.initialize(this,"",null);
       // TGSDK.setADListener(new );
		i.setOnClickListener(new OnClickListener()
			{
				@Override
				public void onClick(View p1) 
				{
					int is_wifi=TGSDK.isWIFI();
					Toast.makeText(getApplicationContext(),"wifi"+is_wifi,Toast.LENGTH_LONG).show();
					String version=TGSDK.SDKVersion();
					Toast.makeText(getApplicationContext(),"版本"+version,Toast.LENGTH_LONG).show();
                  boolean could=  TGSDK.couldShowAd(appid);
                  stateView.setText("状态"+could);
                  if(could)
                   {
                       TGSDK.showTestView(MainActivity.this,appid);
                   }
				}
		});
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
