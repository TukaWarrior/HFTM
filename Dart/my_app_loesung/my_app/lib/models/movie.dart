import 'media.dart';

class Movie extends Media {
  String length;

  Movie(String title, String year, String creator, String genre, this.length)
      : super(title, creator, year, genre);

  @override
  String toString() {
    return 'ID: $id, Title: $title, Year: $year, Director: $creator, Genre: $genre, Runtime: $length';
  }
}
