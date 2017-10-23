package groep.ch.badteacherjokes;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
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

        tv_mail = (TextView) findViewById(R.id.tv_mail);

        tv_mail.setText(user.getEmail().toString());
    }
}