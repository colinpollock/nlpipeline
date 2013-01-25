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
       :body doc}))

  (route/not-found "Not Found"))

(def app
  (handler/site app-routes))
