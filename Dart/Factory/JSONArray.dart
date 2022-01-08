import 'dart:convert';

class Response{
  final Results results;

  Response({required this.results});

  factory Response.fromJson(Map<String, dynamic> json){
    return Response(
      results: Results.fromJson(json['results'])
    );
  }
}

class Results{
  final List<Data> result;

  Results({required this.result});

  factory Results.fromJson(Map<String, dynamic> json){
    return Results(
      result: List<Data>.from(json['result'].map((item) => Data.fromJson(item)))
    );
  }
}

class Data{
  final String cover;
  final String title;
  final String year;
  final String director;
  final String rating;
  final String details;

  Data({required this.cover, required this.title, required this.year, required this.director, required this.rating, required this.details});

  factory Data.fromJson(Map<String, dynamic> json){
    return Data(
      cover: json['cover'],
      title: json['title'],
      year: json['year'],
      director: json['director'],
      rating: json['rating'],
      details: json['details']
    );
  }
}

void main(){
  var data = """
  {
    "results": {
      "result": [
        {
            "cover": "http://ia.media-imdb.com/images/M/MV5BMjMyOTM4MDMxNV5BMl5BanBnXkFtZTcwNjIyNzExOA@@._V1._SX54_CR0,0,54,74_.jpg",
            "title": "The Amazing Spider-Man",
            "year": "(2012",
            "director": "Marc Webb",
            "rating": "7.3",
            "details": "http://www.imdb.com/title/tt0948470/"
        },
        {
            "cover": "http://i.media-imdb.com/images/SF1f0a42ee1aa08d477a576fbbf7562eed/realm/feature.gif",
            "title": "The Amazing Spider-Man 2",
            "year": "(2014",
            "director": "N/A",
            "rating": "N/A",
            "details": "http://www.imdb.com/title/tt1872181/"
        },
        {
            "cover": "http://ia.media-imdb.com/images/M/MV5BMzk3MTE5MDU5NV5BMl5BanBnXkFtZTYwMjY3NTY3._V1._SX54_CR0,0,54,74_.jpg",
            "title": "Spider-Man",
            "year": "(2002",
            "director": "Sam Raimi",
            "rating": "7.3",
            "details": "http://www.imdb.com/title/tt0145487/"
        },
        {
            "cover": "http://ia.media-imdb.com/images/M/MV5BODUwMDc5Mzc5M15BMl5BanBnXkFtZTcwNDgzOTY0MQ@@._V1._SX54_CR0,0,54,74_.jpg",
            "title": "Spider-Man 3",
            "year": "(2007",
            "director": "Sam Raimi",
            "rating": "6.3",
            "details": "http://www.imdb.com/title/tt0413300/"
        },
        {
            "cover": "http://ia.media-imdb.com/images/M/MV5BMjE1ODcyODYxMl5BMl5BanBnXkFtZTcwNjA1NDE3MQ@@._V1._SX54_CR0,0,54,74_.jpg",
            "title": "Spider-Man 2",
            "year": "(2004",
            "director": "Sam Raimi",
            "rating": "7.5",
            "details": "http://www.imdb.com/title/tt0316654/"
        }
      ]
    }
  }
  """;

  var response = Response.fromJson(jsonDecode(data));
  for(var item in response.results.result){
    print('Cover - ${item.cover}');
    print('Title - ${item.title}');
    print('Year - ${item.year}');
    print('Director - ${item.director}');
    print('Rating - ${item.rating}');
    print('Details - ${item.details}\n');
  }

}
