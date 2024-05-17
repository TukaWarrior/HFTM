import 'dart:math';

class Media {
  String id = "";
  String title;
  String creator;
  String year;
  String genre;

  Media(this.title, this.creator, this.year, this.genre) {
    id = generateID(5);
  }

  String generateID(int length) {
    const _chars =
        "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
    final _random = Random();
    return String.fromCharCodes(Iterable.generate(
        length, (_) => _chars.codeUnitAt(_random.nextInt(_chars.length))));
  }
}
