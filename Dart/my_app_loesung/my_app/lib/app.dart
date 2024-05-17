import 'database_service.dart';
import 'models/media.dart';
import 'models/book.dart';
import 'models/movie.dart';

Future<void> main(List<String> arguments) async {
  var db = DatabaseService();
  await db.addBook(Book("Book", "2000", "Someone", "Something", "Number"));
  await db.addMovie(Movie("Movie", "2000", "Someone", "Something", "Number"));

  print('All books:');
  var books = await db.getBooks();
  books.forEach(print);

  print('All movies:');
  var movies = await db.getMovies();
  movies.forEach(print);

  // print("\nBooks by Johann Wolfgang von Goethe:");
  // var orwellBooks = await db.findBooks(author: "Johann Wolfgang von Goethe");
  // orwellBooks.forEach(print);

  // print("\nDeleting Gedichte:");
  // var deleted = await db.deleteBook("Gedichte");
  // print("Deleted: $deleted");

  // print('\nAll books after deletion:');
  // books = await db.getAllBooks();
  // books.forEach(print);
}
