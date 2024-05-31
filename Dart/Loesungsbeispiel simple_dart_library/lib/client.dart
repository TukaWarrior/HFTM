import 'package:dart_library/book.dart';
import 'package:dart_library/data_service.dart';

void main() async {
  final database = Database();

  // Hinzufügen von Büchern zur Datenbank
  await database.addBook(
      Book(title: "Asterix & Obelix", publicationYear: 2023, genre: "Kinder"));
  await database.addBook(Book(
      title: "Der schwarze Riter",
      publicationYear: 2021,
      genre: "Abenteuer",
      author: "Karl May"));
  await database.addBook(Book.defaultBook("Buch 1"));

  // Anzeigen aller Bücher
  final allBooks = await database.getAllBooks();
  print('Alle Bücher:');
  allBooks.forEach(print);

  // Suchen nach Büchern nach bestimmten Kriterien
  final fantasyBooks = await database.searchBooks(genre: 'Abenteuer');
  print('\nFantasy-Bücher:');
  for (var book in fantasyBooks) {
    print('${book.title} von ${book.author}');
  }

  // Löschen eines Buchs
  final bookToDelete = allBooks.firstWhere((book) => book.title == 'Buch 1');
  await database.deleteBook(bookToDelete);
  print('\nBuch 1 wurde gelöscht.');

  // Anzeigen der aktualisierten Liste aller Bücher
  final updatedBooks = await database.getAllBooks();
  print('\nAktualisierte Liste aller Bücher:');
  updatedBooks.forEach(print);
}
