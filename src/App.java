import java.util.ArrayList;

public class App {
    public static void main(String[] args)
    {
        // Variable to store the songs
        ArrayList<Song> songs;

        // import the songs from the CSV using the SongImporter
        songs = SongImporter.importSongsFromCSV("songs.csv");
        int songCount = 0;
        int count1982 = 0;
        int count1998 = 0;
        int count2011 = 0;
        int countGreaterThan075 = 0;
        String SongWithlongestlen = "";
        int longestlen = 0;
        double lowestShakeability = 1.0;
        String lowestShakeabilityName = "";
        double highestLoudness = 0.0;
        String highestLoudnessName = "";
        double obscenity1950s = 0.0;
        int count1950s = 0;
        double obscenity1960s = 0.0;
        int count1960s = 0;
        double obscenity1970s = 0.0;
        int count1970s = 0;
        double obscenity1980s = 0.0;
        int count1980s = 0;
        double obscenity1990s = 0.0;
        int count1990s = 0;
        double obscenity2000s = 0.0;
        int count2000s = 0;
        double obscenity2010s = 0.0;
        int count2010s = 0;

        // Loop across all the songs imported
        for (int i=0; i<songs.size(); i++)
        {
            // Get the current song matching the loop index i
            Song s = songs.get(i);
            String releasedate = s.getReleaseDate();

            //check if release date is 1982, 1998, or 2011
            if (releasedate.equals("1982")){
                count1982++;
            } else if (releasedate.equals("1998")){
                count1998++;
            } else if (releasedate.equals("2011")){
                count2011++;
            }
            songCount ++;

            //check if danceability>0.75
            double danceAbility = Double.parseDouble(s.getDanceability());
            if (danceAbility > 0.75){
                countGreaterThan075++;
            }

            //check for longest length
            int currentLen=Integer.parseInt(s.getLength());
            if (currentLen > longestlen){
                SongWithlongestlen = s.getTitle();
                longestlen = currentLen;
            }

            //check for lowest shakeability
            double currentShake = Double.parseDouble(s.getShakeTheAudience());
            if (currentShake < lowestShakeability){
                lowestShakeabilityName = s.getTitle();
                lowestShakeability = currentShake;
            }

            //check for loudest song
            double currentloudness=Double.parseDouble(s.getLoudness());
            if (currentloudness > highestLoudness){
                highestLoudnessName = s.getTitle();
                highestLoudness = currentloudness;

            //check avg obscenity
            }
            int releasedateint = Integer.parseInt(releasedate);
            double currentObscenity = Double.parseDouble(s.getObscene());
            if (releasedateint >= 1950  && releasedateint < 1960){
                obscenity1950s += currentObscenity;
                count1950s++;
            } else if (releasedateint >= 1960  && releasedateint < 1970){
                obscenity1960s += currentObscenity;
                count1960s++;
            } else if (releasedateint >= 1970  && releasedateint < 1980){
                obscenity1970s += currentObscenity;
                count1970s++;
            } else if (releasedateint >= 1980  && releasedateint < 1990){
                obscenity1980s += currentObscenity;
                count1980s++;
            } else if (releasedateint >= 1990  && releasedateint < 2000){
                obscenity1990s += currentObscenity;
                count1990s++;
            } else if (releasedateint >= 2000  && releasedateint < 2010){
                obscenity2000s += currentObscenity;
                count2000s++;
            } else if (releasedateint >= 2010  && releasedateint <= 2019){
                obscenity2010s += currentObscenity;
                count2010s++;
            }
            // Example - print the song
            // You should add code to compute song statistics here.
            //System.out.println("Artist:" + s.getArtist());
        }
        System.out.println("Total number of songs: " + songCount); 
        System.out.println("Number of songs from 1982: " + count1982);
        System.out.println("Number of songs from 1998: " + count1998);
        System.out.println("Number of songs from 2011: " + count2011);   
        System.out.println(countGreaterThan075 + " songs have danceability score greater than 0.75");
        System.out.println("Song with the largest length is \"" + SongWithlongestlen + "\" with a length of " + longestlen + " seconds");
        System.out.println("Song with the lowest shakeability is \"" + lowestShakeabilityName + "\" with a shakeability score of " + lowestShakeability);
        System.out.println("Loudest song is \"" + highestLoudnessName + "\" with a loudness rating of " + highestLoudness);
        System.out.println("Average obscenity level in 1950s: " + Song.getAverage(obscenity1950s,count1950s));
        System.out.println("Average obscenity level in 1960s: " + Song.getAverage(obscenity1960s,count1960s));
        System.out.println("Average obscenity level in 1970s: " + Song.getAverage(obscenity1970s,count1970s));
        System.out.println("Average obscenity level in 1980s: " + Song.getAverage(obscenity1980s,count1980s));
        System.out.println("Average obscenity level in 1990s: " + Song.getAverage(obscenity1990s,count1990s));
        System.out.println("Average obscenity level in 2000s: " + Song.getAverage(obscenity2000s,count2000s));
        System.out.println("Average obscenity level in 2010s: " + Song.getAverage(obscenity2010s,count2010s));

    }
}

