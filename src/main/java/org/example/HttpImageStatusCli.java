package org.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class HttpImageStatusCli {
    public void askStatus() throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        HttpStatusImageDownloader downloader = new HttpStatusImageDownloader();

        while (true) {
            try {
                System.out.print("Enter HTTP status code: ");
                String input = reader.readLine();

                if (!input.matches("\\d+")) {
                    System.out.println("Please enter a valid number.");
                    continue;
                }

                int code = Integer.parseInt(input);
                downloader.downloadStatusImage(code);
                break;
            } catch (IOException e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
    }
}