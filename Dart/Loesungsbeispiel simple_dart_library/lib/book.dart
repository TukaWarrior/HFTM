class Book {
  final String _title;
  String? author;
  final int publicationYear;
  final String genre;

  Book(
      {required String title,
      this.author,
      required this.publicationYear,
      required this.genre})
      : _title = title;

  Book.defaultBook(this._title)
      : author = 'UNBEKANNT',
        publicationYear = DateTime.now().year,
        genre = 'UNBEKANNT';

  /// Getter für den Titel
  String get title => _title;

  // Konstruktor für die Erstellung aus einer Map
  Book.fromJson(Map<String, dynamic> json)
      : _title = json['title'],
        author = json['author'],
        publicationYear = json['publicationYear'],
        genre = json['genre'];

  // Methode zur Umwandlung in eine Map
  Map<String, dynamic> toJson() => {
        'title': title,
        'author': author,
        'publicationYear': publicationYear,
        'genre': genre,
      };

  @override
  String toString() {
    return '$genre: $title von ${author ?? 'UNBEKANNT'} ($publicationYear)';
  }

  // Bücher vergleichbar machen mit == Operator und hashCode
  @override
  bool operator ==(Object other) =>
      identical(this, other) ||
      other is Book &&
          runtimeType == other.runtimeType &&
          _title == other._title &&
          author == other.author &&
          publicationYear == other.publicationYear &&
          genre == other.genre;

  @override
  int get hashCode =>
      _title.hashCode ^
      author.hashCode ^
      publicationYear.hashCode ^
      genre.hashCode;
}
