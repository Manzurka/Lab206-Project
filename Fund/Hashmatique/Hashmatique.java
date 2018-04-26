import java.util.*;

public class Hashmatique {
    public void maps() {
        HashMap<String, String> trackList = new HashMap<>();
        trackList.put("Track1", "Lyrics1");
        trackList.put("Track2", "Lyrics2");
        trackList.put("Track3", "Lyrics3");
        trackList.put("Track4", "Lyrics4");
        System.out.println(trackList.get("Track1"));
        System.out.println(trackList);
    }
}