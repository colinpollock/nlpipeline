(defproject nlpipeline "0.1.0-SNAPSHOT"
  :description "FIXME: write description"
  :url "http://example.com/FIXME"
  :dependencies [[org.clojure/clojure "1.4.0"]
                 [compojure "1.1.5"]
                 [org.clojure/data.json "0.2.0"]
                 [edu.stanford.nlp/stanford-corenlp "1.3.4"]
                 [edu.stanford.nlp/stanford-corenlp "1.3.4" :classifier "models"]]

  :plugins [[lein-ring "0.8.2"]]
  :ring {:handler nlpipeline.handler/app}
  :profiles
  {:dev {:dependencies [[ring-mock "0.1.3"]]}}
  :main nlpipeline.nlp)

