package test.ratul.com.signinpractice;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ToggleButton;

/**
 * Created by Ratul on 12/22/2016.
 */

public class ConnectActivity extends Activity {
    private ToggleButton tglCallerReceiver;
    private EditText editTextCallee;
    private Button btnLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        tglCallerReceiver = (ToggleButton) findViewById(R.id.tglCallerReceiver);
        editTextCallee = (EditText) findViewById(R.id.editTextCallee);
        btnLogin = (Button) findViewById(R.id.btnLogin);


        super.onCreate(savedInstanceState);
        getWindow().setBackgroundDrawableResource(R.drawable.background_img);
        setContentView(R.layout.connect_screen);



       /*btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent mainActivityIntent = new Intent(ConnectActivity.this, MainActivity.class);
                startActivity(mainActivityIntent);
            }
        });*/

    }

    public void onClickBtnLogin(View view) {
        Intent mainActivityIntent = new Intent(ConnectActivity.this, MainActivity.class);
        startActivity(mainActivityIntent);
    }

    public void goForChat() {

    }

}
