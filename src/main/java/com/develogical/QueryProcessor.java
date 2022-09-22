package com.develogical;

public class QueryProcessor {

    public String process(String query) {
        
        if (query.toLowerCase().contains("shakespeare")) {
            return "William Shakespeare (26 April 1564 - 23 April 1616) was an " +
                    "English poet, playwright, and actor, widely regarded as the greatest " +
                    "writer in the English language and the world's pre-eminent dramatist.";
        }
        
        // at=info method=GET path="/api?q=2dafb990:%20what%20is%2013%20plus%204"
        //  host=arggr.herokuapp.com request_id=775a92cc-dbf1-4a13-812c-63fbcaf6bfb5 
        //  fwd="44.192.38.170" dyno=web.1 connect=0ms service=2ms status=200 bytes=173 protocol=http

        // Getting query loads of time, multiple times?
        // Just getting it once?
        String lowercase = query.toLowerCase();
        String[] arr = lowercase.split("%20");
        // split by the %20s abd get tge type of operation we have
        if (lowercase.contains("plus")) {
            int res = 0;
            for (String item : arr) {
                if (Character.isDigit(lowercase.charAt(0))) {
                    if (res == 0) {
                        res = Integer.valueOf(item);
                    }
                    else {
                        res += Integer.valueOf(item);
                    }
                } 
            }
            return Integer.toString(res);
        
        } else if (lowercase.contains("multiplied")) {
            int res = 0;
            for (String item : arr) {
                if (Character.isDigit(lowercase.charAt(0))) {
                    if (res == 0) {
                        res = Integer.valueOf(item);
                    }
                    else {
                        res *= Integer.valueOf(item);
                    }
                } 
            }
            return Integer.toString(res);

        } else if (lowercase.contains("largest")) {
            int res = 0;
            boolean seen = false;
            for (String item : arr) {
                if (Character.isDigit(lowercase.charAt(0))) {
                    if (!seen){
                        res = Integer.valueOf(item);
                    }
                    else {
                        res = Math.max(res, Integer.valueOf(item));
                    }
                } 
            }
            return Integer.toString(res);
            
        } //else if (lowercase.contains("")) {
            
        // }
    }
}
