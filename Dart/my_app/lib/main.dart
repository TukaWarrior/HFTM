import 'dart:js_util';

void start() {
  int a = 5;
  int b = 4;

  int c = Calculate(a, b);
  print("The result is $c");
  print(c);
}

int Calculate(int a, int b) {
  return a + b;
}
