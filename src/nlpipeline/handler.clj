(ns nlpipeline.handler
  (:use compojure.core)
  (:use nlpipeline.nlp)
  (:require [compojure.handler :as handler]
            [compojure.route :as route]
            [clojure.data.json :as json]))


; TODO: specify anntoators as query params
(defroutes app-routes
  (POST "/document/" {body :body}
    (let [text (slurp body)
          doc (nlpipeline.nlp/process-doc text)]
      {:status 200
       :headers {"Content-Type" "application/json"}
       :body (json/write-str doc)}))
   (GET "/" []
     {:status 200    
      :headers {"Content-Type" "text/html"}
      :body "
      <html>
      <head><title>NLPipeline</title></head>
      <body>
        Try posting a string to /document/
      </body>
      </html>"})

  (route/not-found "Not Found"))

(def app
  (handler/site app-routes))
