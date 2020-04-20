import 'dart:async';
import 'package:flutter/material.dart';

import 'NaturallyLogin.dart';

class SplashScreen extends StatefulWidget {
  @override
  State<StatefulWidget> createState() => _SplashScreenState();
}

class _SplashScreenState extends State<SplashScreen> {

  @override
  void initState() {
    super.initState();
    startTimer();
  }

  @override
  Widget build(BuildContext context) {
    return Material(
      color: Colors.blue,
      child: Center(child: Image.asset('assets/images/interval.png')),
    );
  }

  startTimer() {
    var _duration = Duration(milliseconds: 5000);
    return Timer(_duration, navigate);
  }

  navigate() async {
    Navigator.push(context,MaterialPageRoute(builder: (context) => NaturallyLogin()));
  }
}