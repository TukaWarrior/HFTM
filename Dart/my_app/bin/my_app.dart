import 'dart:convert';
import 'dart:io';

import 'package:my_app/car.dart';
import 'package:my_app/movie.dart';
import 'package:my_app/my_app.dart' as my_app;

void main(List<String> arguments) {
  // print('Hello world: ${my_app.calculate()}!');

  var _movies = [];
  print('Enter a movie name:');
  var line_name = stdin.readLineSync(encoding: utf8);
  print('Enter the producer:');
  var line_creator = stdin.readLineSync(encoding: utf8);
  print('Enter a release year:');
  var line_year = stdin.readLineSync(encoding: utf8);
  print('Enter a length:');
  var line_length = stdin.readLineSync(encoding: utf8);

  var movie = Movie(line_name.toString(), line_creator.toString(),
      line_year.toString(), line_length.toString());
  _movies.add(movie);

  print(_movies);
}
