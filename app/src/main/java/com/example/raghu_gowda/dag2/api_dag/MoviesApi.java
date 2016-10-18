package com.example.raghu_gowda.dag2.api_dag;

import com.example.raghu_gowda.dag2.model.EventResponse;
import com.example.raghu_gowda.dag2.model.Genre;
import com.example.raghu_gowda.dag2.model.Movie;
import com.example.raghu_gowda.dag2.model.Review;
import com.example.raghu_gowda.dag2.model.Sort;
import com.example.raghu_gowda.dag2.model.Video;

import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;
import rx.Observable;


public interface MoviesApi {

//    @GET("/genre/movie/list")
//    Observable<Genre.Response> genres();
//
//    @GET("/discover/movie")
//    Observable<Movie.Response> discoverMovies(
//            @Query("sort_by") Sort sort,
//            @Query("page") int page);
//
//    @GET("/discover/movie")
//    Observable<Movie.Response> discoverMovies(
//            @Query("sort_by") Sort sort,
//            @Query("page") int page,
//            @Query("include_adult") boolean includeAdult);
//
//    @GET("/movie/{id}/videos")
//    Observable<Video.Response> videos(
//            @Path("id") long movieId);
//
//    @GET("/movie/{id}/reviews")
//    Observable<Review.Response> reviews(
//            @Path("id") long movieId,
//            @Query("page") int page);


    @GET("/2/categories?&sign=true")
    Observable<EventResponse> getCategory(@Query("key") String api_key, @Query("group_urlname") String url_name);
}


