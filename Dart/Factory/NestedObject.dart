import 'dart:convert';

class MainResponse{
  final Response response;

  MainResponse({required this.response});

  factory MainResponse.fromJson(Map<String, dynamic> json){
    return MainResponse(
      response: Response.fromJson(json['response'])
    );
  }
}

class Response{
  final Body body;
  final Status status;

  Response({required this.body,required this.status});

   factory Response.fromJson(Map<String, dynamic> json){
     return Response(
       body: Body.fromJson(json['body']),
       status: Status.fromJson(json['status'])
     );
   }
}

class Body{
  final Patients patients;
  Body({required this.patients});

  factory Body.fromJson(Map<String, dynamic> json){
    return Body(
      patients: Patients.fromJson(json['patients'])
    );
  }
}

class Patients{
  final List<PatientResponse> patientResponse;

  Patients({required this.patientResponse});

  factory Patients.fromJson(Map<String, dynamic> json){
    return Patients(
      patientResponse: List<PatientResponse>.from(json['patient'].map((item) => PatientResponse.fromJson(item)))
    );
  }
}

class PatientResponse{
  final String patientID;
  final String submittedStatus;
  final String patientType;
  final String submissionDate;

  PatientResponse({required this.patientID,required this.submittedStatus, required this.patientType, required this.submissionDate});

  factory PatientResponse.fromJson(Map<String , dynamic> json){
    return PatientResponse(
      patientID: json['patientID'],
      submittedStatus: json['submittedStatus'],
      patientType: json['patientType'],
      submissionDate: json['submissionDate']
    );
  }
}


class Status{
  final String statusCode;
  final StatusMessage statusMessage;

  Status({required this.statusCode,required this.statusMessage});

  factory Status.fromJson(Map<String, dynamic> json){
    return Status(
      statusCode: json['statusCode'],
      statusMessage: StatusMessage.fromJson(json['statusMessage'])
    );
  }
}

class StatusMessage{
  StatusMessage();
  factory StatusMessage.fromJson(Map<String, dynamic> json) => StatusMessage();
}

void main(){
    var responseBody = """
      {
        "response": {
          "body": {
            "patients": {
              "patient": [
                {
                  "patientID": "ALM22346789",
                  "submittedStatus": "In Progress",
                  "patientType": "Inpatient",
                  "submissionDate": "2020-10-15"
                }
              ]
            }
          },
          "status": {
            "statusCode": "200",
            "statusMessage": {

            }
          }
        }
      }
    """;

    var response = MainResponse.fromJson(jsonDecode(responseBody));
    print(response.response.body.patients.patientResponse[0].patientID);
}
