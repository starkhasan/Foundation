import 'dart:convert';

class MedicationsExample {
  List<Medications> medications;
  List<Imaging> labs;
  List<Imaging> imaging;

  MedicationsExample({required this.medications,required this.labs,required this.imaging});

  factory MedicationsExample.formJson(Map<String, dynamic> json){
    return MedicationsExample(
      medications: List<Medications>.from(json['medications'].map((x) => Medications.fromJson(x))),
      labs: List<Imaging>.from(json['labs'].map((x) => Imaging.fromJson(x))),
      imaging: List<Imaging>.from(json['imaging'].map((x) => Imaging.fromJson(x)))
    );
  }
}

class Medications {
  List<AceInhibitors> aceInhibitors;
  List<AceInhibitors> antianginal;
  List<AceInhibitors> anticoagulants;
  List<AceInhibitors> betaBlocker;
  List<AceInhibitors> diuretic;
  List<AceInhibitors> mineral;

  Medications({
    required this.aceInhibitors,
    required this.antianginal,
    required this.anticoagulants,
    required this.betaBlocker,
    required this.diuretic,
    required this.mineral
  });

  factory Medications.fromJson(Map<String, dynamic> json){
    return Medications(
      aceInhibitors: List<AceInhibitors>.from(json['aceInhibitors'].map((x) => AceInhibitors.fromJson(x))),
      antianginal: List<AceInhibitors>.from(json['antianginal'].map((x) => AceInhibitors.fromJson(x))),
      anticoagulants: List<AceInhibitors>.from(json['anticoagulants'].map((x) => AceInhibitors.fromJson(x))),
      betaBlocker: List<AceInhibitors>.from(json['betaBlocker'].map((x) => AceInhibitors.fromJson(x))),
      diuretic: List<AceInhibitors>.from(json['diuretic'].map((x) => AceInhibitors.fromJson(x))),
      mineral: List<AceInhibitors>.from(json['mineral'].map((x) => AceInhibitors.fromJson(x)))
    );
  }
}

class AceInhibitors {
  String name;
  String strength;
  String dose;
  String route;
  String sig;
  String pillCount;
  String refills;

  AceInhibitors({
    required this.name,
    required this.strength,
    required this.dose,
    required this.route,
    required this.sig,
    required this.pillCount,
    required this.refills
  });

  factory AceInhibitors.fromJson(Map<String, dynamic> json){
    return AceInhibitors(
      name: json['name'],
      strength: json['strength'],
      dose: json['dose'],
      route: json['route'],
      sig: json['sig'],
      pillCount: json['pillCount'],
      refills: json['refills']
    );
  }
}

class Imaging {
  String name;
  String time;
  String location;

  Imaging({required this.name,required this.time,required this.location});
  factory Imaging.fromJson(Map<String, dynamic> json){
    return Imaging(
      name: json['name'],
      time: json['time'],
      location: json['location']    
    );
  }
}

void main(List<String> args) {
  var data = '''{
    "medications":[{
            "aceInhibitors":[{
                "name":"lisinopril",
                "strength":"10 mg Tab",
                "dose":"1 tab",
                "route":"PO",
                "sig":"daily",
                "pillCount":"#90",
                "refills":"Refill 3"
            }],
            "antianginal":[{
                "name":"nitroglycerin",
                "strength":"0.4 mg Sublingual Tab",
                "dose":"1 tab",
                "route":"SL",
                "sig":"q15min PRN",
                "pillCount":"#30",
                "refills":"Refill 1"
            }],
            "anticoagulants":[{
                "name":"warfarin sodium",
                "strength":"3 mg Tab",
                "dose":"1 tab",
                "route":"PO",
                "sig":"daily",
                "pillCount":"#90",
                "refills":"Refill 3"
            }],
            "betaBlocker":[{
                "name":"metoprolol tartrate",
                "strength":"25 mg Tab",
                "dose":"1 tab",
                "route":"PO",
                "sig":"daily",
                "pillCount":"#90",
                "refills":"Refill 3"
            }],
            "diuretic":[{
                "name":"furosemide",
                "strength":"40 mg Tab",
                "dose":"1 tab",
                "route":"PO",
                "sig":"daily",
                "pillCount":"#90",
                "refills":"Refill 3"
            }],
            "mineral":[{
                "name":"potassium chloride ER",
                "strength":"10 mEq Tab",
                "dose":"1 tab",
                "route":"PO",
                "sig":"daily",
                "pillCount":"#90",
                "refills":"Refill 3"
            }]
        }
    ],
    "labs":[{
        "name":"Arterial Blood Gas",
        "time":"Today",
        "location":"Main Hospital Lab"
        },
        {
        "name":"BMP",
        "time":"Today",
        "location":"Primary Care Clinic"
        },
        {
        "name":"BNP",
        "time":"3 Weeks",
        "location":"Primary Care Clinic"
        },
        {
        "name":"BUN",
        "time":"1 Year",
        "location":"Primary Care Clinic"
        },
        {
        "name":"Cardiac Enzymes",
        "time":"Today",
        "location":"Primary Care Clinic"
        },
        {
        "name":"CBC",
        "time":"1 Year",
        "location":"Primary Care Clinic"
        },
        {
        "name":"Creatinine",
        "time":"1 Year",
        "location":"Main Hospital Lab"
        },
        {
        "name":"Electrolyte Panel",
        "time":"1 Year",
        "location":"Primary Care Clinic"
        },
        {
        "name":"Glucose",
        "time":"1 Year",
        "location":"Main Hospital Lab"
        },
        {
        "name":"PT/INR",
        "time":"3 Weeks",
        "location":"Primary Care Clinic"
        },
        {
        "name":"PTT",
        "time":"3 Weeks",
        "location":"Coumadin Clinic"
        },
        {
        "name":"TSH",
        "time":"1 Year",
        "location":"Primary Care Clinic"
        }
    ],
    "imaging":[{
        "name":"Chest X-Ray",
        "time":"Today",
        "location":"Main Hospital Radiology"
        },
        {
        "name":"Chest X-Ray",
        "time":"Today",
        "location":"Main Hospital Radiology"
        },
        {
        "name":"Chest X-Ray",
        "time":"Today",
        "location":"Main Hospital Radiology"
        }
    ]
}''';

  var response = MedicationsExample.formJson(jsonDecode(data));
  for (var itemLabs in response.labs) {
    print('\nLab Name -> ${itemLabs.name}');
    print('Lab Time -> ${itemLabs.time}');
    print('Location -> ${itemLabs.location}');
  }
}
