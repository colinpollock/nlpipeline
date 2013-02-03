# nlpipeline

Thin wrapper around the Stanford NLP tools and a web service exposing them.


Example Usage
-------------
Using [httpie](https://github.com/jkbr/httpie):

```
$ echo "I am Reggie Miller." | http POST http://localhost:3000/document/
HTTP/1.1 200 OK
Content-Length: 208
Content-Type: application/json;charset=ISO-8859-1
Date: Sun, 27 Jan 2013 07:13:06 GMT
Server: Jetty(7.6.1.v20120215)

[
    [
        {
            "lemma": "I", 
            "pos": "PRP", 
            "text": "I"
        }, 
        {
            "lemma": "be", 
            "pos": "VBP", 
            "text": "am"
        }, 
        {
            "lemma": "Reggie", 
            "pos": "NNP", 
            "text": "Reggie"
        }, 
        {
            "lemma": "Miller", 
            "pos": "NNP", 
            "text": "Miller"
        }, 
        {
            "lemma": ".", 
            "pos": ".", 
            "text": "."
        }
    ]
]
```

TODO
----
