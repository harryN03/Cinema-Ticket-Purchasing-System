public class Movie{
    public static enum MovieStatus {PLAYINGNOW, PLAYINGSOON, RELEASEDSOON};

    public String title;
    public String description;
    public int duration; //Duration in hours
    public int movieID;
    public Showtime[] movieShowTime;
    public MovieStatus movieStatus;


    public Movie(String title, String description) {
        this.title = title;
        this.description = description;
    }

    public Movie(String title, String description, int duration, Showtime[] showTime, int movieID) {
        this.title = title;
        this.description = description;
        this.duration = duration;
        this.movieID = movieID;
        this.movieShowTime = showTime;
    }

    public Movie(String title, String description, int duration, int movieID, Showtime[] showTimes, MovieStatus status) {
        this.title = title;
        this.description = description;
        this.duration = duration;
        this.movieID = movieID;
        this.movieShowTime = showTimes;
        this.movieStatus = status;
    }
    public String getTitle() {
        return this.title;
    }

    public Showtime getShow(String date, String time) {
        for (Showtime i : this.movieShowTime) {
            if (date.equals(i.getDate()) && time.equals(i.time)) {
                return i;
            }
        }
        //Returns null 
        return null;
    }

    public void showMovieTime() {
        for (Showtime i : this.movieShowTime) {
            System.out.println(i.date + " " + i.time);
        }
    }

    public MovieStatus getMovieStatus() {
        return this.movieStatus;
    }

    public void setMovieStatus(MovieStatus status) {
        this.movieStatus = status;
    }
    
    public String toString() {
        return this.title + ", " + this.duration;
    }

}