class Media {
  String _name;
  String _creator;
  String _year;

  Media(this._name, this._creator, this._year);

  get name => _name;
  get creator => _creator;
  get year => _year;

  @override
  String toString() {
    return _name;
  }
}
