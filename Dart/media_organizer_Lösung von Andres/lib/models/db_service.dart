import 'package:media_organizer/models/media.dart';

class DatabaseService {
  List<Book> books = [];
  List<Movie> movies = [];

  Future<List<Media>> getAllBooks() async {
    await Future.delayed(Duration(milliseconds: 700));
    return books;
  }

  Future<void> addBook(Book book) async {
    await Future.delayed(Duration(milliseconds: 100));
    books.add(book);
  }

  Future<Book> deleteBook(String title) async {
    await Future.delayed(Duration(milliseconds: 300));
    var deletedItem = books.firstWhere((book) => book.title == title);
    books.removeWhere((book) => book.title == title);
    return deletedItem;
  }

  Future<List<Book>> findBooks(
      {String? author, String? genre, int? year}) async {
    await Future.delayed(Duration(milliseconds: 2000));
    return books.where((book) {
      return (author == null || book.author == author) &&
          (genre == null || book.genre == genre) &&
          (year == null || book.publicationYear == year);
    }).toList();
  }

  Future<List<Media>> getAllMovies() async {
    await Future.delayed(Duration(milliseconds: 600));
    return movies;
  }

  Future<void> addMovie(Movie movie) async {
    await Future.delayed(Duration(milliseconds: 250));
    movies.add(movie);
  }

  Future<Movie> deleteMovie(String title) async {
    await Future.delayed(Duration(milliseconds: 300));
    var deletedItem = movies.firstWhere((movie) => movie.title == title);
    books.removeWhere((book) => book.title == title);
    return deletedItem;
  }

  Future<List<Movie>> findMovies(
      {String? director, String? genre, int? year}) async {
    await Future.delayed(Duration(milliseconds: 1200));
    return movies.where((movie) {
      return (director == null || movie.director == director) &&
          (genre == null || movie.genre == genre) &&
          (year == null || movie.publicationYear == year);
    }).toList();
  }
}
