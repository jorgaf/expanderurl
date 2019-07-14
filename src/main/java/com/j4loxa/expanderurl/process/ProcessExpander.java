package com.j4loxa.expanderurl.process;

import com.j4loxa.expanderurl.model.SEUrl;
import com.j4loxa.expanderurl.util.UrlExpanderTask;

import java.net.http.HttpClient;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class ProcessExpander {
    public static List<SEUrl> expanderUrls(List<String> shortUrls) {
        ExecutorService executor;
        List<Future<SEUrl>> results;
        List<SEUrl> output;

        executor = Executors.newFixedThreadPool(shortUrls.size() / 2);
        results = new ArrayList<>();
        output = new ArrayList<>();

        var httpClient = HttpClient.newBuilder().
                followRedirects(HttpClient.Redirect.ALWAYS).
                build();

        for(String shortUrl : shortUrls) {
            Callable<SEUrl> worker = new UrlExpanderTask(shortUrl, httpClient);
            Future<SEUrl> submit = executor.submit(worker);
            results.add(submit);
        }

        for(Future<SEUrl> thread : results) {
            try {
                output.add(thread.get());
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
            }
        }

        executor.shutdown();
        return output;
    }

}
