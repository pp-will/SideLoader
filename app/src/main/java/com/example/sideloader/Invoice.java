package com.example.sideloader;

/**
 * Created by wpittman on 3/20/2018.
 */

import java.util.ArrayList;
import java.util.List;

import android.net.Uri;
import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

//
//  Invoice object to store invoice data
//  for more information about the Invoice object, please refer to
//  https://cms.paypal.com/us/cgi-bin/?cmd=_render-content&content_ID=developer/e_howto_api_CreateInvoice
//

public class Invoice {

    //@SerializedName takes parameter of annotation to be used when serializing/deserializing objects for JSON/GSON
    @SerializedName("paymentTerms")
    private String paymentTerms;
    @SerializedName("discountPercent")
    private String discountPercent;
    @SerializedName("currencyCode")
    private String currencyCode;
    @SerializedName("merchantEmail")
    private String merchantEmail;
    @SerializedName("number")
    private String number;
    @SerializedName("payerEmail")
    private String payerEmail;
    @SerializedName("itemList")
    private Items items;

    public Invoice() {
        items = new Items();
    }

    public void addItemWithName(String itemName, String description, String taxRate, Double unitPrice, String taxName, Double quantity) {
        Item item = new Item(itemName, description, quantity, taxRate, taxName, unitPrice);
        items.add(item);
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public void addItem(Item item) {
        items.add(item);
    }

    public String getPaymentTerms() {
        return paymentTerms;
    }

    public void setPaymentTerms(String paymentTerms) {
        this.paymentTerms = paymentTerms;
    }

    public String getDiscountPercent() {
        return discountPercent;
    }

    public void setDiscountPercent(String discountPercent) {
        this.discountPercent = discountPercent;
    }

    public String getCurrencyCode() {
        return currencyCode;
    }

    public void setCurrencyCode(String currencyCode) {
        this.currencyCode = currencyCode;
    }

    public String getMerchantEmail() {
        return merchantEmail;
    }

    public void setMerchantEmail(String merchantEmail) {
        this.merchantEmail = merchantEmail;
    }

    public String getPayerEmail() {
        return payerEmail;
    }

    public void setPayerEmail(String payerEmail) {
        this.payerEmail = payerEmail;
    }

    public List<Item> getItemList() {
        return items.itemList;
    }

    public int getItemsCount() {
        return items.getItemsCount();
    }

    public static class Items {
        @SerializedName("item")
        private List<Item> itemList;

        public Items() {
            itemList = new ArrayList<Item>();
       }

       public void add(Item item) {
            itemList.add(item);
       }

       public int getItemsCount() {
            return itemList.size();
       }
    }

    /*
  Helper class used to serialize Invoice object to JSON string
  e.g.
  {
   "currencyCode" : "USD",
   "discountPercent" : "0",
   "itemList" :
      {
         "item" :
            [
               {
                  "description" : "Blue T-shirt",
                  "name" : "T-Shirt",
                  "quantity" : 1.0,
                  "taxName" : "Sales Tax",
                  "taxRate" : "8.50",
                  "unitPrice" : 15.99
               }
            ]
      },
   "merchantEmail" : "merchant@ebay.com",
   "number" : "9876",
   "payerEmail" : "foo@bar.com",
   "paymentTerms" : "DueOnReceipt"
  }
  */

    public static class Converter {
        public static String serializeToUrlEncodedJsonString(Invoice invoice) {
            Gson gson = new Gson();
            String invoiceJson = gson.toJson(invoice);
            return Uri.encode(invoiceJson);
        }

        public static String toUrlEncodedJsonString(Invoice invoice) {
            //create invoice
            JSONObject invoiceJson = new JSONObject();
            try {
                JSONObject itemList = new JSONObject();
                JSONArray itemListArray = new JSONArray();

                List<Item> items = invoice.getItemList();
                //create item
                for(Item item : items) {
                    JSONObject itemJson = new JSONObject();
                    itemJson.
                }
            }
        }
    }
 }
