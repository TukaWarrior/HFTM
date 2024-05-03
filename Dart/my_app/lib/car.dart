class Book {
  String _name;
  String _author;
  int _year;

  Book(this._name, this._author, this._year);

  get name => _name;
  get author => _author;
  get year => _year;

  // @override
  // String toString() {
  // return "Car: $_name, Brand: ${brand?.toUpperCase()}, Year: ${year != null ? "was the year it relased" : ""}";
  // }
}
