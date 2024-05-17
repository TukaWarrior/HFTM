import 'package:flutter/material.dart';

class HomeScreen extends StatelessWidget {
  const HomeScreen({super.key});

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: const Text("My Home Screen"),
      ),
      body: Column(
        children: [
          const Text("Hello There"),
          IconButton(onPressed: () => {}, icon: const Icon(Icons.abc_outlined))
        ],
      ),
      // body: const Text("Hello There"),
    );
  }
}
