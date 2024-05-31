abstract class Media {
  String title;
  int publicationYear;
  String? genre;

  static int _lastId = 0;
  final int _id;

  Media(this.title, this.publicationYear, {this.genre}) : _id = ++_lastId;

  int get id => _id;

  @override
  String toString() {
    return 'Title: $title, Year: $publicationYear';
  }
}

class Movie extends Media {
  String director;
  int? durationMinutes;

  Movie(super.title, super.year, this.director,
      {super.genre, this.durationMinutes});

  @override
  String toString() {
    if (durationMinutes == null) {
      return 'ID: $id, Title: $title, Year: $publicationYear, Director: $director';
    } else {
      return 'ID: $id, Title: $title, Year: $publicationYear, Director: $director, Duration: $durationMinutes minutes';
    }
  }
}

class Book extends Media {
  String author;
  String? iban;

  Book(super.title, super.year, this.author, {super.genre, this.iban});

  @override
  String toString() {
    if (iban == null) {
      return 'ID: $id, Title: $title, Year: $publicationYear, Author: $author';
    } else {
      return 'ID: $id, Title: $title, Year: $publicationYear, Author: $author, IBAN: $iban';
    }
  }
}
