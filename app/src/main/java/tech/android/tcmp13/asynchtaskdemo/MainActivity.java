package tech.android.tcmp13.asynchtaskdemo;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {

    private TextView result;
    private ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        result = (TextView) findViewById(R.id.result);
    }

    @Override
    protected void onResume() {

        super.onResume();
        progressDialog = new ProgressDialog(this);
        progressDialog.show();
        new CalculationTask().execute();
        foo();
        foo("s");
        foo("r", "r");
    }

    /**
     * VarArgs sample
     * @param strings
     */
    private void foo(String... strings) {

        for (String s : strings)
            Log.d("ttt", s);
    }

    /**
     * First generic is the type of params to doInBackground
     * Second generic is the type of params to the background task progress
     * Third generic is the type of params that doInBackground returns
     */
    private class CalculationTask extends AsyncTask<Void, Void, Integer> {

        @Override
        protected Integer doInBackground(Void... voids) {

            try {
                Thread.sleep(1500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return 42;
        }

        @Override
        protected void onPostExecute(Integer integer) {

            super.onPostExecute(integer);
            progressDialog.hide();
            result.setText(String.valueOf(integer));
        }
    }
}
