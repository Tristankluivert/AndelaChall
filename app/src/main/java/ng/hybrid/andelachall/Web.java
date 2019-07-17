package ng.hybrid.andelachall;

import android.content.Intent;
import android.net.http.SslError;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.webkit.SslErrorHandler;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;

public class Web extends AppCompatActivity {


    ImageView imageview;
    WebView alcweb;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web);

        imageview = findViewById(R.id.image1);
        alcweb = findViewById(R.id.webview);


        imageview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent gomain = new Intent(getApplicationContext(),MainActivity.class);
                gomain.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK|Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(gomain);
                finish();
            }
        });


        alcweb.getSettings().setJavaScriptEnabled(true);
        alcweb.setWebViewClient(new WebViewClient(){
                                    @Override
                                    public void onReceivedSslError(WebView view, SslErrorHandler handler, SslError error) {
                                        handler.proceed();
                                    }
                                }
        );
  alcweb.loadUrl("https://andela.com/alc/");
    }
}
