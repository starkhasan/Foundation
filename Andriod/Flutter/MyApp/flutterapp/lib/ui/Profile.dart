import 'package:flutter/material.dart';
import 'package:toast/toast.dart';

class Profile extends StatefulWidget{
  @override
  _MyProfilePage createState() => _MyProfilePage();
}

class _MyProfilePage extends State<Profile>{

  bool _obscureText = true;
  bool _obscureText1 = true;
  

  void _toggle() {
    setState(() {
      _obscureText = !_obscureText;
    });
  }

  void _toggle1(){
    setState(() {
      _obscureText1 = !_obscureText1;
    });
  }

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        centerTitle: true,
        title: Text('Profile'),
      ),
      body: Container(
        padding: EdgeInsets.fromLTRB(15, 20, 15, 10),
        child: SingleChildScrollView(
          child: Column(
            mainAxisAlignment: MainAxisAlignment.start,
            children:<Widget>[
              Row(
                mainAxisAlignment: MainAxisAlignment.spaceBetween,
                children:<Widget>[
                  Flexible(
                    child: Column(
                      crossAxisAlignment: CrossAxisAlignment.start,
                      children: <Widget>[
                        Text(
                          'First Name',
                          style: TextStyle(color: Colors.black,fontFamily: 'MontserratSemiBold',fontSize: 16.0),
                        ),
                        SizedBox(height: 2.0),
                        Container(
                          height: 50,
                          child: TextField(
                            obscureText: false,
                            keyboardType: TextInputType.text,
                            textInputAction: TextInputAction.done,
                            style: TextStyle(color: Colors.black,fontSize: 16.0,fontFamily: 'MontserratRegular',fontStyle: FontStyle.normal),
                            decoration: InputDecoration(
                              hintText: 'First Name',
                              border: OutlineInputBorder(
                                borderRadius: BorderRadius.circular(5.0),
                                borderSide: BorderSide(color: Colors.black)
                              )
                            )
                          )
                        )
                      ]
                    )
                  ),
                  SizedBox(width: 10.0,),
                  Flexible(
                    child: Column(
                      crossAxisAlignment: CrossAxisAlignment.start,
                      children: <Widget>[
                        Text(
                          'Last Name',
                          style: TextStyle(color: Colors.black,fontFamily: 'MontserratSemiBold',fontSize: 16.0),
                        ),
                        SizedBox(height: 2.0),
                        Container(
                          height: 50,
                          child: TextField(
                            obscureText: false,
                            keyboardType: TextInputType.text,
                            textInputAction: TextInputAction.done,
                            style: TextStyle(color: Colors.black,fontSize: 16.0,fontFamily: 'MontserratRegular',fontStyle: FontStyle.normal),
                            decoration: InputDecoration(
                              hintText: 'Last Name',
                              border: OutlineInputBorder(
                                borderRadius: BorderRadius.circular(5.0),
                                borderSide: BorderSide(color: Colors.black)
                              )
                            )
                          )
                        )
                      ]
                    )
                  )
                ]
              ),
              SizedBox(height: 10.0),        
              Column(
                crossAxisAlignment: CrossAxisAlignment.start,
                children: <Widget>[
                  Text(
                    'Email',
                    style:TextStyle(color: Colors.black,fontFamily: 'MontserratSemiBold',fontSize: 16.0)
                  ),
                  Container(
                    margin: EdgeInsets.fromLTRB(0, 2, 0,0),
                    height: 50,
                    child: TextField(
                      keyboardType: TextInputType.emailAddress,
                      textInputAction: TextInputAction.done,
                      obscureText: false,
                      enabled: false,
                      style: TextStyle(color: Colors.black,fontSize: 16.0,fontFamily: 'MontserratRegular',fontStyle: FontStyle.normal),
                      decoration: InputDecoration(
                        labelText: 'alihasan226@gmail.com',
                        hintText: "Email",
                        border: OutlineInputBorder(
                          borderRadius: BorderRadius.circular(5.0),
                          borderSide: BorderSide(color: Colors.black)
                        )
                      )
                    )
                  )
                ]
              ),
              SizedBox(height: 10.0),
              Column(
                crossAxisAlignment: CrossAxisAlignment.start,
                children: <Widget>[
                  Text(
                    'Phone Number',
                    style:TextStyle(color: Colors.black,fontFamily: 'MontserratSemiBold',fontSize: 16.0)
                  ),
                  Container(
                    margin: EdgeInsets.fromLTRB(0, 2, 0,0),
                    height: 50,
                    child: TextField(
                      keyboardType: TextInputType.number,
                      textInputAction: TextInputAction.done,
                      obscureText: false,
                      enabled: false,
                      style: TextStyle(color: Colors.black,fontSize: 16.0,fontFamily: 'MontserratRegular',fontStyle: FontStyle.normal),
                      decoration: InputDecoration(
                        labelText: '9760656467',
                        hintText: "Phone Number",
                        border: OutlineInputBorder(
                          borderRadius: BorderRadius.circular(5.0),
                          borderSide: BorderSide(color: Colors.black)
                        )
                      )
                    )
                  )
                ]
              ),
              SizedBox(height: 10.0),
              Column(
                crossAxisAlignment: CrossAxisAlignment.start,
                children: <Widget>[
                  Text(
                    'Password',
                    style:TextStyle(color: Colors.black,fontFamily: 'MontserratSemiBold',fontSize: 16.0)
                  ),
                  Container(
                    margin: EdgeInsets.fromLTRB(0, 2, 0,0),
                    height: 50,
                    child: TextField(
                      keyboardType: TextInputType.emailAddress,
                      textInputAction: TextInputAction.done,
                      obscureText: _obscureText,
                      style: TextStyle(color: Colors.black,fontSize: 16.0,fontFamily: 'MontserratRegular',fontStyle: FontStyle.normal),
                      decoration: InputDecoration(
                        suffixIcon: IconButton(
                          tooltip: _obscureText ? 'Visibility ON':'Visibility OFF',
                          icon: _obscureText ? Icon(Icons.visibility): Icon(Icons.visibility_off),
                          onPressed: () {
                            _toggle();
                          },
                        ),
                        hintText: "Confirm Password",
                        border: OutlineInputBorder(
                          borderRadius: BorderRadius.circular(5.0),
                          borderSide: BorderSide(color: Colors.black)
                        )
                      )
                    )
                  )
                ]
              ),
              SizedBox(height: 10.0),
              Column(
                crossAxisAlignment: CrossAxisAlignment.start,
                children: <Widget>[
                  Text(
                    'Confirm Password',
                    style:TextStyle(color: Colors.black,fontFamily: 'MontserratSemiBold',fontSize: 16.0)
                  ),
                  Container(
                    margin: EdgeInsets.fromLTRB(0, 2, 0,0),
                    height: 50,
                    child: TextField(
                      keyboardType: TextInputType.emailAddress,
                      textInputAction: TextInputAction.done,
                      obscureText: _obscureText1,
                      style: TextStyle(color: Colors.black,fontSize: 16.0,fontFamily: 'MontserratRegular',fontStyle: FontStyle.normal),
                      decoration: InputDecoration(
                        suffixIcon: IconButton(
                          icon: _obscureText1 ? Icon(Icons.visibility) : Icon(Icons.visibility_off),
                          onPressed: (){
                            _toggle1();
                          },
                        ),
                        hintText: "Confirm Password",
                        border: OutlineInputBorder(
                          borderRadius: BorderRadius.circular(5.0),
                          borderSide: BorderSide(color: Colors.black)
                        )
                      )
                    )
                  )
                ]
              ),
              SizedBox(height: 10.0),
              RaisedButton(
                elevation: 10,
                color: Colors.blue,
                onPressed: (){
                  Toast.show('Clicked', context,gravity: Toast.BOTTOM,duration: Toast.LENGTH_SHORT);
                },
                padding: EdgeInsets.fromLTRB(120, 15, 120,15),
                child: Text(
                  'Update',
                  style: TextStyle(color: Colors.white,fontFamily: 'MontserratSemiBold',fontSize: 16.0),
                )
              )
            ]
          )
        ),
      )
    );
  }
}


