import 'models/media.dart';
import 'models/book.dart';
import 'models/movie.dart';

class DatabaseService {
  List<Media> books = [];
  List<Media> movies = [];

  Future<List<Media>> getBooks() async {
    return books;
  }

  Future<void> addBook(Book book) async {
    books.add(book);
  }

  Future<void> deleteBook(String id) async {
    books.removeWhere((book) => book.id == id);
  }

  Future<List<Media>> getMovies() async {
    return movies;
  }

  Future<void> addMovie(Movie movie) async {
    movies.add(movie);
  }

  Future<void> deleteMovie(String id) async {
    movies.removeWhere((movie) => movie.id == id);
  }
}
