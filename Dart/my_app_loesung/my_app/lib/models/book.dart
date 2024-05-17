import 'media.dart';

class Book extends Media {
  String isbn;

  Book(String title, String year, String creator, String genre, this.isbn)
      : super(title, creator, year, genre);

  @override
  String toString() {
    return 'ID: $id, Title: $title, Year: $year, Director: $creator, Genre: $genre, ISBN: $isbn';
  }
}
