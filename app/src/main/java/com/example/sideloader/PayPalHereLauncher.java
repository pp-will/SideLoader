package com.example.sideloader;

import android.content.Intent;
import android.app.Activity;
import android.os.Bundle;
//copied from git
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

import java.text.MessageFormat;


//called when activity is created
public class PayPalHereLauncher extends Activity {

    private static final String LOG_TAG = MainActivity.class.getSimpleName();
    public static final String MARKET_URL = "market://details?id=com.paypal.here";
    private static final String PPH_URL_STRING = "paypalhere://takePayment/v2?accepted={0}&returnUrl={1}&invoice={2}&step=choosePayment&payerPhone={3}";
    private static final String RETURN_URL = "pphsample://handleResponse/?Type={Type}&InvoiceId={InvoiceId}&Tip={Tip}&Email={Email}&TxId={TxId}&GrandTotal={GrandTotal}";
    private static final String ACCEPTED_PAYMENT_TYPES = "cash,card,paypal";
    private static final String RESPONSE_HOST = "handleResponse";

    private Invoice _invoice;

    private EditText editInvoiceNum;
    private EditText editPaymentTerms;
    private EditText editDiscount;
    private EditText editCurrencyCode;
    private EditText editMerchantEmail;
    private EditText editPayerEmail;
    private EditText editPayerPhone;

    private TextView itemCount;

    private static final int ADD_ITEM_REQUEST_CODE = 100;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pay_pal_here_launcher);

        editInvoiceNum = findViewById(R.id.editInvoiceNum);
        editPaymentTerms = findViewById(R.id.editPaymentTerms);
        editDiscount = findViewById(R.id.editDiscount);
        editCurrencyCode = findViewById(R.id.editCurrencyCode);
        editMerchantEmail = findViewById(R.id.editMerchantEmail);
        editPayerEmail = findViewById(R.id.editPayerEmail);
        editPayerPhone = findViewById(R.id.editPayerPhone);

        itemCount = (TextView) findViewById(R.id.itemCount);

        //figure out what this does
       // initializeDefaultDataList();
    }

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        handleOpenURL(intent);
    }

    private void initializeDefaultDataList() {
        invoice
    }
}
