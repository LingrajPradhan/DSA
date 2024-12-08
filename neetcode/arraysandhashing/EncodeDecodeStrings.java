package datastructures.src.com.neetcode.arraysandhashing;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class EncodeDecodeStrings {

    public static void main(String[] args) {
        EncodeDecodeStrings codec = new EncodeDecodeStrings();

        List<String> original = Arrays.asList("Hello", "World", "abc#def", "#", "");
        System.out.println("Original: " + original);

        String encoded = codec.encode(original);
        System.out.println("Encoded: " + encoded);

        List<String> decoded = codec.decode(encoded);
        System.out.println("Decoded: " + decoded);

        // Check if decoded list matches the original
        System.out.println("Matches original: " + original.equals(decoded));
    }

    public String encode(List<String> strs){
        return strs.stream()
                .map(s -> s.replace("#", "##") + " # ")
                .collect(Collectors.joining());
    }

    public List<String> decode(String s){
        List<String> strs = Stream.of(s.split(" # ", -1))
                .map(t -> t.replace("##","#"))
                .collect(Collectors.toList());

        strs.removeLast();
        return strs;
    }
}
