package test.ratul.com.signinpractice;

import android.app.Activity;
import android.app.Notification;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;

public class MainActivity extends Activity {

    private EditText eTMessage;
    private ListView lVMessagesContainer;
    private Button btnSendText;
    private ProgressBar progressBarReceive;
    private ProgressBar progressBarSend;
    private ChatAdapter chatAdapter;
    private ArrayList<ChatMessage> chatHistoryList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        getWindow().setBackgroundDrawableResource(R.drawable.background_img);
        setContentView(R.layout.activity_main);

        initControls();
    }

    private void initControls() {
        lVMessagesContainer = (ListView) findViewById(R.id.messagesContainer);
        eTMessage = (EditText) findViewById(R.id.messageEdit);
        btnSendText = (Button) findViewById(R.id.btnSendText);
        progressBarSend = (ProgressBar) findViewById(R.id.progressBarSend) ;
        progressBarReceive = (ProgressBar) findViewById(R.id.progressBarReceive) ;


        TextView labelMe = (TextView) findViewById(R.id.meLbl);
        TextView labelCompanion = (TextView) findViewById(R.id.friendLabel);

        RelativeLayout relContainer = (RelativeLayout) findViewById(R.id.container);
        labelCompanion.setText("Friend");

        //eTMessage.setHintTextColor(getResources().getColor(R.color.semiGrey));

        loadDummyHistory();

        btnSendText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String messageText = eTMessage.getText().toString();
                if (TextUtils.isEmpty(messageText)) {
                    return;
                }

                ChatMessage chatMessage = new ChatMessage();
                chatMessage.setId(122);//dummy
                chatMessage.setMessage(messageText);
                chatMessage.setDate(DateFormat.getDateTimeInstance().format(new Date()));
                chatMessage.setMe(true);
                chatMessage.setMedia(false);

                eTMessage.setText("");

                displayMessage(chatMessage);

            }
        });
    }

    public void displayMessage(ChatMessage message) {
        chatAdapter.add(message);
        chatAdapter.notifyDataSetChanged();
        scroll();
    }

    private void scroll() {
        lVMessagesContainer.setSelection(lVMessagesContainer.getCount() - 1);
    }

    private void loadDummyHistory(){

        chatHistoryList = new ArrayList<ChatMessage>();

        ChatMessage msg = new ChatMessage();
        msg.setId(1);
        msg.setMe(false);
        msg.setMessage("Hi");
        msg.setMedia(false);
        msg.setDate(DateFormat.getDateTimeInstance().format(new Date()));
        chatHistoryList.add(msg);

        ChatMessage msg1 = new ChatMessage();
        msg1.setId(2);
        msg1.setMe(false);
        msg.setMedia(false);
        msg1.setMessage("How r u doing???");
        msg1.setDate(DateFormat.getDateTimeInstance().format(new Date()));
        chatHistoryList.add(msg1);

        ChatMessage msg2 = new ChatMessage();
        msg2.setId(3);
        msg2.setMe(true);
        msg.setMedia(false);
        msg2.setMessage("What about you???");
        msg2.setDate(DateFormat.getDateTimeInstance().format(new Date()));
        chatHistoryList.add(msg2);

        chatAdapter = new ChatAdapter(MainActivity.this, new ArrayList<ChatMessage>());
        lVMessagesContainer.setAdapter(chatAdapter);

        for(int i=0; i<chatHistoryList.size(); i++) {
            ChatMessage message = chatHistoryList.get(i);
            displayMessage(message);
        }

        final Handler mHandler = new Handler();

        /*progressBarReceive.setMax( 100 );
        new Thread(new Runnable() {
            int mProgressStatus = 0;
            public void run() {
                while (mProgressStatus < 100000) {

                    // Update the progress bar
                    mHandler.post(new Runnable() {
                        public void run() {
                            progressBarReceive.setProgress(mProgressStatus);

                        }
                    });
                    mProgressStatus++;
                }
            }
        }).start();*/
    }
}
