package com.example.raghu_gowda.dag2.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;


import java.util.ArrayList;
import java.util.List;


public final class Movie implements Parcelable {

    long id;


    List<Integer> genreIds = new ArrayList<>();


    String overview;


    String releaseDate;


    String posterPath;

    String backdropPath;


    double popularity;


    String title;


    double voteAverage;


    long voteCount;

    boolean favored = false;

    List<Genre> genres;

    public Movie() {}

    public long getId() {
        return id;
    }

    public Movie setId(long id) {
        this.id = id;
        return this;
    }

    public String getBackdropPath() {
        return backdropPath;
    }

    public Movie setBackdropPath(String backdropPath) {
        this.backdropPath = backdropPath;
        return this;
    }

    public List<Integer> getGenreIds() {
        return genreIds;
    }

    public Movie setGenreIds(List<Integer> genreIds) {
        this.genreIds = genreIds;
        return this;
    }

    public String getOverview() {
        return overview;
    }

    public Movie setOverview(String overview) {
        this.overview = overview;
        return this;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public Movie setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
        return this;
    }

    public String getPosterPath() {
        return posterPath;
    }

    public Movie setPosterPath(String posterPath) {
        this.posterPath = posterPath;
        return this;
    }

    public double getPopularity() {
        return popularity;
    }

    public Movie setPopularity(double popularity) {
        this.popularity = popularity;
        return this;
    }

    public String getTitle() {
        return title;
    }

    public Movie setTitle(String title) {
        this.title = title;
        return this;
    }

    public double getVoteAverage() {
        return voteAverage;
    }

    public Movie setVoteAverage(double voteAverage) {
        this.voteAverage = voteAverage;
        return this;
    }

    public long getVoteCount() {
        return voteCount;
    }

    public Movie setVoteCount(long voteCount) {
        this.voteCount = voteCount;
        return this;
    }

    public boolean isFavored() {
        return favored;
    }

    public Movie setFavored(boolean favored) {
        this.favored = favored;
        return this;
    }

    public List<Genre> getGenres() {
        return genres;
    }

    public Movie setGenres(List<Genre> genres) {
        this.genres = genres;
        return this;
    }

    public String makeGenreIdsList() {

        StringBuilder sb = new StringBuilder();
        sb.append(genreIds.get(0));
        for (int i = 1; i < genreIds.size(); i++) {
            sb.append(",").append(genreIds.get(i));
        }
        return sb.toString();
    }

    // TODO: Think about possible problems here
    public Movie putGenreIdsList(String ids) {
        if (!TextUtils.isEmpty(ids)) {
            genreIds = new ArrayList<>();
            String[] strs = ids.split(",");
            for (String s : strs)
                genreIds.add(Integer.parseInt(s));
        }
        return this;
    }

    @Override
    public String toString() {
        return "Movie{" + " title='" + title + '}';
    }

    public static final class Response {


        public int page;


        public int totalPages;


        public int totalMovies;


        public List<Movie> movies = new ArrayList<>();
    }

    // --------------------------------------------------------------------------------------

    @Override
    public int describeContents() { return 0; }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeLong(this.id);
        dest.writeList(this.genreIds);
        dest.writeString(this.overview);
        dest.writeString(this.releaseDate);
        dest.writeString(this.posterPath);
        dest.writeString(this.backdropPath);
        dest.writeDouble(this.popularity);
        dest.writeString(this.title);
        dest.writeDouble(this.voteAverage);
        dest.writeLong(this.voteCount);
        dest.writeByte(favored ? (byte) 1 : (byte) 0);
        dest.writeTypedList(genres);
    }

    protected Movie(Parcel in) {
        this.id = in.readLong();
        this.genreIds = new ArrayList<Integer>();
        in.readList(this.genreIds, List.class.getClassLoader());
        this.overview = in.readString();
        this.releaseDate = in.readString();
        this.posterPath = in.readString();
        this.backdropPath = in.readString();
        this.popularity = in.readDouble();
        this.title = in.readString();
        this.voteAverage = in.readDouble();
        this.voteCount = in.readLong();
        this.favored = in.readByte() != 0;
        this.genres = in.createTypedArrayList(Genre.CREATOR);
    }

    public static final Creator<Movie> CREATOR = new Creator<Movie>() {
        public Movie createFromParcel(Parcel source) {return new Movie(source);}

        public Movie[] newArray(int size) {return new Movie[size];}
    };
}
