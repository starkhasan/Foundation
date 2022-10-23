import 'dart:convert';

class Shop {
  String id;
  String type;
  String name;
  double ppu;
  Batters batters;
  List<Topping> topping;

  Shop({required this.id,required this.type,required this.name,required this.ppu,required this.batters,required this.topping});

  factory Shop.fromJson(Map<String, dynamic> json){
    return Shop(
      id: json['id'],
      type: json['type'],
      name: json['name'],
      ppu: json['ppu'].toDouble(),
      batters: Batters.fromJson(json['batters']),
      topping: List<Topping>.from(json['topping'].map((x) => Topping.fromJson(x)))
    );
  }
}

class Topping {
  String id;
  String type;

  Topping({required this.id,required this.type});

  factory Topping.fromJson(Map<String, dynamic> json){
    return Topping(
      id: json['id'],
      type: json['type']
    );
  }
}

class Batters {
  List<Topping> batter;

  Batters({required this.batter});

  factory Batters.fromJson(Map<String, dynamic> json){
    return Batters(
      batter: List<Topping>.from(json['batter'].map((x) => Topping.fromJson(x)))
    );
  }
}

void main(List<String> args) {
  var shopData = '''[
  {
    "id": "0001",
    "type": "donut",
    "name": "Cake",
    "ppu": 0.55,
    "batters": {
      "batter": [
        {
          "id": "1001",
          "type": "Regular"
        },
        {
          "id": "1002",
          "type": "Chocolate"
        },
        {
          "id": "1003",
          "type": "Blueberry"
        },
        {
          "id": "1004",
          "type": "Devil's Food"
        }
      ]
    },
    "topping": [
      {
        "id": "5001",
        "type": "None"
      },
      {
        "id": "5002",
        "type": "Glazed"
      },
      {
        "id": "5005",
        "type": "Sugar"
      },
      {
        "id": "5007",
        "type": "Powdered Sugar"
      },
      {
        "id": "5006",
        "type": "Chocolate with Sprinkles"
      },
      {
        "id": "5003",
        "type": "Chocolate"
      },
      {
        "id": "5004",
        "type": "Maple"
      }
    ]
  },
  {
    "id": "0002",
    "type": "donut",
    "name": "Raised",
    "ppu": 0.55,
    "batters": {
      "batter": [
        {
          "id": "1001",
          "type": "Regular"
        }
      ]
    },
    "topping": [
      {
        "id": "5001",
        "type": "None"
      },
      {
        "id": "5002",
        "type": "Glazed"
      },
      {
        "id": "5005",
        "type": "Sugar"
      },
      {
        "id": "5003",
        "type": "Chocolate"
      },
      {
        "id": "5004",
        "type": "Maple"
      }
    ]
  },
  {
    "id": "0003",
    "type": "donut",
    "name": "Old Fashioned",
    "ppu": 0.55,
    "batters": {
      "batter": [
        {
          "id": "1001",
          "type": "Regular"
        },
        {
          "id": "1002",
          "type": "Chocolate"
        }
      ]
    },
    "topping": [
      {
        "id": "5001",
        "type": "None"
      },
      {
        "id": "5002",
        "type": "Glazed"
      },
      {
        "id": "5003",
        "type": "Chocolate"
      },
      {
        "id": "5004",
        "type": "Maple"
      }
    ]
  }
]''';
  var response = List<Shop>.from(jsonDecode(shopData).map((x) => Shop.fromJson(x)));
  for (var item in response) {
    print('\nId -> ${item.id}');
    print('Type -> ${item.type}');
    print('Name -> ${item.name}');
    print('PPU -> ${item.ppu}');
    for (var batterResponse in item.batters.batter) {
      print('Batter ID -> ${batterResponse.id}');
      print('Batter Type -> ${batterResponse.type}');
    }

    for (var toppingResponse in item.topping) {
      print('Id -> ${toppingResponse.id}');
      print('Type -> ${toppingResponse.type}');
    }
  }
}
