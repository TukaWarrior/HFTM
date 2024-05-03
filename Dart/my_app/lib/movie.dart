import 'package:my_app/media.dart';

class Movie extends Media {
  String _length;

  Movie(String name, String creator, String year, this._length)
      : super(name, creator, year);

  get length => _length;

  @override
  String toString() {
    return super.name;
  }
}
