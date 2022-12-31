package com.example.movieapp.core

import com.example.movieapp.data.web.model.moviedetail.Movie
import com.example.movieapp.data.web.model.moviedetail.MovieDetails
import com.example.movieapp.data.web.model.moviedetail.Rating


object TestConstants {

    var movie = listOf(
        Movie(
            Title = "Captain Marvel",
            Year = "1992",
            imdbID = "tt3067038",
            Type = "movie",
            Poster = "https://m.media-amazon.com/images/M/MV5BMTE0YWFmOTMtYTU2ZS00ZTIxLWE3OTEtYTNiYzBkZjViZThiXkEyXkFqcGdeQXVyODMzMzQ4OTI@._V1_SX300.jpg"
        ),
        Movie(
            Title = "Adventures of Captain Marvel",
            Year = "2020",
            imdbID = "tt304438",
            Type = "movie",
            Poster = "https://m.media-amazon.com/images/M/MV5BMTE0YWFmOTMtYTU2ZS00ZTIxLWE3OTEtYTNiYzBkZjViZThiXkEyXkFqcGdeQXVyODMzMzQ4OTI@._V1_SX300.jpg"
        ),
        Movie(
            Title = "Captain",
            Year = "1987",
            imdbID = "tt30645038",
            Type = "movie",
            Poster = "https://m.media-amazon.com/images/M/MV5BMTE0YWFmOTMtYTU2ZS00ZTIxLWE3OTEtYTNiYzBkZjViZThiXkEyXkFqcGdeQXVyODMzMzQ4OTI@._V1_SX300.jpg"
        )
    )

    var movieDetails = MovieDetails(
        Title = "Captain Marvel",
        Year = "2019",
        Rated = "PG-13",
        Released = "08 Mar 2019",
        Runtime = "123 min",
        Genre = "Action, Adventure, Sci-Fi",
        Director = "Anna Boden, Ryan Fleck",
        Writer = "Anna Boden, Ryan Fleck, Geneva Robertson-Dworet",
        Actors = "Brie Larson, Samuel L. Jackson, Ben Mendelsohn",
        Plot = "Carol Danvers becomes one of the universe's most powerful heroes when Earth is caught in the middle of a galactic war between two alien races.",
        Language = "English",
        Country = "United States, Australia",
        Awards = "9 wins & 56 nominations",
        Poster = "https://m.media-amazon.com/images/M/MV5BMTE0YWFmOTMtYTU2ZS00ZTIxLWE3OTEtYTNiYzBkZjViZThiXkEyXkFqcGdeQXVyODMzMzQ4OTI@._V1_SX300.jpg",
        Ratings = listOf(
            Rating(
                Source = "Internet Movie Database",
                Value = "6.8/10"
            ),
            Rating(
                Source = "Rotten Tomatoes",
                Value = "79%"
            )
        ),
        Metascore = "64",
        imdbRating = "6.8",
        imdbVotes = "515,178",
        imdbID = "tt4154664",
        Type = "movie",
        DVD = "28 May 2019",
        BoxOffice = "$426,829,839",
        Production = "N/A",
        Website = "N/A",
        Response = "True",
        Error = ""
    )

    val movieDetailsFailed = MovieDetails(Response = "False", Error = "Incorrect IMDb ID.")

}