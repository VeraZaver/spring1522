package com.example.spring152.services;

import com.fasterxml.jackson.databind.util.JSONPObject;
import org.json.JSONObject;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

@Service
public class CurrencyService  {
    public CurrencyService () throws Exception {

        URL urlUsd = new URL("https://www.nbrb.by/api/exrates/rates/usd?parammode=2");
        URL urlEur = new URL("https://www.nbrb.by/api/exrates/rates/eur?parammode=2");

        BufferedReader bufferedReader = new
                BufferedReader(new InputStreamReader(urlUsd.openStream()));
        JSONObject jsonObject = new JSONObject(bufferedReader.readLine());
        String course = jsonObject.get("Cur_OfficialRate").toString();
       /* double sum = Double.parseDouble(item.getPrice);
        double sum1 = Double.parseDouble(course);
        double finalSum = sum/sum1;*/

    }
}
