package com.example.myprofile;


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
import android.net.Uri;



public class activity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activity2);
    }
    public void send_click(View v){
        EditText name = (EditText) findViewById(R.id.name);
        EditText email = (EditText) findViewById(R.id.email);
        EditText subject = (EditText) findViewById(R.id.subject);
        EditText message = (EditText) findViewById(R.id.message);

        if(name.getText().toString().equals(""))
            name.setError("Required");
        else if(email.getText().toString().equals(""))
            email.setError("Required");
        else if(subject.getText().toString().equals(""))
            subject.setError("Required");
        else if(message.getText().toString().equals(""))
            message.setError("Required");
        else
        {
            Intent intent  = new Intent(Intent.ACTION_SENDTO);
            intent.setData(Uri.parse("mailto:"));
            intent.putExtra(Intent.EXTRA_EMAIL, new String[]{"odibest1893@gmail.com"});
            intent.putExtra(Intent.EXTRA_SUBJECT, subject.getText().toString());
            intent.putExtra(Intent.EXTRA_TEXT, message.getText().toString());
            try
            {
                startActivity(Intent.createChooser(intent, "send mail"));
            }catch (android.content.ActivityNotFoundException ex)
            {
                Toast.makeText(this, "no mail app found", Toast.LENGTH_SHORT).show();
            }catch (Exception ex)
            {
                Toast.makeText(this, "unexpected error", Toast.LENGTH_SHORT).show();
            }
        }
    }
//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        // Inflate the menu; this adds items to the action bar if it is present.
//        getMenuInflater().inflate(R.menu.menu_activity2, menu);
//        return true;
//    }
//
//    @Override
//    public boolean onOptionsItemSelected(MenuItem item) {
//        // Handle action bar item clicks here. The action bar will
//        // automatically handle clicks on the Home/Up button, so long
//        // as you specify a parent activity in AndroidManifest.xml.
//        int id = item.getItemId();
//
//        //noinspection SimplifiableIfStatement
//        if (id == R.id.action_settings) {
//            return true;
//        }
//
//        return super.onOptionsItemSelected(item);
//    }
}
