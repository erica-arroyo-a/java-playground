import java.util.*;

class SpotifyService {
    private Map<Integer, String> songs; // song_id -> song_name
    private Map<Integer, List<Integer>> userHistory; // user_id -> list of song_ids (history)
    private List<Integer> globalPlayHistory; // Last played songs globally
    private Map<Integer, Set<Integer>> songPlayCount; // song_id -> unique user_id set
    private int songCounter = 1; // Auto-incrementing song ID

    public SpotifyService() {
        songs = new HashMap<>();
        userHistory = new HashMap<>();
        globalPlayHistory = new LinkedList<>();
        songPlayCount = new HashMap<>();
    }

    // Function to add a new song
    public int addSong(String songName) {
        int songId = songCounter++;
        songs.put(songId, songName);
        songPlayCount.put(songId, new HashSet<>());
        return songId;
    }

    // Function to play a song
    public void playSong(int songId, int userId) {
        if (!songs.containsKey(songId)) {
            System.out.println("Song ID " + songId + " not found.");
            return;
        }

        userHistory.putIfAbsent(userId, new ArrayList<>());
        userHistory.get(userId).add(songId);

        songPlayCount.putIfAbsent(songId, new HashSet<>());
        songPlayCount.get(songId).add(userId);

        globalPlayHistory.add(songId);
        if (globalPlayHistory.size() > 3) {
            globalPlayHistory.remove(0); // Maintain only last 3 played songs
        }

        System.out.println("Playing: " + songs.get(songId) + " for User " + userId);
    }

    // Function to print analytics
    public void printAnalytics() {
        System.out.println("Analytics - Total Songs: " + songs.size());
        System.out.println("Total Users: " + userHistory.size());
        System.out.println("Song Play Count:");
        Map<Integer, Integer> songPlayCount = new HashMap<>();

        for (List<Integer> playedSongs : userHistory.values()) {
            for (int songId : playedSongs) {
                songPlayCount.put(songId, songPlayCount.getOrDefault(songId, 0) + 1);
            }
        }

        for (Map.Entry<Integer, Integer> entry : songPlayCount.entrySet()) {
            System.out.println("Song: " + songs.get(entry.getKey()) + " | Played: " + entry.getValue() + " times");
        }
    }

    // Function to print most played songs by unique users
    public void printMostPlayedSongs() {
        List<Map.Entry<Integer, Set<Integer>>> sortedSongs = new ArrayList<>(songPlayCount.entrySet());
        sortedSongs.sort((a, b) -> Integer.compare(b.getValue().size(), a.getValue().size()));

        System.out.println("Most Played Songs (by unique users):");
        for (Map.Entry<Integer, Set<Integer>> entry : sortedSongs) {
            System.out.println(songs.get(entry.getKey()) + " - Played by " + entry.getValue().size() + " unique users");
        }
    }

    // Function to get the last three played songs
    public List<String> getLastThreePlayed() {
        List<String> lastThreeSongs = new ArrayList<>();
        for (int songId : globalPlayHistory) {
            lastThreeSongs.add(songs.get(songId));
        }
        return lastThreeSongs;
    }

    public static void main(String[] args) {
        SpotifyService spotify = new SpotifyService();

        int song1 = spotify.addSong("Song A");
        int song2 = spotify.addSong("Song B");
        int song3 = spotify.addSong("Song C");
        int song4 = spotify.addSong("Song D");

        spotify.playSong(song1, 101);
        spotify.playSong(song2, 101);
        spotify.playSong(song3, 102);
        spotify.playSong(song4, 103);
        spotify.playSong(song1, 102);

        spotify.printAnalytics();

        System.out.println("Last Three Played Songs: " + spotify.getLastThreePlayed());
    }
}
