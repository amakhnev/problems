package com.amakhnev.problems.leetcode;

import java.util.HashMap;

public class EncodeAndDecodeTinyURL {

    public static void main(String[] args) {
        System.out.println(new EncodeAndDecodeTinyURL().decodeEncode("https://leetcode.com/problems/encode-and-decode-tinyurl/description/"));

    }

    public String decodeEncode(String url) {
        Codec codec = new Codec();

        return codec.decode(codec.encode(url));
    }

    public class Codec {

        String seed = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
        HashMap<String, String> urls = new HashMap<>();

        // Encodes a URL to a shortened URL.
        public String encode(String longUrl) {
            StringBuilder sb;
            do { //generate unique id with 6 symbols, ensure it's not in map already
                sb = new StringBuilder();
                for (int i = 0; i < 6; i++) {
                    sb.append(seed.charAt((int) (Math.random() * seed.length())));
                }

            } while (urls.containsKey(sb.toString()));
            urls.put(sb.toString(), longUrl);
            return sb.toString();
        }


        // Decodes a shortened URL to its original URL.
        public String decode(String shortUrl) {
            return urls.get(shortUrl);
        }
    }


}
