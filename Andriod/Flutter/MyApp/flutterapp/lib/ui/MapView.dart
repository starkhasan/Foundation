import 'dart:async';
import 'package:flutter/material.dart';
import 'package:geolocator/geolocator.dart';
import 'package:google_maps_flutter/google_maps_flutter.dart';

class MapView extends StatefulWidget {
  @override
  _MapViewState createState() => _MapViewState();
}

class _MapViewState extends State<MapView> {

  static LatLng initialPosition;

  Completer<GoogleMapController> _completer = Completer();

  static final CameraPosition _kGooglePlex = CameraPosition(
    target: LatLng(37.43296265331129, -122.08832357078792),
    zoom: 14.4746,
  );

  static final CameraPosition _kLake = CameraPosition(
      bearing: 192.8334901395799,
      target: LatLng(37.43296265331129, -122.08832357078792),
      tilt: 59.440717697143555,
      zoom: 19.151926040649414);

  void currentLocation() async{
    final position = await Geolocator().getCurrentPosition(desiredAccuracy: LocationAccuracy.high);
    print(position);
    initialPosition = LatLng(position.latitude, position.longitude);
  }

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        centerTitle: true,
        title: Text(
          'GoogleMap',
          style: TextStyle(color: Colors.white,fontFamily: 'MontserratSemiBold',fontSize: 18.0)
        ),
      ),
      body:GoogleMap(
        mapType: MapType.normal,
        onMapCreated: (GoogleMapController controller){
          _completer.complete(controller);
        },
        initialCameraPosition: _kGooglePlex,
        
      ),
      floatingActionButton: FloatingActionButton.extended(
        onPressed: _goToTheLake,
        label: Text(
          'To the lake!',
          style: TextStyle(color: Colors.white,fontFamily: 'MontserratSemiBold',fontSize: 16.0)
        ),
        icon: Icon(Icons.directions_boat),
      )
    );
  }

  Future<void> _goToTheLake() async {
    currentLocation();
    final GoogleMapController controller = await _completer.future;
    controller.animateCamera(CameraUpdate.newCameraPosition(_kLake));
  }

}