// https://leetcode.com/problems/encode-and-decode-tinyurl

public class Codec {
    Map<Integer, String> hm;

    Codec(){
        hm = new HashMap<>();
    }

    // Encodes a URL to a shortened URL.
    public String encode(String longUrl) {
        StringBuilder sb = new StringBuilder("http://tinyurl.com/");
        sb.append(hm.size());

        hm.put(hm.size(), longUrl);

        return sb.toString();
    }

    // Decodes a shortened URL to its original URL.
    public String decode(String shortUrl) {
        String idx = shortUrl.substring(19);
        return hm.getOrDefault(Integer.parseInt(idx), null);
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.decode(codec.encode(url));