import 'package:flutter/material.dart';
import 'package:flutterapp/ui/LoginPage.dart';
import 'package:flutterapp/ui/splash.dart';

import 'ui/splash.dart';

class Routes {
  Routes._();
  static const String splash = '/splash';
  static const String login = '/login';


  static final routes = <String, WidgetBuilder>{
    splash: (BuildContext context) => SplashScreen(),
    login: (BuildContext context) => LoginScreen(),
  };
}

