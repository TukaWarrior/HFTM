// Datenbank-Simulation
import 'package:dart_library/book.dart';

class Database {
  final List<Book> _books = [];

  /// Funktion zum Hinzufügen eines Buchs
  Future<void> addBook(Book book) async {
    await Future.delayed(
        Duration(seconds: 1)); // Simuliert eine asynchrone I/O-Operation
    _books.add(book);
  }

  /// Funktion zum Anzeigen aller Bücher
  Future<List<Book>> getAllBooks() async {
    await Future.delayed(
        Duration(seconds: 1)); // Simuliert eine asynchrone I/O-Operation
    return List<Book>.from(_books);
  }

  /// Funktion zum Suchen nach Büchern nach bestimmten Kriterien
  Future<List<Book>> searchBooks(
      {String? author, String? genre, int? publicationYear}) async {
    await Future.delayed(
        Duration(seconds: 1)); // Simuliert eine asynchrone I/O-Operation
    return _books.where((book) {
      return (author == null || book.author == author) &&
          (genre == null || book.genre == genre) &&
          (publicationYear == null || book.publicationYear == publicationYear);
    }).toList();
  }

  /// Funktion zum Löschen eines Buchs
  Future<void> deleteBook(Book book) async {
    await Future.delayed(
        Duration(seconds: 1)); // Simuliert eine asynchrone I/O-Operation
    _books.remove(book);
  }
}
