# nlpipeline

Thin wrapper around the Stanford NLP tools and a web service exposing them.


Example Usage
-------------

### Running Locally
```$ lein ring server```


### Using [httpie](https://github.com/jkbr/httpie):
```
$ echo "I am Reggie Miller." | http POST  http://nlpipeline.herokuapp.com/document/
HTTP/1.1 200 OK
Connection: keep-alive
Content-Type: application/json;charset=ISO-8859-1
Date: Sun, 03 Feb 2013 22:22:43 GMT
Server: Jetty(7.6.1.v20120215)
transfer-encoding: chunked

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
* Tests
* Handle sentence, not just full document
* Optionally pass in a config specifying which pipes to use
* Add constituency and dependency parsers
* Profiling (time per doc etc.)
