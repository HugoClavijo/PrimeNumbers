package com.example.primenumbers;

import android.os.AsyncTask;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.math.BigInteger;


public class PrimeNumbers extends AsyncTask<Integer, Void, BigInteger> {
    private TextView resultView;

    public PrimeNumbers(TextView resultView) {
        this.resultView = resultView;
    }

    @Override
    protected BigInteger doInBackground(Integer... params) {
        int number = params[0];
        BigInteger prime = new BigInteger("2");
        for (int i=0; i<number; i++) {
            try {
                Thread.sleep(1000);
                prime = prime.nextProbablePrime();
                publishProgress(prime);
            } catch (InterruptedException e) {
                Thread.interrupted();
            }
        }

        return prime;
    }

    private void publishProgress(BigInteger prime) {
        BigInteger number = prime;
        resultView.setText(number.toString());
    }

    @Override
    protected void onPostExecute(BigInteger result) {
        resultView.setText(result.toString());
    }
}