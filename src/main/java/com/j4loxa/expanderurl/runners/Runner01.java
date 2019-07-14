package com.j4loxa.expanderurl.runners;

import com.j4loxa.expanderurl.model.SEUrl;
import com.j4loxa.expanderurl.process.ProcessExpander;

import java.util.List;

public class Runner01 {
    public static void main(String[] args) {
        var shortenUrls = List.of(
                "https://t.co/1UJ5pFUl1",
                "https://t.co/TGqER33gn7",
                "https://t.co/3GVlzQpPVK",
                "https://t.co/LXjhm9tnau",
                "https://t.co/nG3RMTZZ3X",
                "https://t.co/sYoLOQ6Rvz",
                "https://t.co/uTqaA17FRo",
                "https://t.co/MYAJZsNPSQ",
                "https://t.co/50Wpp2WUwW",
                "https://t.co/Rr2GiQG9hx",
                "http://j4loxa.com/data/networks/data2sna1.csv");
        var results = ProcessExpander.expanderUrls(shortenUrls);

        for(SEUrl seUrl : results) {
            System.out.println(seUrl.getStatusCode());
            System.out.println(seUrl.getShortUrl());
            System.out.println(seUrl.getLongUrl());
            System.out.println(seUrl.getMimeType());
            System.out.println("------");
        }
    }
}
