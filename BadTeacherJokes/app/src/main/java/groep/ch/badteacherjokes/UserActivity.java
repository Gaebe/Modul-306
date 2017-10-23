package groep.ch.badteacherjokes;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class UserActivity extends AppCompatActivity {

    private FirebaseAuth mAuth;
    private TextView tv_mail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user);

        mAuth = FirebaseAuth.getInstance();
        FirebaseUser user = mAuth.getCurrentUser();
        if (user != null) {
            tv_mail = (TextView) findViewById(R.id.tv_mail);
            tv_mail.setText(user.getEmail().toString());
        } else {
            try {
                Intent k = new Intent(UserActivity.this, StartActivity.class);
                startActivity(k);
                finish();
            } catch(Exception e) {
            }
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.back_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle item selection
        switch (item.getItemId()) {
            case R.id.action_back:
                try {
                    Intent k = new Intent(UserActivity.this, MainActivity.class);
                    startActivity(k);
                    finish();
                } catch(Exception e) {
                }
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
